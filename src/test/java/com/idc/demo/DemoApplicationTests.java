package com.idc.demo;

import com.idc.demo.utils.PercentageCalculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	public PercentageCalculator percentageCalculator;

	@Test
	void testPercentageCalculator() {
		assertEquals(33.6f, percentageCalculator.calculatePercentage(504, 1500));
	}

}
