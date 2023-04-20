package com.finvi.controller;

import com.finvi.dto.FlightBookAck;
import com.finvi.dto.FlightBookRequest;
import com.finvi.service.FlightBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightBookController {

    @Autowired
    private FlightBookService flightBookService;

    @PostMapping("/bookFlightTicket")
    public ResponseEntity<FlightBookAck> bookFlightTicket(@RequestBody FlightBookRequest flightBookRequest) {
        FlightBookAck flightBookAck = flightBookService.bookFlightTicket(flightBookRequest);
        return new ResponseEntity<>(flightBookAck, HttpStatus.CREATED);
    }
}
