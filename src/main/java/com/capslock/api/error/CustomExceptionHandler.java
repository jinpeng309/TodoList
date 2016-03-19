package com.capslock.api.error;

import com.capslock.api.support.ErrorResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by capslock.
 */
@ControllerAdvice(annotations = {RestController.class})
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = ServerException.class)
    public final ResponseEntity<ErrorResult> handleServiceException(final ServerException ex,
            final HttpServletRequest request) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        final ErrorResult errorResult = new ErrorResult(ex.getResultCode(), ex.getMessage());
        return new ResponseEntity<>(errorResult, headers, HttpStatus.BAD_REQUEST);
    }
}
