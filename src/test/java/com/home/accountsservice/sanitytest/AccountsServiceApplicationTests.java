package com.home.accountsservice.sanitytest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(properties = {"test.param1=Test", "test.param2=Test"})
@ActiveProfiles("test")
class AccountsServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
