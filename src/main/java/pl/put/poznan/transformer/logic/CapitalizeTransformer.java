package pl.put.poznan.transformer.logic;

public class CapitalizeTransformer implements TextTransformer {

    private final TextTransformer base;

    public CapitalizeTransformer(TextTransformer base) {
        this.base = base;
    }

    @Override
    public String transform(String text) {
        return base.transform(text).substring(0, 1).toUpperCase() + text.substring(1);
    }

}

