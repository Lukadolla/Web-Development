import java.util.regex.Pattern;

public class StringCalculator {

    public static int add(String numbers) {
        if (numbers.isEmpty()) return 0;

        if (numbers.endsWith(","))  throw new RuntimeException("Numbers should not end with a ,");

        String delimiter = ",";

        if(numbers.charAt(0) == '/')
        {
            delimiter = Character.toString(numbers.charAt(2));
            numbers = numbers.substring(4);
        }

        numbers = numbers.replaceAll("\\n", delimiter);
        String[] nums = numbers.split(Pattern.quote(delimiter));

        int sum = 0;
        for (String num : nums) {
            int number = Integer.parseInt(num);

            if(number < 0) throw new RuntimeException("Negative numbers aren't allowed: " + number);

            if(number > 1000)
            {
              number = 0;
            }

            sum += number;
        }

        return sum;
    }
    
}