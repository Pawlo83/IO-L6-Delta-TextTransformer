package pl.put.poznan.transformer.rest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.*;

import java.util.Arrays;


@RestController
@RequestMapping("/{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public String get(@PathVariable String text,
                              @RequestParam(value="transforms", defaultValue="") String[] transforms) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        TextTransformer transformer = new BasicTransformer(text);

        for (String transform : transforms) {
            switch (transform) {
                case "upper":
                    transformer = new UpperTransformer(transformer);
                    break;
                case "lower":
                    transformer = new LowerTransformer(transformer);
                    break;
                case "capitalize":
                    transformer = new CapitalizeTransformer(transformer);
                    break;
                case "inverse":
                    transformer = new InverseTransformer(transformer);
                    break;
                case "numbers":
                    transformer = new NumbersTransformer(transformer);
                    break;
                case "shorten":
                    transformer = new ShortenTransformer(transformer);
                    break;
                case "expand":
                    transformer = new ExpandTransformer(transformer);
                    break;
                case "latex":
                    transformer = new LatexTransformer(transformer);
                    break;
                case "deduplicate":
                    transformer = new DeduplicateTransformer(transformer);
                    break;
                default:
                    System.out.println("Wrong trans!");
                    break;
            }
        }

        return transformer.transform(text);
    }
}


