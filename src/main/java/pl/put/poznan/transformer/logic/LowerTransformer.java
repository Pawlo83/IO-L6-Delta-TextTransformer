package pl.put.poznan.transformer.logic;

/**
 * Transformer zamieniający cały tekst na małe litery.
 * 
 * <p>Transformacja odbywa się poprzez konwersję wszystkich liter w tekście na małe litery.</p>
 * 
 * @author  
 * @version 1.0
 * @since   1.0
 */
public class LowerTransformer implements TextTransformer {

    /**
     * Bazowy transformer, którego wynik będzie dalej przetwarzany.
     */
    private final TextTransformer base;

    /**
     * Konstruktor inicjalizujący transformer bazowy.
     *
     * @param base Bazowy transformer, którego wynik będzie przekształcany.
     */
    public LowerTransformer(TextTransformer base) {
        this.base = base;
    }

    /**
     * Przekształca podany tekst, zamieniając wszystkie litery na małe.
     *
     * @param text Tekst do przekształcenia.
     * @return Tekst z zamienionymi literami na małe.
     */
    @Override
    public String transform(String text) {
        return base.transform(text).toLowerCase();
    }
}
