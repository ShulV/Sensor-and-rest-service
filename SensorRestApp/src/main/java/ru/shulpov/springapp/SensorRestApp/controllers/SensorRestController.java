package ru.shulpov.springapp.SensorRestApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.shulpov.springapp.SensorRestApp.services.SensorService;

@RestController
@RequestMapping("/api/sensor")
public class SensorRestController {
    private final SensorService sensorService;

    @Autowired
    public SensorRestController(SensorService sensorService) {
        this.sensorService = sensorService;
    }
}
