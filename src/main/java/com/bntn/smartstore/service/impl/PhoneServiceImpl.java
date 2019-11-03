package com.bntn.smartstore.service.impl;

import com.bntn.smartstore.model.Phone;
import com.bntn.smartstore.repository.PhoneRepository;
import com.bntn.smartstore.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> findAll() {
        List<Phone> phoneList = (List<Phone>) phoneRepository.findAll();
        List<Phone> activePhoneList = new ArrayList<>();

        for (Phone phone : phoneList) {
            if (phone.isActive()) {
                activePhoneList.add(phone);
            }
        }

        return activePhoneList;
    }

    @Override
    public Phone findOne(Long id) {
        return phoneRepository.findOne(id);
    }

    @Override
    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    @Override
    public void removeOne(Long id) {
        phoneRepository.delete(id);
    }

    @Override
    public List<Phone> findByCategory(String category) {
        List<Phone> phoneList = phoneRepository.findByCategory(category);

        List<Phone> activePhoneList = new ArrayList<>();

        for (Phone phone : phoneList) {
            if (phone.isActive()) {
                activePhoneList.add(phone);
            }
        }

        return activePhoneList;
    }

    @Override
    public List<Phone> blurrySearch(String title) {
        List<Phone> phoneList = phoneRepository.findByTitleContaining(title);
        List<Phone> activePhoneList = new ArrayList<>();

        for (Phone phone : phoneList) {
            if (phone.isActive()) {
                activePhoneList.add(phone);
            }
        }

        return activePhoneList;
    }
}
