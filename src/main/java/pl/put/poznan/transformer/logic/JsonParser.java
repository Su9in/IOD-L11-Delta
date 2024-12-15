package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
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
    public Map parseJson(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonMap = objectMapper.readValue(jsonString, Map.class);
            return jsonMap;
        } catch (Exception e) {
            System.err.println("Invalid JSON string: " + e.getMessage());
            return new HashMap<>();
        }
    }

    public Object getFieldValue(Map<String, Object> obj, String fieldName) {
        try {
            Object fieldValue = obj.get(fieldName);

            if (fieldValue instanceof ArrayList) {
                ArrayList<?> list = (ArrayList<?>) fieldValue;
                if (list.isEmpty()) {
                    return "List is empty";
                }
                return list;
            }
            else if (fieldValue instanceof String) {
                return fieldValue;
            }
            else {
                return "Incorrect field";
            }
        } catch (Exception e) {
            return "Invalid parameter name: " + e.getMessage();
        }
    }

}