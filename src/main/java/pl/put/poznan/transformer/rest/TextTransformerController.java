package pl.put.poznan.transformer.rest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.put.poznan.transformer.logic.JsonParser;
import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Arrays;
import java.util.Map;


@RestController
@RequestMapping("/")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @GetMapping(value = "/transform", produces = "application/json")
    public String get(@RequestParam(value = "text", defaultValue = "LoReM IpSuM!") String text,
                      @RequestParam(value="transforms", defaultValue="upper,reverse") String[] transforms) throws JsonProcessingException {
        JsonParser parser = new JsonParser();
        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);
        return parser.ResToJson(transformer.transform(text));
    }


    @PostMapping(value="/transform", produces = "application/json")
    public String post(@RequestBody String jsonBody) throws JsonProcessingException {

        JsonParser parser = new JsonParser();
        Map body = parser.ParseJson(jsonBody);
        String text = parser.GetFieldValue(body, "text")[0];
        String[] transforms = parser.GetFieldValue(body, "transforms");

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);

        return parser.ResToJson(transformer.transform(text));
    }


    @GetMapping("/")
    public ModelAndView indexGet() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @PostMapping("/")
    public ModelAndView indexPost(String text, String[] transforms) {
        ModelAndView modelAndView = new ModelAndView();

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        // perform the transformation, you should run your logic here, below is just a silly example
        TextTransformer transformer = new TextTransformer(transforms);

        modelAndView.addObject("processedText", transformer.transform(text));
        modelAndView.addObject("transforms", String.join(", ", transforms));
        modelAndView.setViewName("success");
        return modelAndView;
    }

}


