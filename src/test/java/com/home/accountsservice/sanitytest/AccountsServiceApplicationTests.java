package com.home.accountsservice.sanitytest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {"test.param1=Test", "test.param2=Test"})
class AccountsServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
