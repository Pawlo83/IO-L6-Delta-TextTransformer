package pl.put.poznan.transformer.logic;

public class ShortenTransformer implements TextTransformer {

    private final TextTransformer base;

    public ShortenTransformer(TextTransformer base) {
        this.base = base;
    }

    @Override
    public String transform(String text) {
        String transformed = base.transform(text);
        String[] words = transformed.split(" ");
        StringBuilder shorten = new StringBuilder();
        boolean upper;
        for (String word : words) {
            upper = Character.isUpperCase(word.charAt(0));
            switch (word.toLowerCase()){
                case "na przykład":
                    shorten.append(upper ? "Np." : "np");
                    break;
                case "między innymi":
                    shorten.append(upper ? "M.in." : "m.in.");
                    break;
                case "i tym podobne":
                    shorten.append(upper ? "Itp." : "itp.");
                    break;
                default:
                    shorten.append(word);
                    break;
            }
            shorten.append(" ");
        }

        return shorten.toString().trim();
    }

}
