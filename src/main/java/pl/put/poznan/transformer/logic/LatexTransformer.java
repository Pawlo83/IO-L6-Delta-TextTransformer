package pl.put.poznan.transformer.logic;

public class LatexTransformer implements TextTransformer {

    private final TextTransformer base;

    public LatexTransformer(TextTransformer base) {
        this.base = base;
    }

    @Override
    public String transform(String text) {
        String transformed = base.transform(text);
        // tutaj logika
        return transformed;
    }

}
