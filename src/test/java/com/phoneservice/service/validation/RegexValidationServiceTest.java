package com.phoneservice.service.validation;


import com.phoneservice.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class RegexValidationServiceTest {

    @Autowired
    private PhoneNumberRegexValidationService validationService;


    @Test
    void validCameroonNumber() {
        CameroonPhoneNumber validNumber = new CameroonPhoneNumber();
        validNumber.setNumber("(237) 699209115");
        validationService.validateCameroonNumber(validNumber);

        assertEquals(true, validNumber.isValid());
    }

    @Test
    void invalidCameroonNumber(){
        CameroonPhoneNumber invalidNumber = new CameroonPhoneNumber();
        invalidNumber.setNumber("(237) 199209115");

        validationService.validateCameroonNumber(invalidNumber);
        assertEquals(false, invalidNumber.isValid());
    }


    @Test
    void validEthiopiaNumber() {
        EthiopiaPhoneNumber validNumber = new EthiopiaPhoneNumber();
        validNumber.setNumber("(251) 911168450");
        validationService.validateEthiopiaNumber(validNumber);

        assertEquals(true, validNumber.isValid());
    }

    @Test
    void invalidEthiopiaNumber(){
        EthiopiaPhoneNumber invalidNumber = new EthiopiaPhoneNumber();
        invalidNumber.setNumber("(251) 811168450");

        validationService.validateEthiopiaNumber(invalidNumber);
        assertEquals(false, invalidNumber.isValid());
    }

    @Test
    void validMoroccoNumber() {
        MoroccoPhoneNumber validNumber = new MoroccoPhoneNumber();
        validNumber.setNumber("(212) 661734444");
        validationService.validateMoroccoNumber(validNumber);

        assertEquals(true, validNumber.isValid());
    }

    @Test
    void invalidMoroccoNumber(){
        MoroccoPhoneNumber invalidNumber = new MoroccoPhoneNumber();
        invalidNumber.setNumber("(212) 6617344445");

        validationService.validateMoroccoNumber(invalidNumber);
        assertEquals(false, invalidNumber.isValid());
    }

    @Test
    void validMozambiqueNumber() {
        MozambiquePhoneNumber validNumber = new MozambiquePhoneNumber();
        validNumber.setNumber("(258) 846565883");
        validationService.validateMozambiqueNumber(validNumber);

        assertEquals(true, validNumber.isValid());
    }

    @Test
    void invalidMozambiqueNumber(){
        MozambiquePhoneNumber invalidNumber = new MozambiquePhoneNumber();
        invalidNumber.setNumber("(258) 946565883");

        validationService.validateMozambiqueNumber(invalidNumber);
        assertEquals(false, invalidNumber.isValid());
    }

    @Test
    void validUgandaNumber() {
        UgandaPhoneNumber validNumber = new UgandaPhoneNumber();
        validNumber.setNumber("(256) 775069443");
        validationService.validateUgandaNumber(validNumber);

        assertEquals(true, validNumber.isValid());
    }

    @Test
    void invalidUgandaNumber(){
        UgandaPhoneNumber invalidNumber = new UgandaPhoneNumber();
        invalidNumber.setNumber("(256) 77506944");

        validationService.validateUgandaNumber(invalidNumber);
        assertEquals(false, invalidNumber.isValid());
    }
}
