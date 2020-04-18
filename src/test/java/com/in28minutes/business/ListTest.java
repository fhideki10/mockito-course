package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Test;

public class ListTest {

	@Test
	public void letsMockListSizeMethod() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2);

		assertEquals(2, listMock.size());	
		assertEquals(2, listMock.size());
		assertEquals(2, listMock.size());
	}
	
	@Test
	public void letsMockListSizeMethod_ReturnMultipleValues() {
		List listMock = mock(List.class);
		when(listMock.size()).thenReturn(2).thenReturn(3); //Na primeira chamada retornará 2 e nas seguintes 3
		
		assertEquals(2, listMock.size());		
		assertEquals(3, listMock.size());
	}
	
	@Test
	public void letsMockListGet() {
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("in28Minutes");
		
		String firstElement = listMock.get(0);
		String secondElement = listMock.get(1);
		
		assertThat(firstElement, is("in28Minutes"));		
		assertThat(secondElement, is("in28Minutes"));	
	}
	
	@Test(expected=RuntimeException.class)
	public void letsMockList_throwAnException() {
		List listMock = mock(List.class);
		when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
		
		listMock.get(0);
	}
	
	@Test(expected=RuntimeException.class)
	public void letsMockList_mixingUp() {
		List<String> listMock = mock(List.class);
		given(listMock.subList(anyInt(), 5)).willThrow(new RuntimeException("Something"));
		listMock.subList(2, 4);	
	}
	
	@Test
	public void letsMockListGet_usingBDD() {
		//Given
		List<String> listMock = mock(List.class);
		given(listMock.get(anyInt())).willReturn("in28Minutes");
		//When
		String firstElement = listMock.get(0);
		//Then
		assertThat(firstElement, is("in28Minutes"));	
	}

}
