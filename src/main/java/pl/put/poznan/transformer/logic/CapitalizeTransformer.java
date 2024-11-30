package pl.put.poznan.transformer.logic;

public class CapitalizeTransformer implements TextTransformer {

    private final TextTransformer base;

    public CapitalizeTransformer(TextTransformer base) {
        this.base = base;
    }

    @Override
    public String transform(String text) {
        String [] words = base.transform(text).split(" ");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if(!word.isEmpty()) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }

        }
        return capitalized.toString().trim();
    }

}

