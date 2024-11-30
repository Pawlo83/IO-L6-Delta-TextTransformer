package pl.put.poznan.transformer.logic;

import java.util.ArrayList;
import java.util.List;

public class InverseTransformer implements TextTransformer {

    private final TextTransformer base;

    public InverseTransformer(TextTransformer base) {
        this.base = base;
    }

    @Override
    public String transform(String text) {
        String transformed = base.transform(text);

        List<Integer> upperLetters = new ArrayList<>();

        for (int i = 0; i < transformed.length(); i++) {
            if (Character.isUpperCase(transformed.charAt(i))) {
                upperLetters.add(i);
            }
        }

        StringBuilder inversed = new StringBuilder(transformed.toLowerCase()).reverse();
        for (int i : upperLetters) {
            inversed.setCharAt(i, Character.toUpperCase(inversed.charAt(i)));
        }

        return inversed.toString();
    }

}