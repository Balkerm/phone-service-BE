package com.phoneservice.service;

import com.phoneservice.domain.PhoneNumber;
import com.phoneservice.repository.PhoneNumberRepository;
import com.phoneservice.service.validation.PhoneNumberRegexValidationService;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Log4j2
@Service
@AllArgsConstructor
public class PhoneNumberServiceImpl implements PhoneNumberService {

    private final PhoneNumberRepository phoneNumberRepository;
    private final PhoneNumberRegexValidationService phoneNumberRegexValidationService;


    @Override
    public Page<PhoneNumber> getPage(Pageable pageable){
        Page<PhoneNumber> result = phoneNumberRepository
                .findAll(pageable);
        for (PhoneNumber number : result.toList()){
            number.acceptRegexValidationService(phoneNumberRegexValidationService);
        }
        return result;
    }
}
