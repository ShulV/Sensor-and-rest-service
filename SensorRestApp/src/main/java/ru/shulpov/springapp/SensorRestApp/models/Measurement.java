package ru.shulpov.springapp.SensorRestApp.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "measurement")
public class Measurement {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "value")
    private float value;

    @Column(name = "raining")
    private boolean raining;

    @Column(name = "timestamp")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name="sensor_id", referencedColumnName = "id")
    private Sensor sensor;

    public Measurement() {
    }

    public Measurement(long id, float value, boolean raining, LocalDate date) {
        this.id = id;
        this.value = value;
        this.raining = raining;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Sensor getSensor() {
        return sensor;
    }

    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}
