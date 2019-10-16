package com.bntn.smartstore.service;

import com.bntn.smartstore.model.User;
import com.bntn.smartstore.model.UserBilling;
import com.bntn.smartstore.model.UserPayment;
import com.bntn.smartstore.model.UserShipping;
import com.bntn.smartstore.model.security.PasswordResetToken;
import com.bntn.smartstore.model.security.UserRole;

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
