package pl.put.poznan.transformer.logic;

public class LatexTransformer implements TextTransformer {

    private final TextTransformer base;

    public LatexTransformer(TextTransformer base) {
        this.base = base;
    }

    @Override
    public String transform(String text) {
        String transformed = base.transform(text);

        return transformed
                .replace("\\", "\\textbackslash{}")
                .replace("&", "\\&")
                .replace("%", "\\%")
                .replace("$", "\\$")
                .replace("#", "\\#")
                .replace("_", "\\_")
                .replace("{", "\\{")
                .replace("}", "\\}")
                .replace("^", "\\textasciicircum{}")
                .replace("~", "\\textasciitilde{}");
    }
}
