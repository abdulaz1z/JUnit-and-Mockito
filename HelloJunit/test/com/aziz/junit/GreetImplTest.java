package com.aziz.junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GreetImplTest {
	private Greeting greeting;

	@Before
	public void setup() {
		System.out.println("Setup");
		greeting = new GreetImpl();
	}

	@Test
	public void greetShouldReturnAValidOutput() {
		System.out.println("greetShouldReturnAValidOutput");
		String result = greeting.greet("Junit");
		assertNotNull(result);
		assertEquals("Hello Junit", result);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_For_NameIsNull() {
		System.out.println("greetShouldThrowAnException_For_NameIsNull");
		greeting.greet(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void greetShouldThrowAnException_For_NameIsEmpty() {
		System.out.println("greetShouldThrowAnException_For_NameIsEmpty");
		greeting.greet("");
	}
	
	@After
	public void tearDown() {
		System.out.println("TearDown");
		greeting = null;
	}

}
