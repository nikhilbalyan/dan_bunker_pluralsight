package com.boot.das_boot;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@DataJpaTest
@SpringBootTest
public class ShipwreckControllerWebIntegrationTest {

	@Test
	public void testListAll() throws IOException {
		RestTemplate restTemplate = new TestRestTemplate();
	}
}
