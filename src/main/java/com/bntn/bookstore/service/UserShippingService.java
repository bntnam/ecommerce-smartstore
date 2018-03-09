package com.bntn.bookstore.service;

import com.bntn.bookstore.model.UserShipping;

public interface UserShippingService {
    UserShipping findById(Long id);

    void removeById(Long id);
}
