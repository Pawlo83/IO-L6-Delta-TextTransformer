package pl.put.poznan.transformer.logic;

public class BasicTransformer implements TextTransformer {

    private final String text;

    public BasicTransformer(String text) {
        this.text = text;
    }

    @Override
    public String transform(String text) {
        return this.text;
    }

}
