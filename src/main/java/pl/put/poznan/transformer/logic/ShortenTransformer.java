package pl.put.poznan.transformer.logic;

/**
 * Transformer skracający określone wyrażenia w tekście do ich skrótów.
 *
 * <p>Przykładowe skróty obejmują:  </p>
 * <ul>
 *     <li>"na przykład" → "np."</li>
 *     <li>"między innymi" → "m.in."</li>
 *     <li>"i tym podobne" → "itp."</li>
 * </ul>
 * @author KZ, PS, MS, ST
 * @version 1.0
 * @since   1.0
 */
public class ShortenTransformer implements TextTransformer {

    /**
     * Bazowy transformer, którego wynik będzie dalej przetwarzany.
     */
    private final TextTransformer base;

    /**
     * Konstruktor inicjalizujący transformer bazowy.
     *
     * @param base Bazowy transformer, którego wynik będzie przekształcany.
     */
    public ShortenTransformer(TextTransformer base) {
        this.base = base;
    }

    /**
     * Przekształca podany tekst, skracając określone wyrażenia do ich skrótów.
     *
     * @param text Tekst do przekształcenia.
     * @return Tekst ze skróconymi wyrażeniami.
     */
    @Override
    public String transform(String text) {
        String transformed = base.transform(text);

        return transformed.replaceAll("na przykład", "np.")
                         .replaceAll("Na przykład", "Np.")
                         .replaceAll("między innymi", "m.in.")
                         .replaceAll("Między innymi", "M.in.")
                         .replaceAll("i tym podobne", "itp.")
                         .replaceAll("I tym podobne", "Itp.");
    }
}
