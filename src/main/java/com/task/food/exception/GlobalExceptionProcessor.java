package com.task.food.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionProcessor {

  @ExceptionHandler(FoodNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  @ResponseBody
  public ErrorInfo foodNotFound(HttpServletRequest req, FoodNotFoundException ex) {
    String errorMessage = "Missing food!";
    errorMessage += ex.getMsg();
    String errorURL = req.getRequestURL().toString();

    return new ErrorInfo(errorURL, errorMessage);
  }
}
