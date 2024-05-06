package org.example;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        String phonePattern = "\\+?\\d{3}[-\\s]?\\(?(\\d{2})\\)?[\\s-]?((\\d{3})[\\s-]?(\\d{2})[\\s-]?(\\d{2}))";

        String[] phoneArr = {
                "+(998) 90 138 99 18",
                "+998 91 138 99 18", //1
                "+998-90-138-99-18", //2
                "901389918",         //3
                "+901389918",      //4
                "+998 (90) 1389918", //5
                "90-138-99-18",      //6
                "90 138 99 18",      //7
                "9 0 1 3 8 9 9 1 8",  //8
                "+998901389918",
                "+998(90)138-99-18",
                "(90)138-99-18",
                "(90) 138 99 18",
        };

        isMatch2(phoneArr);

        System.out.println(isValidEmail("rawqwqwqv@ee.com"));
        s();
    }

    private static void isMatch(String[] phoneArr){
        String phonePattern = "\\+?\\(?(\\d{3})?\\)?[-\\s]?\\(?(\\d{2})\\)?[\\s-]?((\\d{3})[\\s-]?(\\d{2})[\\s-]?(\\d{2}))";
//        String phonePattern = "\\+?(998)?[-\\s]?\\(?(90)\\)?[-\\s]?((\\d{3})[-\\s]?(\\d{2})[-\\s]?(\\d{2}))";

        int count = 1;
        for (String phone : phoneArr) {
            Pattern pattern = Pattern.compile(phonePattern);
            Matcher matcher = pattern.matcher(phone);

            if (matcher.matches()) {
                String formattedPhone = matcher.group(2) + matcher.group(3);
                System.out.println(count++ + " ✅: " + phone +" "+ formattedPhone);
            } else {
                System.out.println(count++ +" ❌: " + phone);
            }
        }
    }

    private static void isMatch2(String[] phoneArr){
        String regexPhonePattern = "\\+?(998)?[-\\s]?\\(?(\\d{2})\\)?[-\\s]?((\\d{3})[-\\s]?(\\d{2})[-\\s]?(\\d{2}))";
        int count = 1;
        for (String phone : phoneArr) {
            Matcher matcher = Pattern.compile(regexPhonePattern).matcher(phone.replaceAll("[\\-()\\s]", ""));

            if (matcher.matches()) {
                String formattedPhone = matcher.group(2) + matcher.group(3);
                System.out.println(count++ + " ✅: " + phone + " " + formattedPhone);
            } else {
                System.out.println(count++ + " ❌: " + phone);
            }
        }
    }

    public static boolean isValidEmail(String email) {
        String regexPattern = "[A-Za-z0-9._%+\\-]+@[A-Za-z.\\-]{2,}\\.[A-Za-z]{2,}";

        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }

    private static void s(){
        String PHONE_NUMBER_PREFIX = "+998";
String s2 = "+998901389918";
        System.out.println(s2.substring(PHONE_NUMBER_PREFIX.length()));
        ;
    }


}