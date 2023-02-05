package ru.shulpov.springapp.SensorRestApp.utils.exceptions;

public class SensorNotCreatedException extends RuntimeException {
    public SensorNotCreatedException(String msg) {
        super(msg);
    }
}
