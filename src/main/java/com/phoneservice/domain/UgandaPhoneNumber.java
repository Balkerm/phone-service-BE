package com.phoneservice.domain;

import com.phoneservice.service.validation.PhoneNumberRegexValidationService;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PostLoad;


@Entity
@DiscriminatorValue("UgandaPhoneNumber")
public class UgandaPhoneNumber extends PhoneNumber{
    @Override
    public void acceptRegexValidationService(PhoneNumberRegexValidationService service) {
        service.validateUgandaNumber(this);
    }

    @PostLoad
    private void basePostLoad() {
        this.setCountry(Country.UGANDA);
    }
}
