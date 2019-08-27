package org.algoinit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cgada
 */
public class PhoneNumberLetterCombination {

    static Map<String, List<String>> phoneNumberCharacters;

    static
    {
        phoneNumberCharacters = new HashMap<>();
        phoneNumberCharacters.put("2", Arrays.asList("a","b","c"));
        phoneNumberCharacters.put("3", Arrays.asList("d","e","f"));
        phoneNumberCharacters.put("4", Arrays.asList("g","h","i"));
        phoneNumberCharacters.put("5", Arrays.asList("j","k","l"));
        phoneNumberCharacters.put("6", Arrays.asList("m","n","o"));
        phoneNumberCharacters.put("7", Arrays.asList("p","q","r","s"));
        phoneNumberCharacters.put("8", Arrays.asList("t","u","v"));
        phoneNumberCharacters.put("9", Arrays.asList("w","x","y","z"));
    }

    public static void main(String[] args) {
        System.out.println(letterCombinations("41"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();

        if(digits == null || digits.length() == 0 ||
                digits.contains("0") || digits.contains("1"))
            return output;

        if(digits.length() == 1)
            return phoneNumberCharacters.get(digits);

        List<String> partialOutput = letterCombinations(digits.substring(1));

        partialOutput.forEach(singlePartialOutput ->
            phoneNumberCharacters.get(digits.substring(0,1)).forEach(singleCharacter ->
                    output.add(singleCharacter + singlePartialOutput))
        );

        return output;
    }
}
