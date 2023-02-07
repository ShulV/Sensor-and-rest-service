package ru.shulpov.springapp.SensorRestApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.shulpov.springapp.SensorRestApp.models.Sensor;
import ru.shulpov.springapp.SensorRestApp.utils.deserializers.MeasurementDTODeserializer;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MeasurementDTO {

    @NotEmpty(message = "Field shouldn't be empty")
    @Size(min = -100, max = 100, message = "Value should be from -100 to 100")
    private float value;

    @NotEmpty(message = "Field shouldn't be empty")
    private boolean raining;

    @NotEmpty(message = "Field shouldn't be empty")
    @JsonProperty("sensor")
    private SensorDTO sensorDTO;

    public MeasurementDTO(float value, boolean raining, SensorDTO sensorDTO) {
        this.value = value;
        this.raining = raining;
        this.sensorDTO = sensorDTO;
    }

    public MeasurementDTO() {

    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isRaining() {
        return raining;
    }

    public void setRaining(boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensorDTO() {
        return sensorDTO;
    }

    public void setSensorDTO(SensorDTO sensorDTO) {
        this.sensorDTO = sensorDTO;
    }
}
