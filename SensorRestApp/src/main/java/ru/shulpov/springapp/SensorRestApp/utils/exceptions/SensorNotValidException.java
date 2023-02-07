package ru.shulpov.springapp.SensorRestApp.utils.exceptions;

public class SensorNotValidException extends RuntimeException {
    public SensorNotValidException(String msg) {
        super(msg);
    }
}
