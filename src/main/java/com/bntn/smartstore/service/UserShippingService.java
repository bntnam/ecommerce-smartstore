package com.bntn.smartstore.service;

import com.bntn.smartstore.model.UserShipping;

public interface UserShippingService {
    UserShipping findById(Long id);

    void removeById(Long id);
}
