package com.phoneservice.repository;

import com.phoneservice.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PhoneNumberRepositoryTest {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Test
    public void testFindAll() {
        Page<PhoneNumber> result = phoneNumberRepository.findAll(PageRequest.of(0, 50));
        assertEquals(43, result.getTotalElements());
        assertEquals(1, result.getTotalPages());

    }

    @Test
    public void testCorrectClassTypes() {
        Page<PhoneNumber> result = phoneNumberRepository.findAll(PageRequest.of(0, 50));
        List<PhoneNumber> numbers = result.getContent();
        for (PhoneNumber number : numbers) {
            if (number.getCountry() == Country.CAMEROON) {
                assertThat(number instanceof CameroonPhoneNumber);
                assertThat(Country.CAMEROON.getCode().equals(number.getNumber().substring(1, 4)));
            } else if (number.getCountry() == Country.ETHIOPIA) {
                assertThat(number instanceof EthiopiaPhoneNumber);
                assertThat(Country.ETHIOPIA.getCode().equals(number.getNumber().substring(1, 4)));
            } else if (number.getCountry() == Country.MOROCCO) {
                assertThat(number instanceof MoroccoPhoneNumber);
                assertThat(Country.MOROCCO.getCode().equals(number.getNumber().substring(1, 4)));
            } else if (number.getCountry() == Country.MOZAMBIQUE) {
                assertThat(number instanceof MozambiquePhoneNumber);
                assertThat(Country.MOZAMBIQUE.getCode().equals(number.getNumber().substring(1, 4)));
            } else if (number.getCountry() == Country.UGANDA) {
                assertThat(number instanceof UgandaPhoneNumber);
                assertThat(Country.UGANDA.getCode().equals(number.getNumber().substring(1, 4)));
            } else {
                assertThat(
                        !(number instanceof CameroonPhoneNumber ||
                                number instanceof EthiopiaPhoneNumber ||
                                number instanceof MoroccoPhoneNumber ||
                                number instanceof MozambiquePhoneNumber ||
                                number instanceof UgandaPhoneNumber));
            }
        }
    }
}

