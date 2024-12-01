package pl.put.poznan.transformer.logic;

public class UpperTransformer implements TextTransformer {

    private final TextTransformer base;

    public UpperTransformer(TextTransformer base) {
        this.base = base;
    }

    @Override
    public String transform(String text) {
        return base.transform(text).toUpperCase();
    }

}
