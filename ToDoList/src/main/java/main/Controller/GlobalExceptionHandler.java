package main.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    protected ResponseEntity<Object> handleConflict(RuntimeException ex,WebRequest request){
        String bodyOfResponse = "This should be application specific";
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ConcurrentHashMap<String,Object>> handleEntityNotFoundException(EntityNotFoundException exi){
        ConcurrentHashMap<String,Object> errorInfo = new ConcurrentHashMap<>();
        errorInfo.put("error message",exi.getMessage());
        errorInfo.put("timestamp", new Date());
        return new ResponseEntity<ConcurrentHashMap<String,Object>>(errorInfo, HttpStatus.NOT_FOUND);
    }

}
