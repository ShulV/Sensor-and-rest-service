package ru.shulpov.springapp.SensorRestApp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class MeasurementDTO {

    @NotNull(message = "Field shouldn't be empty")
    @Min(value = -100, message = "Value should be more than -100")
    @Max(value = 100, message = "Value shouldn't be more than 100")
    private Float value;

    @NotNull(message = "Field shouldn't be empty")
    private Boolean raining;
    @JsonProperty("sensor")
    @NotNull(message = "Field shouldn't be empty")
    private SensorDTO sensorDTO;

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }

    public Boolean isRaining() {
        return raining;
    }

    public void setRaining(Boolean raining) {
        this.raining = raining;
    }

    public SensorDTO getSensor() {
        return sensorDTO;
    }

    public void setSensor(SensorDTO sensorDTO) {
        this.sensorDTO = sensorDTO;
    }
}
