package pl.put.poznan.transformer.logic;

/**
 * Transformer zamieniający cały tekst na wielkie litery.
 * 
 * <p>Transformacja odbywa się poprzez konwersję wszystkich liter w tekście na wielkie litery.</p>
 * @author KZ, PS, MS, 
 * @version 1.0
 * @since   1.0
 */
public class UpperTransformer implements TextTransformer {

    /**
     * Bazowy transformer, którego wynik będzie dalej przetwarzany.
     */
    private final TextTransformer base;

    /**
     * Konstruktor inicjalizujący transformer bazowy.
     *
     * @param base Bazowy transformer, którego wynik będzie przekształcany.
     */
    public UpperTransformer(TextTransformer base) {
        this.base = base;
    }

    /**
     * Przekształca podany tekst, zamieniając wszystkie litery na wielkie.
     *
     * @param text Tekst do przekształcenia.
     * @return Tekst z zamienionymi literami na wielkie.
     */
    @Override
    public String transform(String text) {
        return base.transform(text).toUpperCase();
    }
}
