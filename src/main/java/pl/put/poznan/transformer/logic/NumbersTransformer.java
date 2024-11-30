package pl.put.poznan.transformer.logic;

public class NumbersTransformer implements TextTransformer {

    private final TextTransformer base;

    public NumbersTransformer(TextTransformer base) {
        this.base = base;
    }

    @Override
    public String transform(String text) {
        String transformed = base.transform(text);
        // tutaj logika
        return transformed;
    }

}
