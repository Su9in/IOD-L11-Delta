package pl.put.poznan.transformer.logic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class JsonParserTest {
    JsonParser parser = new JsonParser();
    String jsonStr;
    Map body;
    String jsonStr1;
    Map body1;

    @BeforeEach
    void setUp() {
        jsonStr = "{\n\"text\":\"LoReM IpSuM!\",\n\"transforms\" : \"upper,lower,reverse\"\n}";
        body = parser.ParseJson(jsonStr);
        jsonStr1 = "{\n\"text\":\"LoReM IpSuM!\",\n\"transforms\" : \"reverse\"\n}";
        body1 = parser.ParseJson(jsonStr1);
    }

    @Test
    public void TestParseJson(){
        parser.ParseJson(jsonStr);

    }

    @Test
    public void TestParseText(){
        assertEquals("LoReM IpSuM!", parser.GetFieldValue(body, "text")[0]);
    }

    @Test
    public void TestParseTransforms(){

        String[] parsedValues = parser.GetFieldValue(body, "transforms");
        String[] parsedValues1 = parser.GetFieldValue(body1, "transforms");
        assertEquals(3, parsedValues.length);
        assertEquals("upper",parsedValues[0]);
        assertEquals("lower",parsedValues[1]);
        assertEquals("reverse",parsedValues[2]);
        assertEquals("reverse", parsedValues1[0]);
    }

}
