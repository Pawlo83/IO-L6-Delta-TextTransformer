package pl.put.poznan.transformer.logic;

public class ShortenTransformer implements TextTransformer {

    private final TextTransformer base;

    public ShortenTransformer(TextTransformer base) {
        this.base = base;
    }

    @Override
    public String transform(String text) {
        String transformed = base.transform(text);

        return transformed.replaceAll("na przykład","np.")
                .replaceAll("Na przykład" , "Np.")
                .replaceAll("między innymi" , "m.in.")
                .replaceAll("Między innymi" , "M.in.")
                .replaceAll("i tym podobne" , "itp.")
                .replaceAll("I tym podobne" , "Itp.");
    }

}
