package ru.shulpov.springapp.SensorRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shulpov.springapp.SensorRestApp.models.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Integer> {
}
