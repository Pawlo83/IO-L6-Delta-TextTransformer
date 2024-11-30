package pl.put.poznan.transformer.logic;

public class ExpandTransformer implements TextTransformer {

    private final TextTransformer base;

    public ExpandTransformer(TextTransformer base) {
        this.base = base;
    }

    @Override
    public String transform(String text) {
        String transformed = base.transform(text);
        String[] words = transformed.split(" ");
        StringBuilder expanded = new StringBuilder();
        boolean upper;
        for (String word : words) {
            upper = Character.isUpperCase(word.charAt(0));
            switch (word.toLowerCase()){
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
