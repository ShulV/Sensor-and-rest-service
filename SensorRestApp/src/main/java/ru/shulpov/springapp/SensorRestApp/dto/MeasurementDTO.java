package ru.shulpov.springapp.SensorRestApp.dto;


import ru.shulpov.springapp.SensorRestApp.models.Sensor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class MeasurementDTO {

    @NotEmpty(message = "Field shouldn't be empty")
    @Size(min = -100, max = 100, message = "Value should be from -100 to 100")
    private float value;

    @NotEmpty(message = "Field shouldn't be empty")
    private boolean raining;

    @NotEmpty(message = "Field shouldn't be empty")
    private Sensor sensor;

    public MeasurementDTO(float value, boolean raining, Sensor sensor) {
        this.value = value;
        this.raining = raining;
        this.sensor = sensor;
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

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
