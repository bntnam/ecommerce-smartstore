package com.bntn.bookstore.service;

import com.bntn.bookstore.model.User;
import com.bntn.bookstore.model.UserBilling;
import com.bntn.bookstore.model.UserPayment;
import com.bntn.bookstore.model.UserShipping;
import com.bntn.bookstore.model.security.PasswordResetToken;
import com.bntn.bookstore.model.security.UserRole;

import java.util.Set;

public interface UserService {

    PasswordResetToken getPasswordResetToken(final String token);

    void createPasswordResetTokenForUser(final User user, final String token);

    User findByUsername(String username);

    User findByEmail(String email);

    User createUser(User user, Set<UserRole> userRoles) throws Exception;

    User save(User user);

    void updateUserBilling(UserBilling userBilling, UserPayment userPayment, User user);

    void setUserDefaultPayment(Long userPaymentId, User user);

    void updateUserShipping(UserShipping userShipping, User user);

    void setUserDefaultShipping(Long userShippingId, User user);

    User findById(Long id);
}
