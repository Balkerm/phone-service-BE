package com.phoneservice.repository;

import com.phoneservice.domain.PhoneNumber;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PhoneNumberRepository extends PagingAndSortingRepository<PhoneNumber, Long> {
}