package com.phoneservice.service.validation;

import com.phoneservice.domain.PhoneNumber;

public interface PhoneNumberRegexValidationService {

    void validateCameroonNumber(PhoneNumber number);
    void validateEthiopiaNumber(PhoneNumber number);
    void validateMoroccoNumber(PhoneNumber number);
    void validateMozambiqueNumber(PhoneNumber number);
    void validateUgandaNumber(PhoneNumber number);
}
