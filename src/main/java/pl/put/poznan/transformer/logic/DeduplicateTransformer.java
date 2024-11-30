package pl.put.poznan.transformer.logic;

public class DeduplicateTransformer implements TextTransformer {

    private final TextTransformer base;

    public DeduplicateTransformer(TextTransformer base) {
        this.base = base;
    }

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
