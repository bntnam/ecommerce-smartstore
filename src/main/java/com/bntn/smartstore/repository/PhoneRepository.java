package com.bntn.smartstore.repository;

import com.bntn.smartstore.model.Phone;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PhoneRepository extends CrudRepository<Phone, Long> {
    List<Phone> findByCategory(String category);

    List<Phone> findByTitleContaining(String title);
}
