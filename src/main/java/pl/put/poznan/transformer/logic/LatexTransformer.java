package pl.put.poznan.transformer.logic;

/**
 * Transformator konwertujący specjalne znaki na format zgodny z LaTeX.
 * <p>
 * Zastępuje znaki "\\", "&", "%", "$", "#", "_", "{", "}", "^", "~" odpowiednimi sekwencjami LaTeX.
 * </p>
 * 
 * @see TextTransformer
 * @since 1.0
 */
public class LatexTransformer implements TextTransformer {

    /**
     * Podstawowy transformator, na którym opiera się ten transformator.
     */
    private final TextTransformer base;

    /**
     * Konstruktor klasy {@code LatexTransformer}.
     *
     * @param base Podstawowy transformator tekstu.
     */
    public LatexTransformer(TextTransformer base) {
        this.base = base;
    }

    /**
     * Przekształca tekst, zastępując specjalne znaki na format zgodny z LaTeX.
     *
     * @param text Tekst do przetworzenia.
     * @return Tekst po konwersji na format LaTeX.
     */
    @Override
    public String transform(String text) {
        String transformed = base.transform(text);

        return transformed
                .replace("\\", "\\textbackslash{}")
                .replace("&", "\\&")
                .replace("%", "\\%")
                .replace("$", "\\$")
                .replace("#", "\\#")
                .replace("_", "\\_")
                .replace("{", "\\{")
                .replace("}", "\\}")
                .replace("^", "\\textasciicircum{}")
                .replace("~", "\\textasciitilde{}");
    }
}
