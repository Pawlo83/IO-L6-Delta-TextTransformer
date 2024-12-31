package pl.put.poznan.transformer.logic;

import java.util.StringTokenizer;

/**
 * Transformer przekształcający liczby w tekście na słowa.
 * 
 *
 * @author KZ, PS, MS, ST
 * @version 1.0
 * @since   1.0
 */
public class NumbersTransformer implements TextTransformer {

    /**
     * Bazowy transformer, którego wynik będzie dalej przetwarzany.
     */
    private final TextTransformer base;

    /**
     * Konstruktor inicjalizujący transformer bazowy.
     *
     * @param base Bazowy transformer, którego wynik będzie przekształcany.
     */
    public NumbersTransformer(TextTransformer base) {
        this.base = base;
    }


    private static final String[] UNITS = {
            "", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"
    };
    private static final String[] TEENS = {
            "dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście",
            "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"
    };
    private static final String[] TENS = {
            "", "", "dwadzieścia", "trzydzieści", "czterdzieści", "pięćdziesiąt", "sześćdziesiąt",
            "siedemdziesiąt", "osiemdziesiąt", "dziewięćdziesiąt"
    };
    private static final String[] HUNDREDS = {
            "", "sto", "dwieście", "trzysta", "czterysta", "pięćset", "sześćset", "siedemset",
            "osiemset", "dziewięćset"
    };

    private static final String[] THOUSANDS_FORMS = {
            "", "tysiąc", "tysiące", "tysięcy"
    };

    /**
     * Przekształca podany tekst, zmieniając liczby na słowa.
     *
     * @param text Tekst do przekształcenia.
     * @return Przekształcony tekst.
     */

    @Override
    public String transform(String text) {
        String transformed = base.transform(text);
        StringTokenizer tokenizer = new StringTokenizer(transformed, " .,!?\"(){}[]:;@#$%^&*-_+|~<>=`'«»‹›", true);
        StringBuilder result = new StringBuilder();

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (isNumeric(token)) {
                String numberInWords = convertToWords(Integer.parseInt(token));
                result.append(numberInWords);

                if (tokenizer.hasMoreTokens()) {
                    String nextToken = tokenizer.nextToken();
                    if (!isPunctuation(nextToken)) {
                        result.append(" ");
                    }
                    result.append(nextToken);
                }
            } else {
                result.append(token);
            }
        }



        transformed = result.toString().replaceAll("\\s+", " ").trim();
        return transformed;
    }

    private static boolean isPunctuation(String token) {
        return ".,!?\"(){}[]:;@#$%^&*-_+|~<>=`'«»‹›".contains(token);
    }

    public static String convertToWords(int number) {
        if (number == 0) {
            return "zero";
        }

        StringBuilder result = new StringBuilder();
        if (number < 0) {
            result.append("minus ");
            number = -number;
        }

        int thousands = number / 1000;
        int remainder = number % 1000;

        if (thousands > 0) {
            result.append(convertThousands(thousands)).append(" ");
        }

        if (remainder > 0) {
            result.append(convertBelowThousand(remainder));
        }

        return result.toString().trim();
    }

    private static String convertThousands(int number) {
        StringBuilder result = new StringBuilder();

        if (number == 1) {
            result.append(THOUSANDS_FORMS[1]);
        } else if (number >= 2 && number <= 4) {
            result.append(convertBelowThousand(number)).append(" ").append(THOUSANDS_FORMS[2]);
        } else {
            result.append(convertBelowThousand(number)).append(" ").append(THOUSANDS_FORMS[3]);
        }

        return result.toString().trim();
    }

    private static String convertBelowThousand(int number) {
        StringBuilder result = new StringBuilder();

        int hundreds = number / 100;
        int tens = (number % 100) / 10;
        int units = number % 10;

        if (hundreds > 0) {
            result.append(HUNDREDS[hundreds]).append(" ");
        }

        if (tens == 1) {
            result.append(TEENS[units]);
        } else {
            if (tens > 0) {
                result.append(TENS[tens]).append(" ");
            }
            if (units > 0) {
                result.append(UNITS[units]);
            }
        }

        return result.toString().trim();
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
