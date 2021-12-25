package com.phoneservice;

import com.phoneservice.controller.dto.GetPhoneNumbersResponse;
import com.phoneservice.controller.dto.PhoneNumberDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PhoneServiceIntegrationTests {


	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	void testServiceIsAvailable() {
		assertThat(restTemplate.getForObject("/",
				String.class)).contains("The Service is available");
	}

	@Test
	void testGetPhoneNumberPage(){
		ResponseEntity<GetPhoneNumbersResponse> responseEntity =
				restTemplate.getForEntity("/phones?size=10&page=0",GetPhoneNumbersResponse.class);

		GetPhoneNumbersResponse response = responseEntity.getBody();
		List<PhoneNumberDto> numbers = response.getNumbers();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(10, numbers.size());
		assertEquals(43, response.getTotalCount());
		assertEquals(0, numbers.get(0).getId());
		assertEquals(9, numbers.get(9).getId());

	}

	@Test
	void testGetPhoneNumberLastPage(){
		ResponseEntity<GetPhoneNumbersResponse> responseEntity =
				restTemplate.getForEntity("/phones?size=10&page=4",GetPhoneNumbersResponse.class);

		GetPhoneNumbersResponse response = responseEntity.getBody();
		List<PhoneNumberDto> numbers = response.getNumbers();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(3, numbers.size());
		assertEquals(43, response.getTotalCount());
		assertEquals(40, numbers.get(0).getId());
		assertEquals(41, numbers.get(1).getId());
		assertEquals(42, numbers.get(2).getId());


	}

	@Test
	void testGetPhoneNumberDefaultPage(){
		ResponseEntity<GetPhoneNumbersResponse> responseEntity =
				restTemplate.getForEntity("/phones",GetPhoneNumbersResponse.class);

		GetPhoneNumbersResponse response = responseEntity.getBody();
		List<PhoneNumberDto> numbers = response.getNumbers();

		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(20, numbers.size());
		assertEquals(43, response.getTotalCount());
		assertEquals(0, numbers.get(0).getId());
		assertEquals(19, numbers.get(19).getId());
	}

}
