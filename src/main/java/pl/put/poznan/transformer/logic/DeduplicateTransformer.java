package pl.put.poznan.transformer.logic;

/**
 * Transformator usuwający powtarzające się wyrazy w bezpośrednim sąsiedztwie tekstu.
 * <p>
 * Działa poprzez analizę przekształconego tekstu i eliminację duplikatów wyrazów.
 * </p>
 * @author KZ, PS, MS, ST
 * @version 1.0
 * @since   1.0
 * @see TextTransformer
 */
public class DeduplicateTransformer implements TextTransformer {

    /**
     * Podstawowy transformator, na którym opiera się ten transformator.
     */
    private final TextTransformer base;

    /**
     * Konstruktor klasy {@code DeduplicateTransformer}.
     *
     * @param base Podstawowy transformator tekstu.
     */
    public DeduplicateTransformer(TextTransformer base) {
        this.base = base;
    }

    /**
     * Przekształca tekst, usuwając powtarzające się wyrazy w bezpośrednim sąsiedztwie.
     *
     * @param text Tekst do przetworzenia.
     * @return Tekst po usunięciu duplikatów wyrazów.
     */
    @Override
    public String transform(String text) {
        String transformed = base.transform(text);
        String[] words = transformed.split(" ");
        StringBuilder deduplicated = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i == 0 || !words[i].equalsIgnoreCase(words[i - 1])) {
                deduplicated.append(words[i]).append(" ");
            }
        }

        return deduplicated.toString().trim();
    }

}
