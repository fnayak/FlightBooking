package com.finvi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {

    private int errCode;
    private String errorMsg;

    private LocalDateTime timestamp;
}
