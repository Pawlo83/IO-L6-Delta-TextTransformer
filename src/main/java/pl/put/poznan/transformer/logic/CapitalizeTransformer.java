package pl.put.poznan.transformer.logic;

/**
 * Transformer przekształcający tekst poprzez kapitalizację pierwszej litery każdego słowa.
 * 
 * <p>Transformacja odbywa się poprzez podzielenie tekstu na słowa, 
 * a następnie zamianę pierwszej litery każdego słowa na wielką literę.</p>
 *
 * @author KZ, PS, MS, ST
 * @version 1.0
 * @since   1.0
 */
public class CapitalizeTransformer implements TextTransformer {

    /**
     * Bazowy transformer, którego wynik będzie dalej przetwarzany.
     */
    private final TextTransformer base;

    /**
     * Konstruktor inicjalizujący transformer bazowy.
     *
     * @param base Bazowy transformer, którego wynik będzie przekształcany.
     */
    public CapitalizeTransformer(TextTransformer base) {
        this.base = base;
    }

    /**
     * Przekształca podany tekst, kapitalizując pierwszą literę każdego słowa.
     *
     * @param text Tekst do przekształcenia.
     * @return Tekst z kapitalizowanymi słowami.
     */
    @Override
    public String transform(String text) {
        String[] words = base.transform(text).split(" ");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                           .append(word.substring(1))
                           .append(" ");
            }
        }
        return capitalized.toString().trim();
    }
}
