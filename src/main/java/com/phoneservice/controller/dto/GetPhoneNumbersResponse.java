package com.phoneservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetPhoneNumbersResponse {
    private List<PhoneNumberDto> numbers;
    private long totalCount;
}
