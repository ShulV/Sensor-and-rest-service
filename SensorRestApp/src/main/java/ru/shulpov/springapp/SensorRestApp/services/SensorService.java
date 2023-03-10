package ru.shulpov.springapp.SensorRestApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.shulpov.springapp.SensorRestApp.models.Sensor;
import ru.shulpov.springapp.SensorRestApp.repositories.SensorRepository;
import ru.shulpov.springapp.SensorRestApp.utils.exceptions.SensorNotValidException;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SensorService {
    private final SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Transactional
    public void save(Sensor sensor) {
        sensorRepository.save(sensor);
    }

    public Optional<Sensor> findByName(String name) {
        return sensorRepository.findByName(name);
    }

    public Optional<Sensor> findById(int id) {
        Optional<Sensor> foundSensor = sensorRepository.findById(id);
        return foundSensor;
    }
}
