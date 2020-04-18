package com.in28minutes.powermock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SystemUnderTest.class) // Estamos mockando o ArrayList(), porém, a classe que utiliza o array list é a
										// SystemUnderTest.class
public class MokingConstructorTest {

	@InjectMocks
	SystemUnderTest systemUnderTest;

	@Mock
	ArrayList mockList;

	@Test
	public void testBadNames() throws Exception {
		List<Integer> stats = Arrays.asList(1, 2, 3);
		when(mockList.size()).thenReturn(5);

		PowerMockito.whenNew(ArrayList.class).withAnyArguments().thenReturn(mockList);

		int size = systemUnderTest.methodUsingAnArrayListConstructor();

		assertEquals(5, size);
	}

}
