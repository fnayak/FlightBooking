package com.finvi.repository;

import com.finvi.entity.PassengerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerInfoReposity extends JpaRepository<PassengerInfo, Long> {
}
