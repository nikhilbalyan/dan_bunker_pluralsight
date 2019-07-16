package com.boot.das_boot;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.das_boot.controller.ShipwreckController;
import com.boot.das_boot.model.Shipwreck;
import com.boot.das_boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
//		when(shipwreckRepository.findById(1l)).thenReturn(sw);
	}
	

	@Test
	public void testShipwreckGet() {
//		ShipwreckController sc = new ShipwreckController();
		Shipwreck shipWreck = new Shipwreck();
		shipWreck.setId(1L);
		when(shipwreckRepository.findById(1L)).thenReturn(Optional.of(shipWreck));
		
		Shipwreck wreck = sc.get(1L).get();
		assertEquals(1L, wreck.getId().longValue());
	}
}

