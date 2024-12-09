package pl.put.poznan.transformer.logic;

/**
 * Podstawowa implementacja interfejsu {@link TextTransformer}, która zwraca oryginalny tekst bez żadnych zmian.
 * <p>
 * Może służyć jako baza dla innych transformatorów tekstu, które rozszerzają jej funkcjonalność.
 * </p>
 * 
 * @see TextTransformer
 * @since 1.0
 */
public class BasicTransformer implements TextTransformer {

    /**
     * Tekst, który ma być przetworzony.
     */
    private final String text;

    /**
     * Konstruktor klasy {@code BasicTransformer}.
     *
     * @param text Tekst do przechowywania i ewentualnej transformacji.
     */
    public BasicTransformer(String text) {
        this.text = text;
    }

    /**
     * Zwraca oryginalny tekst bez żadnych zmian.
     *
     * @param text Tekst do przetworzenia (nieużywany w tej implementacji).
     * @return Oryginalny tekst.
     */
    @Override
    public String transform(String text) {
        return this.text;
    }

}
