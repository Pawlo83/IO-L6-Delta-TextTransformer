package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;

/**
 * Transformer odwracający kolejność liter w tekście, zachowując oryginalną kapitalizację.
 * 
 * <p>Transformacja obejmuje odwrócenie całego tekstu oraz przywrócenie wielkości liter na pierwotnych pozycjach.</p>
 * @author KZ, PS, MS, ST
 * @version 1.0
 * @since   1.0
 */
public class InverseTransformer implements TextTransformer {

    /**
     * Bazowy transformer, którego wynik będzie dalej przetwarzany.
     */
    private final TextTransformer base;

    /**
     * Konstruktor inicjalizujący transformer bazowy.
     *
     * @param base Bazowy transformer, którego wynik będzie przekształcany.
     */
    public InverseTransformer(TextTransformer base) {
        this.base = base;
    }

    /**
     * Przekształca podany tekst, odwracając kolejność liter i zachowując oryginalną kapitalizację.
     *
     * @param text Tekst do przekształcenia.
     * @return Odwrócony tekst z zachowaną kapitalizacją liter.
     */
    @Override
    public String transform(String text) {
        String transformed = base.transform(text);

        List<Integer> upperLetters = new ArrayList<>();

        for (int i = 0; i < transformed.length(); i++) {
            if (Character.isUpperCase(transformed.charAt(i))) {
                upperLetters.add(i);
            }
        }

        StringBuilder inversed = new StringBuilder(transformed.toLowerCase()).reverse();
        for (int i : upperLetters) {
            inversed.setCharAt(i, Character.toUpperCase(inversed.charAt(i)));
        }

        return inversed.toString();
    }
}
