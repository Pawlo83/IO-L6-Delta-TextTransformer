package pl.put.poznan.transformer.logic;

/**
 * Transformator konwertujący specjalne znaki na format zgodny z LaTeX.
 * <p>
 * Zastępuje znaki "\\", "&amp;" "%", "$", "#", "_", "{", "}", "^", "~" odpowiednimi sekwencjami LaTeX.
 * </p>
 * @author KZ, PS, MS, ST
 * @version 1.0
 * @since   1.0
 * @see TextTransformer
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
        StringBuilder result = new StringBuilder();
        boolean quotation = false;
        for (char c : transformed.toCharArray()) {
            switch (c) {
                case '\\':
                    result.append("\\textbackslash{}");
                    break;
                case '&':
                    result.append("\\&");
                    break;
                case '%':
                    result.append("\\%");
                    break;
                case '$':
                    result.append("\\$");
                    break;
                case '#':
                    result.append("\\#");
                    break;
                case '_':
                    result.append("\\_");
                    break;
                case '{':
                    result.append("\\{");
                    break;
                case '}':
                    result.append("\\}");
                    break;
                case '^':
                    result.append("\\textasciicircum{}");
                    break;
                case '~':
                    result.append("\\textasciitilde{}");
                    break;
                case '\"':
                    result.append(quotation ? "}" : "\\textit{");
                    quotation = !quotation;
                    break;
                default:
                    result.append(c);
                    break;
            }
        }

        return result.toString();
    }
}
