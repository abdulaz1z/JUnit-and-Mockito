package com.abdul.maven.calculator.calculator;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorImplTest {
	private int a,b,expectedResult;
	
	public CalculatorImplTest(int a, int b, int expectedResult) {
		this.a = a;
		this.b = b;
		this.expectedResult = expectedResult;
	}
	
	@Parameters
	public static Collection<Integer[]> data(){
		return Arrays.asList(new Integer[][] {
			{-1, 2, 1},
			{1, 2, 3},
			{5, 5, 10}
			});
	}

	@Test
	public void addShouldReturnAResult() {
		Calculator calc = new CalculatorImpl();
		int result = calc.add(a, b);
		assertEquals(expectedResult, result);
	}

}
