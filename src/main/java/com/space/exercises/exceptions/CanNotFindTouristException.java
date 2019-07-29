package com.space.exercises.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ACCEPTED,reason = "Can not find tourist with this ID")
public class CanNotFindTouristException extends Exception {
}
