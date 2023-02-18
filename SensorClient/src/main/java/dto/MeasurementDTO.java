package dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MeasurementDTO {

    private Float value;

    private Boolean raining;
    @JsonProperty("sensor")
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
