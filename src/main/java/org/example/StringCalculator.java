package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }


        // Handle custom delimiters of any length:
        Pattern delimiterPattern = Pattern.compile("//(\\[.*?\\]|.+?)\n");
        Matcher delimiterMatcher = delimiterPattern.matcher(numbers);
        String delimiter = ",|\n"; // default delimiter

        if (delimiterMatcher.find()) {
            String delimiterGroup = delimiterMatcher.group(1);
            // **Escape and remove brackets:**
            delimiter = Pattern.quote(delimiterGroup.replaceAll("[\\[\\]]", ""));
            numbers = numbers.substring(delimiterMatcher.end());
        }


        // Construct regex pattern to match any of the delimiter characters
        String regexDelimiter = "[" + Pattern.quote(delimiter) + "]";


        String[] nums = numbers.split(regexDelimiter);
        // List to store negative numbers
        List<Integer> negatives = new ArrayList<>();
        int sum = 0;
        for (String num : nums) {
            if (num.isEmpty()) { //This to ingore empty strings created by Delimiters with bigger length than one
                continue;
            }
            int i = Integer.parseInt(num);
            if (i < 0) {
                negatives.add(i);
            }
            if (i <= 1000) {
                sum += Integer.parseInt(num);
            }
        }
        // If negative numbers are found, throw an exception
        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + negatives);
        }

        return sum;
    }
}
