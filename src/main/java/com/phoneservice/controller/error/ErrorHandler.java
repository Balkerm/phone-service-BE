package com.phoneservice.controller.error;

import com.phoneservice.controller.dto.ApiError;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
@Log4j2
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, HttpServletRequest request,
                                                      HttpServletResponse response, HttpStatus status) {
        log.debug("=============== Received Exception  ===============================");
        log.debug("============ ",request.getServletPath() );
        log.debug("=============== Exception Cause= ", ex.getCause());
        log.debug("=============== Exception= " + ex.getLocalizedMessage());

        ApiError apiError = new ApiError(status, ex.getLocalizedMessage()
                , ex.getCause().getLocalizedMessage());
        return new ResponseEntity<>(apiError, status);
    }
}
