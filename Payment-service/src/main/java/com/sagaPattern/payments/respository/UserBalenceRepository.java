package com.sagaPattern.payments.respository;

import com.sagaPattern.payments.entity.UserBalence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBalenceRepository extends JpaRepository<UserBalence,Integer> {
}
