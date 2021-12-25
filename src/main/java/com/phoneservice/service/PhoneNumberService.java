package com.phoneservice.service;

import com.phoneservice.domain.PhoneNumber;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PhoneNumberService {


    /**
     * Returns the page of {@link PhoneNumber}s with the given index of the given size.
     *
     * @param pageable
     * @return
     */
    Page<PhoneNumber> getPage(Pageable pageable);
}
