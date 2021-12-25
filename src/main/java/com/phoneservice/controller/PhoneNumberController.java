package com.phoneservice.controller;


import com.phoneservice.controller.dto.GetPhoneNumbersResponse;
import com.phoneservice.controller.dto.PhoneNumberDto;
import com.phoneservice.domain.PhoneNumber;
import com.phoneservice.service.PhoneNumberService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController()
@AllArgsConstructor
public class PhoneNumberController {

    private final PhoneNumberService phoneNumberService;

    @GetMapping(value = "/phones")
    @CrossOrigin
    public ResponseEntity<GetPhoneNumbersResponse> getPhones(Pageable pageable){
        List<PhoneNumberDto> phoneNumberList =  new ArrayList<>();
        Page<PhoneNumber> resultPage = phoneNumberService.getPage(pageable);
        for (PhoneNumber phoneNumberRec :resultPage.toList() )
            phoneNumberList.add(new PhoneNumberDto(phoneNumberRec));
        return ResponseEntity.ok( new GetPhoneNumbersResponse(phoneNumberList, resultPage.getTotalElements()));
    }


    @RequestMapping("/")
    public String checkIfAvailable(){
        return "The Service is available";
    }

}
