package com.home.accountsservice.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * In this test, the full Spring application context is started but without the server
 * */
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void addCustomer ( ) throws Exception {
        this.mockMvc.perform ( post ( "/customer/add" ) ).andDo ( print ( ) ).andExpect ( status ( ).isOk ( ) );
        System.out.println ( "Customers added Successfully" );
    }

    @Test
    public void getCustomer ( ) throws Exception {
        MvcResult mvcResult = this.mockMvc.perform ( get ( "/customer/1" ) ).andReturn ( );
        String contentAsString = mvcResult.getResponse ( ).getContentAsString ( );
        System.out.println ( "Success: " + contentAsString );
        assert (contentAsString.isEmpty ( ) == false);
    }
}