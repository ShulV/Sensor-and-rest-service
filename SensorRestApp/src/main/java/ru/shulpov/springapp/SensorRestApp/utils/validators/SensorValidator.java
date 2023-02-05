package ru.shulpov.springapp.SensorRestApp.utils.validators;

import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.shulpov.springapp.SensorRestApp.models.Sensor;
import ru.shulpov.springapp.SensorRestApp.services.SensorService;

import java.util.Optional;

@Component
public class SensorValidator implements Validator {
    private final SensorService sensorService;

    @Autowired
    public SensorValidator(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @Override
    public boolean supports(@NotNull Class<?> clazz) {
        return Sensor.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Sensor sensor = (Sensor) target;
        Optional<Sensor> sensorFromDB = sensorService.findByName(sensor.getName());
        if (sensorFromDB.isPresent()) {
            errors.rejectValue("name", "", "Sensor with the same name already exists");
        }
    }
}
