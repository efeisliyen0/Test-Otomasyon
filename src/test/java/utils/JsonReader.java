package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;

public class JsonReader {

    public static String getValue(String fileName, String key) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(
                    new File("src/test/resources/" + fileName)
            );
            return json.get(key).asText();
        } catch (Exception hata) {
            return null;
        }
    }
}
