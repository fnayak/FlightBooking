package com.finvi.dto;


import com.finvi.entity.PassengerInfo;
import com.finvi.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlightBookRequest {

    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;
}
