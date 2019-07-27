package com.space.exercises.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "can not find find flight with this ID , or this flight don't have any free seats")
public class FlightException extends Exception {
}
