
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.abs;


public class SensorClient {
    public static void main(String[] args) {
        final String sensorName = "Moon-sensor";
        registerSensor(sensorName);
        Random random = new Random();
        Float currentTemp = random.nextFloat() * 100 - 50;//начальная температура
        Boolean raining;
        for (int i=0; i< 100; i++) {
            currentTemp = currentTemp + (random.nextFloat() * 2 - 1);//добавляем/отнимаем величину от -1 до +1 градуса
            if (currentTemp > 0) {
                raining = random.nextBoolean();
            } else {
                raining = false;
            }
            addMeasurement(currentTemp, raining, sensorName);
        }
    }

    private static Float getRandomFloat(Random random, Float start, Float end) {
        return random.nextFloat() * (abs(start) + abs(end)) - end;
    }
    public static void registerSensor(String sensorName) {
        final String url = "http://localhost:8095/api/sensors/registration";
        Map<String, Object> sensorJson = new HashMap<>();
        sensorJson.put("name", sensorName);
        makePostRequestWithJSONData(url, sensorJson);
    }

    public static void addMeasurement(Float value, Boolean raining, String sensorName) {
        final String url = "http://localhost:8095/api/measurements/add";
        Map<String, Object> measurementJson = new HashMap<>();
        measurementJson.put("value", value);
        measurementJson.put("raining", raining);
        measurementJson.put("sensor", Collections.singletonMap("name", sensorName));
        makePostRequestWithJSONData(url, measurementJson);
    }


    private static void makePostRequestWithJSONData(String url, Map<String, Object> jsonData) {
        final RestTemplate restTemplate = new RestTemplate();
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<>(jsonData, headers);
        try {
            restTemplate.postForObject(url, request, String.class);
            System.out.println("Measurement sent to server successfully");
        } catch (HttpClientErrorException e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        }
    }
}
