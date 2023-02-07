package ru.shulpov.springapp.SensorRestApp.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ru.shulpov.springapp.SensorRestApp.dto.MeasurementDTO;
import ru.shulpov.springapp.SensorRestApp.models.Measurement;
import ru.shulpov.springapp.SensorRestApp.models.Sensor;
import ru.shulpov.springapp.SensorRestApp.services.MeasurementService;
import ru.shulpov.springapp.SensorRestApp.services.SensorService;
import ru.shulpov.springapp.SensorRestApp.utils.exceptions.MeasurementNotCreatedException;
import ru.shulpov.springapp.SensorRestApp.utils.responses.MeasurementErrorResponse;
import ru.shulpov.springapp.SensorRestApp.utils.validators.SensorValidator;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/measurements")
public class MeasurementRestController {
    private final MeasurementService measurementService;
    private final SensorService sensorService;
    private final ModelMapper modelMapper;

    @Autowired
    public MeasurementRestController(MeasurementService measurementService, SensorService sensorService,
                                     ModelMapper modelMapper) {
        this.measurementService = measurementService;
        this.sensorService = sensorService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<HttpStatus> add(@RequestBody @Valid MeasurementDTO measurementDTO,
                                          BindingResult bindingResult) {

        Measurement measurement = convertToMeasurement(measurementDTO);
        Optional<Sensor> foundSensor = sensorService.findByName(measurement.getSensor().getName());
        if (foundSensor.isEmpty()) {
            ObjectError error = new FieldError("sensor", "sensor", "no such sensor");
            bindingResult.addError(error);

        }
        //проверка ошибок
        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            StringBuilder errorMsg = new StringBuilder();
            for (FieldError error: errors) {
                errorMsg
                        .append(error.getField())
                        .append(" - ")
                        .append(error.getDefaultMessage())
                        .append(";");
            }

            throw new MeasurementNotCreatedException(errorMsg.toString());
        }
        //

        measurementService.save(measurement);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementNotCreatedException e) {
        MeasurementErrorResponse measurementErrorResponse = new MeasurementErrorResponse(
                e.getMessage(),
                System.currentTimeMillis());
        return new ResponseEntity<>(measurementErrorResponse, HttpStatus.BAD_REQUEST);
    }

    private Measurement convertToMeasurement(MeasurementDTO measurementDTO) {
        return modelMapper.map(measurementDTO, Measurement.class);
    }
}
