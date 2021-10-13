package com.radeckiy.authservice.api.exception;

import javassist.NotFoundException;

public class NotFoundUserException extends NotFoundException {
    public NotFoundUserException() {
        super("Пользователь с таким ID не найден!");
    }
}
