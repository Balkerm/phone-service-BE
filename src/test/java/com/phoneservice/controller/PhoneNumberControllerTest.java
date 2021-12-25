package com.phoneservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.phoneservice.controller.dto.GetPhoneNumbersResponse;
import com.phoneservice.controller.dto.PhoneNumberDto;
import com.phoneservice.domain.PhoneNumber;
import com.phoneservice.service.PhoneNumberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(PhoneNumberController.class)
public class PhoneNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PhoneNumberService phoneNumberService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetPhones() throws Exception {

        List<PhoneNumber> numbers = new ArrayList<>();
        numbers.add(new PhoneNumber());
        numbers.add(new PhoneNumber());
        numbers.add(new PhoneNumber());
        Page<PhoneNumber> serviceResult = new PageImpl<PhoneNumber>(numbers);
        given(phoneNumberService.getPage(PageRequest.of(0, 3)))
                .willReturn(serviceResult);

        List<PhoneNumberDto> numberDtos = new ArrayList<>();
        numberDtos.add(new PhoneNumberDto(numbers.get(0)));
        numberDtos.add(new PhoneNumberDto(numbers.get(1)));
        numberDtos.add(new PhoneNumberDto(numbers.get(2)));

        GetPhoneNumbersResponse expectedControllerResult = new GetPhoneNumbersResponse(numberDtos, 3);

        MvcResult result = mockMvc.perform(get("/phones")
                        .param("page", "0")
                        .param("size", "3"))
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(objectMapper.writeValueAsString(expectedControllerResult),
                result.getResponse().getContentAsString());
    }

}
