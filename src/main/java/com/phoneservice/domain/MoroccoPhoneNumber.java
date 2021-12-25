package com.phoneservice.domain;

import com.phoneservice.service.validation.PhoneNumberRegexValidationService;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PostLoad;

@Entity
@DiscriminatorValue("MoroccoPhoneNumber")
public class MoroccoPhoneNumber extends PhoneNumber{

    @Override
    public void acceptRegexValidationService(PhoneNumberRegexValidationService service) {
            service.validateMoroccoNumber(this);
    }

    @PostLoad
    private void basePostLoad() {
        this.setCountry(Country.MOROCCO);
    }
}
