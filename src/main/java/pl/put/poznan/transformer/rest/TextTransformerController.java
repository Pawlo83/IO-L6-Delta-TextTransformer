package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.*;

import java.util.Arrays;

/**
 * Kontroler REST odpowiedzialny za obsługę żądań transformacji tekstu.
 * <p>
 * Umożliwia zdalne wywoływanie transformacji tekstowych poprzez interfejs API.
 * Obsługuje różne typy transformacji, takie jak zmiana wielkości liter, eliminacja duplikatów,
 * konwersja do formatu LaTeX, itp.
 * </p>
 * <p>
 * Adres bazowy API: {@code /transform?{text}}
 * </p>
 *  @author KZ, PS, MS, ST
 *  @version 1.0
 *  @since   1.0
 */
@RestController
public class TextTransformerController {

    /**
     * Logger do rejestrowania informacji o działaniu kontrolera.
     */
    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    /**
     * Obsługuje żądanie HTTP GET do transformacji tekstu.
     * <p>
     * Przetwarza tekst zgodnie z podanymi parametrami transformacji i zwraca przekształcony tekst w formacie JSON.
     * </p>
     *
     * @param text       Tekst do przekształcenia, przekazany jako część ścieżki URL.
     * @param transforms Tablica nazw transformacji do zastosowania (np. "upper", "lower", "latex").
     * @return Przekształcony tekst jako ciąg znaków w formacie JSON.
     */
    @RequestMapping("/transform")
    public String transform(@RequestParam(value = "text", defaultValue = "") String text,
                      @RequestParam(value = "transforms", defaultValue = "") String[] transforms) {

        // Logowanie parametrów żądania
        logger.debug("Otrzymany tekst: {}", text);
        logger.debug("Zastosowane transformacje: {}", Arrays.toString(transforms));

        TextTransformer transformer = new BasicTransformer(text);

        for (String transform : transforms) {
            switch (transform.toLowerCase()) {
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
                    logger.warn("Nieznana transformacja: {}", transform);
                    break;
            }
        }

        return transformer.transform(text);
    }
}
