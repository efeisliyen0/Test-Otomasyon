package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class TestDataReader {

    public static String getValue(String fileName, String key) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(new File("src/test/resources/testdata/" + fileName + ".json"));
            JsonNode value = json.get(key);
            if (value == null) {
                throw new RuntimeException("Key bulunamadı! Dosya: " + fileName + ".json | Key: " + key);
            }
            return value.asText();
        } catch (Exception e) {
            throw new RuntimeException("Test data okunamadı! Dosya: " + fileName + ".json", e);
        }
    }
}
