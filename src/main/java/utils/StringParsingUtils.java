package utils;

import model.StringInfo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringParsingUtils {
    public static final String BLANK_REGEX = "\\s";
    public static final String EMPTY = "";
    public static final String COMMA = ",";

    public static List<StringInfo> parseToName(String input) {
        String[] stringParsedInput = splitWithComma(removeBlank(input));
        return Arrays.stream(stringParsedInput)
                .map(StringInfo::new)
                .collect(Collectors.toList());
    }

    private static String[] splitWithComma(String input) {
        return input.split(COMMA);
    }

    public static String removeBlank(String input) {
        return input.replaceAll(BLANK_REGEX, EMPTY);
    }
}