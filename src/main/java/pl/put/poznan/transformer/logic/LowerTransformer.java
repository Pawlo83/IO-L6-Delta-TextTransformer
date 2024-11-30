package pl.put.poznan.transformer.logic;

public class LowerTransformer implements TextTransformer {

    private final TextTransformer base;

    public LowerTransformer(TextTransformer base) {
        this.base = base;
    }

    @Override
    public String transform(String text) {
        return base.transform(text).toLowerCase();
    }

}
