package com.bntn.smartstore.repository;

import com.bntn.smartstore.model.security.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.stream.Stream;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    PasswordResetToken findByToken(String token);

    PasswordResetToken findByUser(String user);

    Stream<PasswordResetToken> findAllByExpiredDateLessThan(Date now);

    @Modifying
    @Query("delete from PasswordResetToken t where t.expiredDate <= ?1")
    void deleteAllExpiredSince(Date now);

}
