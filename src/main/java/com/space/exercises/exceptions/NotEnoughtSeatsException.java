package com.space.exercises.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.IM_USED,reason = "All seats in this flight are sold !")
public class NotEnoughtSeatsException extends Exception {
}
