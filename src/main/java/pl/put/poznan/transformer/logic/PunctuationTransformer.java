package pl.put.poznan.transformer.logic;

public class PunctuationTransformer implements TextTransformer {


    private final TextTransformer base;

    public PunctuationTransformer(TextTransformer base) {
        this.base = base;
    }

    @Override
    public String transform(String text) {
        String transformed = base.transform(text);
        StringBuilder result = new StringBuilder();
        char[] specialChars = {'.', ',', '!', '?', '(', ')', '\"', '\''};
        boolean insideDoubleQuotes = false;
        boolean insideSingleQuotes = false;

        for (int i = 0; i < transformed.length(); i++) {
            char current = transformed.charAt(i);

            if (isSpecialChar(current, specialChars)) {
                if (current == '\"' || current == '\'' || current == ')' || current == '(') {
                    if (insideDoubleQuotes || insideSingleQuotes || current == ')') {
                        if (result.length() > 0 && result.charAt(result.length() - 1) == ' ') {
                            result.deleteCharAt(result.length() - 1);
                        }
                        result.append(current);
                        if (i + 1 < transformed.length() && transformed.charAt(i + 1) != ' ') {
                            result.append(' ');
                        }
                    } else {
                        if (result.length() > 0 && result.charAt(result.length() - 1) != ' ') {
                            result.append(' ');
                        }
                        result.append(current);
                        if (i + 1 < transformed.length() && transformed.charAt(i + 1) == ' ') {
                            i++;
                        }
                    }
                    if (current == '\"') {
                        insideDoubleQuotes = !insideDoubleQuotes;
                    }
                    else if (current == '\''){
                        insideSingleQuotes = !insideSingleQuotes;
                    }
                }
                else {

                    if (result.length() > 0 && result.charAt(result.length() - 1) == ' ') {
                        result.deleteCharAt(result.length() - 1);
                    }
                    result.append(current);
                    if (i + 1 < transformed.length() && transformed.charAt(i + 1) != ' ') {
                        result.append(' ');
                    }
                }
            }
            else {
                if (current != ' ' || (result.length() > 0 && result.charAt(result.length() - 1) != ' ')) {
                    result.append(current);
                }
            }
        }

        transformed = result.toString().trim();
        return transformed;
    }

    private static boolean isSpecialChar(char c, char [] charArray) {

        for (char special : charArray) {
            if (c == special) {
                return true;
            }
        }
        return false;
    }
}
