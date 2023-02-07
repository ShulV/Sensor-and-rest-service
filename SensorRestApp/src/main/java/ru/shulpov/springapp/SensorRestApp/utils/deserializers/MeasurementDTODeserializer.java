package ru.shulpov.springapp.SensorRestApp.utils.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import ru.shulpov.springapp.SensorRestApp.dto.MeasurementDTO;
import ru.shulpov.springapp.SensorRestApp.dto.SensorDTO;

import java.io.IOException;

public class MeasurementDTODeserializer extends JsonDeserializer<MeasurementDTO> {
    @Override
    public MeasurementDTO deserialize(JsonParser p, DeserializationContext deserializationContext)
            throws IOException, JacksonException {
        JsonNode node = p.getCodec().readTree(p);
        MeasurementDTO measurementDTO = new MeasurementDTO();
        measurementDTO.setValue(node.get("value").floatValue());
        measurementDTO.setRaining(node.get("raining").asBoolean());
        SensorDTO sensorDTO = new SensorDTO(node.get("sensor.name").asText());

        measurementDTO.setSensorDTO(sensorDTO);
        return measurementDTO;
    }
}
