package com.speed.user.service;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

class UserServiceApplicationTests {

	private Calculator c = new Calculator();

	@Test
	@Disabled
	void contextLoads() {
	}

	@Test
	@Disabled
	void testSum(){
		int actResult = c.doSum(4,8);
		int expResult = 12;
		assertThat(actResult).isEqualTo(expResult);
	}

	@Test
	void testProduct(){
		int actResult = c.doProduct(5,8);
		int expResult = 40;
		assertThat(actResult).isEqualTo(expResult);
	}

	@Test
	void testCompare(){
		Boolean actResult = c.compareTwoNums(5,8);
		assertThat(actResult).isFalse();
	}


}
