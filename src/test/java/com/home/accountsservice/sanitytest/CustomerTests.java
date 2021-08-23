package com.home.accountsservice.sanitytest;

import com.home.accountsservice.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*This test is the testing of web layer. ALso we can say sanity test
* This test needs web app to be running on specified port
* */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerTests {

    //@LocalServerPort
    private int port = 2221;

    @Autowired
    private TestRestTemplate restTemplate;

    public String BASE_URL = new StringBuilder().append("http://localhost:").append(port).toString();

    @Test
    public void getCustomers() throws Exception {

        this.restTemplate.postForEntity(BASE_URL + "/customer/add",
                new Customer(1, "Test", "data"), String.class);
        assert (this.restTemplate.getForObject(BASE_URL + "/customer/all",
                List.class).size() > 1);
    }

    @Test
    public void deleteCustomers() {
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("id", 1);
        restTemplate.delete(BASE_URL + "/customer/remove", params);
    }

    public String getBASE_URL() {
        return BASE_URL;
    }
}