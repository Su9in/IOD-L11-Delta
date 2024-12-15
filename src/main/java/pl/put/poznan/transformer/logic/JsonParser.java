package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible for operations with JSON string.
 */

public class JsonParser {

    /**
     * Parses a JSON string and formats it into a pretty-printed version.
     *
     * @param jsonString the JSON string to parse
     * @return a pretty-printed JSON string, or an error message if parsing fails
     */
    public Map ParseJson(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonMap = objectMapper.readValue(jsonString, Map.class);
            return jsonMap;
        } catch (Exception e) {
            System.err.println("Invalid JSON string: " + e.getMessage());
            return new HashMap<>();
        }
    }

    public String[] GetFieldValue(Map<String, Object> obj, String fieldName) {
        try {
            Object fieldValue = obj.get(fieldName);
            if (fieldValue instanceof String) {
                return ((String) fieldValue).split(",");
            }
            return new String[]{"Incorrect field"};
        } catch (Exception e) {
            return new String[]{"Invalid parameter name: " + e.getMessage()};
        }
    }

}