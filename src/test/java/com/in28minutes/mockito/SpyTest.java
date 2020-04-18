package com.in28minutes.mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class SpyTest {

	@Test
	public void test() {
		List<String> arrayListSpy = spy(ArrayList.class);		
		arrayListSpy.add("Dummy");
		stub(arrayListSpy.size()).toReturn(3);
		
		verify(arrayListSpy).add("Dummy");
		verify(arrayListSpy,never()).clear();
		assertEquals(3, arrayListSpy.size());
	}

}
