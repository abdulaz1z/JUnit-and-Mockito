package com.aziz.scrapbook;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class ATest {
	@Mock
	B b;
	private A a;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		a = new A(b);
		
	}

	@Test
	public void usesVoidMethod_Should_Call_The_voidMethod() throws Exception {
		doNothing().when(b).voidMethod();
		assertEquals(1, a.usesVoidMethod());
		verify(b).voidMethod();	
	}
	
	@Test(expected = RuntimeException.class)
	public void usesVoidMethod_Should_Throw_RuntimeException() throws Exception {
		doThrow(Exception.class).when(b).voidMethod();
		a.usesVoidMethod();
	}
	
	@Test(expected = RuntimeException.class)
	public void test_Consecutive_Calls() throws Exception {
		doNothing().doThrow(Exception.class).when(b).voidMethod();
		a.usesVoidMethod();
		
		verify(b).voidMethod();
		
		a.usesVoidMethod();
	}

}
