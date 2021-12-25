package com.phoneservice.domain;

import com.phoneservice.service.validation.PhoneNumberRegexValidationService;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PostLoad;

@Entity
@DiscriminatorValue("EthiopiaPhoneNumber")
public class EthiopiaPhoneNumber extends PhoneNumber{

    @Override
    public void acceptRegexValidationService(PhoneNumberRegexValidationService service) {
        service.validateEthiopiaNumber(this);
    }

    @PostLoad
    private void basePostLoad() {
        this.setCountry(Country.ETHIOPIA);
    }
}
