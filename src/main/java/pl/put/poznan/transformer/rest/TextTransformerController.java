package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.JsonParser;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.awt.SystemColor.text;


@RestController
@RequestMapping("/transform")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@RequestParam(value = "text", defaultValue = "LoReM IpSuM!") String text,
                      @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }

/*    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@RequestParam(value = "text", defaultValue = "LoReM IpSuM!") String text,
                       @RequestBody String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }
*/
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public String post(@RequestBody String jsonBody) {

        JsonParser parser = new JsonParser();
        Map body = parser.ParseJson(jsonBody);
        String text = parser.GetFieldValue(body, "text")[0];
        String[] transforms = parser.GetFieldValue(body, "transforms");

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return transformer.transform(text);
    }



}


