package pl.put.poznan.transformer.logic;

/**
 * Transformer przekształcający liczby w tekście według określonej logiki.
 * 
 * <p>Obecnie implementacja nie zawiera logiki przekształcania, jest to miejsce na 
 * dalsze rozwinięcie funkcjonalności.</p>
 * 
 * @author  
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

    /**
     * Przekształca podany tekst, wykonując operacje na liczbach zgodnie z implementowaną logiką.
     *
     * @param text Tekst do przekształcenia.
     * @return Przekształcony tekst z uwzględnieniem operacji na liczbach.
     */
    @Override
    public String transform(String text) {
        String transformed = base.transform(text);
        // Tutaj logika przekształcania liczb
        return transformed;
    }
}
