package com.phoneservice.service;


import com.phoneservice.domain.CameroonPhoneNumber;
import com.phoneservice.domain.MoroccoPhoneNumber;
import com.phoneservice.domain.PhoneNumber;
import com.phoneservice.domain.UgandaPhoneNumber;
import com.phoneservice.repository.PhoneNumberRepository;
import com.phoneservice.service.validation.PhoneNumberRegexValidationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PhoneNumberServiceTest {

    @MockBean
    private PhoneNumberRegexValidationService validationService;

    @MockBean
    private PhoneNumberRepository phoneNumberRepository;


    @Autowired
    private PhoneNumberService phoneNumberService;

    @Test
    void testGetPageResult(){

        CameroonPhoneNumber cameroonPhoneNumber = new CameroonPhoneNumber();
        UgandaPhoneNumber ugandaPhoneNumber = new UgandaPhoneNumber();
        MoroccoPhoneNumber moroccoPhoneNumber = new MoroccoPhoneNumber();
        List<PhoneNumber> numbers = new ArrayList<>();
        numbers.add(cameroonPhoneNumber);
        numbers.add(ugandaPhoneNumber);
        numbers.add(moroccoPhoneNumber);

        Page<PhoneNumber> repositoryResult = new PageImpl<PhoneNumber>(numbers);

        given(phoneNumberRepository.findAll(PageRequest.of(0, 3)))
                .willReturn(repositoryResult);

        Page<PhoneNumber> serviceResult = phoneNumberService.getPage(PageRequest.of(0, 3));

        assertEquals(3, serviceResult.toList().size());
        assertEquals(3,serviceResult.getTotalElements());
        assertEquals(0, serviceResult.getNumber());
    }


    @Test
    void testGetPageCallsRepositoryAndValidationService(){

        CameroonPhoneNumber cameroonPhoneNumber = new CameroonPhoneNumber();
        UgandaPhoneNumber ugandaPhoneNumber = new UgandaPhoneNumber();
        MoroccoPhoneNumber moroccoPhoneNumber = new MoroccoPhoneNumber();
        List<PhoneNumber> numbers = new ArrayList<>();
        numbers.add(cameroonPhoneNumber);
        numbers.add(ugandaPhoneNumber);
        numbers.add(moroccoPhoneNumber);

        Page<PhoneNumber> repositoryResult = new PageImpl<PhoneNumber>(numbers);

        given(phoneNumberRepository.findAll(PageRequest.of(0, 3)))
                .willReturn(repositoryResult);

        Page<PhoneNumber> serviceResult = phoneNumberService.getPage(PageRequest.of(0, 3));

        verify(phoneNumberRepository, times(1)).findAll(PageRequest.of(0,3));
        verify(validationService, times(1)).validateCameroonNumber(cameroonPhoneNumber);
        verify(validationService, times(1)).validateUgandaNumber(ugandaPhoneNumber);
        verify(validationService, times(1)).validateMoroccoNumber(moroccoPhoneNumber);
    }
}
