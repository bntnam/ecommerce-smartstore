package com.bntn.smartstore.service;

import com.bntn.smartstore.model.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> findAll();

    Phone findOne(Long id);

    Phone save(Phone phone);

    void removeOne(Long id);

    List<Phone> findByBrand(String brand);

    List<Phone> blurrySearch(String model);
}
