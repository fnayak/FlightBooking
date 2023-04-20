package com.finvi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class TxAppException {

    @ExceptionHandler(InsufficientBalanceException.class)
    public ResponseEntity<ApiResponse> insufficientBalanceException(InsufficientBalanceException e) {

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setErrCode(HttpStatus.NOT_FOUND.value());
        apiResponse.setErrorMsg(e.getMessage());
        apiResponse.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

}
