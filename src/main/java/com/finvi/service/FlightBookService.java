package com.finvi.service;

import com.finvi.dto.FlightBookAck;
import com.finvi.dto.FlightBookRequest;
import com.finvi.entity.PassengerInfo;
import com.finvi.entity.PaymentInfo;
import com.finvi.repository.PassengerInfoReposity;
import com.finvi.repository.PaymentInfoRepository;
import com.finvi.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class FlightBookService {

    @Autowired
    private PassengerInfoReposity passengerInfoReposity;

    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public FlightBookAck bookFlightTicket(FlightBookRequest flightBookRequest) {

        PassengerInfo passengerInfo = flightBookRequest.getPassengerInfo();
        passengerInfo = passengerInfoReposity.save(passengerInfo);

        PaymentInfo paymentInfo = flightBookRequest.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getPId());
        paymentInfo.setAmount(passengerInfo.getFare());

        paymentInfo = paymentInfoRepository.save(paymentInfo);

        return new FlightBookAck("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);

    }
}
