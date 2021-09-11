package edu.web.application.api.advice;

import edu.web.application.api.dto.ErrorDto;
import edu.web.application.api.dto.ErrorValidationDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@ControllerAdvice(annotations = RestController.class)
public class ProjectExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    private static final String EMPTY = "";

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorDto> handleAll(Exception ex) {
        String message = Optional.ofNullable(messageSource.getMessage(
                "error.internal.server",
                null,
                null,
                Locale.getDefault())).orElse(EMPTY);
        return createResponseErrorDto(ex, message);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        final List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        Map<String, Set<String>> errorsMap = fieldErrors.stream().collect(
                Collectors.groupingBy(FieldError::getField,
                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.toSet())
                )
        );

        ErrorValidationDto validationDto = new ErrorValidationDto(EMPTY, errorsMap);

        return new ResponseEntity<>(errorsMap.isEmpty() ? ex : validationDto, headers, HttpStatus.BAD_REQUEST);
    }


    private ResponseEntity<ErrorDto> createResponseErrorDto(Exception e, String message) {
        log.error("Throw exception in controller.", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorDto.builder().message(message).build());
    }
}
