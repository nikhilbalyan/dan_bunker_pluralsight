package com.boot.das_boot;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
//@DataJpaTest
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
//@IntegrationTest("server.port=8080")
public class ShipwreckControllerWebIntegrationTest {

	@Autowired
	Environment environment;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@LocalServerPort
    int port;
	
	@Test
	public void testListAll() throws IOException {
//		RestTemplate restTemplate = new TestRestTemplate();
//		String port = environment.getProperty("local.server.port");
		System.out.println("-------------------"+port);
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:"+port+"/api/v1/shipwrecks", String.class);
		
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		
		

		ObjectMapper objectMapper = new ObjectMapper();
		JsonNode responseJson = objectMapper.readTree(response.getBody());
		
		assertThat(responseJson.isMissingNode(), is(false));
		assertThat(responseJson.toString(), equalTo("[]"));
		
	}
}
