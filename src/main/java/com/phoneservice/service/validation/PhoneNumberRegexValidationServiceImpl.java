package com.phoneservice.service.validation;

import com.phoneservice.domain.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.regex.Pattern;

@Service
public class PhoneNumberRegexValidationServiceImpl  implements PhoneNumberRegexValidationService{

    private  Pattern CAMEROON_PATTERN;
    private  Pattern ETHIOPIA_PATTERN ;
    private  Pattern MOROCCO_PATTERN ;
    private  Pattern MOZAMBIQUE_PATTERN ;
    private  Pattern UGANDA_PATTERN ;

    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
        CAMEROON_PATTERN = Pattern.compile(environment.getProperty("cameron.regex"));
        ETHIOPIA_PATTERN = Pattern.compile(environment.getProperty("ethiopia.regex"));
        MOROCCO_PATTERN = Pattern.compile(environment.getProperty("morocco.regex"));
        MOZAMBIQUE_PATTERN = Pattern.compile(environment.getProperty("mozambique.regex"));
        UGANDA_PATTERN = Pattern.compile(environment.getProperty("uganda.regex"));
    }

    @Override
    public void validateCameroonNumber(PhoneNumber number) {
        number.setValid(CAMEROON_PATTERN.matcher(number.getNumber()).find());
    }

    @Override
    public void validateEthiopiaNumber(PhoneNumber number) {

        number.setValid(ETHIOPIA_PATTERN.matcher(number.getNumber()).find());
    }

    @Override
    public void validateMoroccoNumber(PhoneNumber number) {

        number.setValid(MOROCCO_PATTERN.matcher(number.getNumber()).find());
    }

    @Override
    public void validateMozambiqueNumber(PhoneNumber number) {
        number.setValid(MOZAMBIQUE_PATTERN.matcher(number.getNumber()).find());
    }

    @Override
    public void validateUgandaNumber(PhoneNumber number) {
        number.setValid(UGANDA_PATTERN.matcher(number.getNumber()).find());
    }
}
