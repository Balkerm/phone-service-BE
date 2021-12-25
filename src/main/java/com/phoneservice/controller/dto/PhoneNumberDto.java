package com.phoneservice.controller.dto;

import com.phoneservice.domain.Country;
import com.phoneservice.domain.PhoneNumber;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhoneNumberDto {
    private long id;
    private String customerName;
    private String number;
    private Country country;
    private boolean valid;

    public PhoneNumberDto(PhoneNumber phoneNumberRecord){
        this.id = phoneNumberRecord.getId();
        this.customerName = phoneNumberRecord.getCustomerName();
        this.number = phoneNumberRecord.getNumber();
        this.country = phoneNumberRecord.getCountry();
        this.valid = phoneNumberRecord.isValid();
    }
}
