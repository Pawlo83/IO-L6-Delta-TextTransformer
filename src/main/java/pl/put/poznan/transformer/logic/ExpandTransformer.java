package pl.put.poznan.transformer.logic;

/**
 * Transformer rozszerzający skróty w tekście do pełnych form.
 * 
 * <p>Przykładowe rozszerzenia obejmują:</p>
 * <ul>
 *     <li>"prof." → "Profesor"</li>
 *     <li>"dr" → "Doktor"</li>
 *     <li>"np." → "Na przykład"</li>
 *     <li>"itd." → "I tak dalej."</li>
 * </ul>
 * @author KZ, PS, MS, ST
 * @version 1.0
 * @since   1.0
 */
public class ExpandTransformer implements TextTransformer {

    /**
     * Bazowy transformer, którego wynik będzie dalej przetwarzany.
     */
    private final TextTransformer base;

    /**
     * Konstruktor inicjalizujący transformer bazowy.
     *
     * @param base Bazowy transformer, którego wynik będzie przekształcany.
     */
    public ExpandTransformer(TextTransformer base) {
        this.base = base;
    }

    /**
     * Przekształca podany tekst, rozszerzając zdefiniowane skróty do pełnych form.
     *
     * @param text Tekst do przekształcenia.
     * @return Tekst z rozszerzonymi skrótami.
     */
    @Override
    public String transform(String text) {
        String transformed = base.transform(text);
        String[] words = transformed.split(" ");
        StringBuilder expanded = new StringBuilder();
        boolean upper;
        for (String word : words) {
            upper = Character.isUpperCase(word.charAt(0));
            switch (word.toLowerCase()) {
                case "prof.":
                    expanded.append(upper ? "Profesor" : "profesor");
                    break;
                case "dr":
                    expanded.append(upper ? "Doktor" : "doktor");
                    break;
                case "np.":
                    expanded.append(upper ? "Na przykład" : "na przykład");
                    break;
                case "itd.":
                    expanded.append(upper ? "I tak dalej." : "i tak dalej.");
                    break;
                default:
                    expanded.append(word);
                    break;
            }
            expanded.append(" ");
        }

        return expanded.toString().trim();
    }
}
