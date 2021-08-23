package com.home.accountsservice.controller;

import com.home.accountsservice.model.Customer;
import com.home.accountsservice.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * Purpose of this is to test only web layer without starting app.
 * This test will only start web layer not whole application context
 * */
@WebMvcTest(CustomerController.class)
public class WebLayerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService service;

    @BeforeEach
    public void addCustomer ( ) throws Exception {
        this.mockMvc.perform ( post ( "/customer/add" ) ).andDo ( print ( ) ).andExpect ( status ( ).isOk ( ) );
        System.out.println ( "Customers added Successfully" );
    }

    @Test
    public void getCustomer ( ) throws Exception {
        when ( service.getCustomerById ( Mockito.anyLong ( ) ) ).thenReturn ( new Customer ( 1, "Test", "Pooja" ) );
        MvcResult mvcResult = this.mockMvc.perform ( get ( "/customer/1" ) ).andReturn ( );
        String contentAsString = mvcResult.getResponse ( ).getContentAsString ( );
        System.out.println ( "Success: " + contentAsString );
        assert (contentAsString.isEmpty ( ) == false);
    }
}