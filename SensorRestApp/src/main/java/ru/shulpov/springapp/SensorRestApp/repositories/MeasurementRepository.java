package ru.shulpov.springapp.SensorRestApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shulpov.springapp.SensorRestApp.models.Measurement;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {
    Integer countByRainingTrue();
}
