package com.sagaPattern.payments.respository;

import com.sagaPattern.payments.entity.UserTransction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTransctionRepository extends JpaRepository<UserTransction,Integer> {
}
