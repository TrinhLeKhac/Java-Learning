package string;

import java.util.*;

public class StringExample {

    // Reverse by using StringBuilder.reverse()
    public static String reverseStringV1(String input) {
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return sb.toString();
    }

    // Reverse by using iterator
    public static String reverseStringV2(String input) {
        char[] chars = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    // Check palindrome by using StringBuilder
    public static boolean isPalindromeV1(String input) {
        StringBuilder sb = new StringBuilder(input);
        String reverseInput = sb.reverse().toString();
        return reverseInput.equals(input);
    }

    // Capitalize each word in string
    public static String capitalizeWord(String input) {
        String[] words = input.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (String word: words) {
            sb.append(word.substring(0, 1).toUpperCase()).append(word.substring(1)).append(" ");
        }
        return sb.toString();
    }

    // Reverse each word in string
    public static String reverseWord(String input) {
        String[] words = input.split("\\s+");
        StringBuilder total = new StringBuilder();
        for (String word: words) {
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            total.append(sb).append(" ");
        }
        return total.toString();
    }

    public static boolean isAnagram(String input1, String input2) {

        String s1 = input1.replace("\\s+", "");
        String s2 = input2.replace("\\s+", "");

        if (s1.length() != s2.length()) {
            return false;
        }

        char[] chars1 = s1.toLowerCase().toCharArray();
        char[] chars2 = s2.toLowerCase().toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    // Find duplicates character in string
    public static void findDuplicateCharacter(String input) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = input.toCharArray();
        for (char c: chars) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        Set<Character> charSet = map.keySet();
        System.out.println("Find duplicates character in string: " + input);
        for (Character c: charSet) {
            if (map.get(c) > 1) {
                System.out.println("The character " + c + " exists " + map.get(c) + " times in string");
            }
        }
    }

    // Check string is rotation
    public static boolean isRotation(String input1, String input2) {
        String temp = input1 + input1;
        return temp.contains(input2);
    }

    // Remove character at particular position
    public static String removeCharacter(String input, int position) {
        return input.substring(0, position) + input.substring(position + 1);
    }

    // Swap two strings without using temp variable
    public static void swapTwoString(String a, String b) {
        System.out.println("The original first string is: " + a);
        System.out.println("The original second string is: " + b);
        a = a + b;
        b = a.substring(0, a.length() - b.length());
        a = a.substring(b.length());
        System.out.println("The first string after swapping is: " + a);
        System.out.println("The second string after swapping is: " + b);
    }

    // Testing concatenate between String and StringBuilder
    private static String concatWithString() {
        String t = "Implement";
        int largeNumber = 100000;
        System.out.println("HashCode of original String is: " + t.hashCode());
        for (int i = 0; i < largeNumber; i++) {
            t = t + " Java";
        }
        System.out.println("HashCode of modified String is: " + t.hashCode());
        return t;
    }

    private static String concatWithStringBuffer() {
        StringBuilder t = new StringBuilder("Implement");
        int largeNumber = 100000;
        System.out.println("HashCode of original StringBuilder is: " + t.hashCode());
        for (int i = 0; i < largeNumber; i++) {
            t.append(" Java");
        }
        System.out.println("HashCode of modified StringBuilder is: " + t.hashCode());
        return t.toString();
    }

    public static void testPerformanceStringVsStringBuilder() {
        long startTime = System.currentTimeMillis();
        String concatV1 = concatWithString();
        System.out.println("Time taken by Concatenating with String is: " + (System.currentTimeMillis() - startTime));

        System.out.println('\n');

        startTime = System.currentTimeMillis();
        String concatV2 = concatWithStringBuffer();
        System.out.println("Time taken by Concatenating with StringBuilder is: " + (System.currentTimeMillis() - startTime));
    }

    private static class MyString {
        private final char[] value;
        MyString (String data) {
            this.value = data.toCharArray();
        }

        public String getValue() {
            return new String(this.value);
        }
        public String myConcat(String strConcat) {
            if (strConcat.isEmpty()) {
                return new String(this.value);
            }
            int len = value.length;
            int otherLen = strConcat.length();
            char[] buf = Arrays.copyOf(value, len + otherLen);
            strConcat.getChars(0, strConcat.length(), buf, len);
            return new String(buf);
        }

        public boolean myEquals(Object anObject) {
            if (this == anObject) {  // reference
                return true;
            }
            char[] val = this.value;    /* avoid getfield opcode */
            if (anObject instanceof String anotherString) {  // instanceof can cast
                int n = val.length;
                if (anotherString.length() == n) {
                    char[] v2 = anotherString.toCharArray();
                    int i = 0;
                    while (i < n) {
                        if (val[i] != v2[i]) {
                            return false;
                        }
                        i++;
                    }
                    return true;
                }
            }
            return false;
        }

        public static String myJoin(CharSequence delimiter, Iterable<? extends CharSequence> elements) {
            Iterator<? extends CharSequence> it = elements.iterator();
            StringBuilder result = new StringBuilder();
            if (it.hasNext()) {
                result.append(it.next());
            }
            while (it.hasNext()) {
                result.append(delimiter).append(it.next());
            }
            return result.toString();
        }

        public static String myJoinV2(CharSequence delimiter, Iterable<? extends CharSequence> elements) {
            StringJoiner sj = new StringJoiner(delimiter);
            for (CharSequence c: elements) {
                sj.add(c);
            }
            return sj.toString();
        }

        public String myReplaceNaive(char oldChar, char newChar) {
            char[] val = this.value;    /* avoid getfield opcode */
            int len = val.length;
            if (oldChar != newChar) {
                int i = 0;
                while (i < len) {
                    if (val[i] != oldChar) {
                        i++;
                    } else {
                        break;
                    }
                }
                if (i < len) {
                    char[] buf = new char[len];
                    for (int j = 0; j < i; j++) {
                        buf[j] = val[j];
                    }
                    while (i < len) {
                        buf[i] = (val[i] == oldChar) ? newChar: val[i];
                        i++;
                    }
                    return new String(buf);
                }
                return new String(val);
            }
            return new String(this.value);
        }

        public String myReplace(char oldChar, char newChar) {
            char[] val = this.value;    /* avoid getfield opcode */
            if (oldChar != newChar) {
                int i = 0;
                int len = val.length;
                while (i < len) { // using while (i++ < len) => OK
                    if (val[i] == oldChar) {
                        break;
                    }
                    i++;
                }
                if (i < len) {
                    char[] buf = new char[len];
                    System.arraycopy(val, 0, buf, 0, i);
                    while (i < len) {  // using while (i++ < len) => ERROR
                        buf[i] = (val[i] == oldChar) ? newChar: val[i];
                        i++;
                    }
                    return new String(buf);
                }
            }
            return new String(val);
        }

        public boolean myStartsWith(String prefix, int offset) {
            char[] ta = this.value;  // this array
            int to = offset;   // this offset
            char[] pa = prefix.toCharArray(); // prefix array
            int po = 0;  // prefix offset
            int pc = prefix.length(); // prefix count
            if (to < 0 || to > ta.length - pc) {
                return false;
            }
            while (--pc >= 0) {
                if (ta[to++] != pa[po++]) {
                    return false;
                }
            }
            return true;
        }

        public boolean myStartsWith(String prefix) {
            return myStartsWith(prefix, 0);
        }

        public String myTrim() {
            char[] val = this.value;  /* avoid getfield opcode */
            int len = val.length;
            int st = 0; // start
            while ((st < len) && (val[st] <= ' ')) {  // leading space
                st++;
            }
            while ((st < len) && (val[len-1] <= ' ')) {   // trailing space
                len--;
            }
        return ((st > 0) || (len < val.length)) ? new String(val).substring(st, len): new String(val);
        }
    }

    public static void main(java.lang.String[] args) {

        String inputV1 = "LeKhacTrinh";
        String inputV2 = "abcdcba";
        String inputV3 = "le  khac   trinh";
        String inputV4 = "Keep";
        String inputV5 = "Peek";
        String inputV6 = "How do you find duplicate characters in a string";
        String inputV7 = "This is a string";
        String inputV8 = "his is a stringT";

        System.out.println("----------------Q1. Reverse string-----------------------");
        System.out.println("The original string is: " + inputV1);
        System.out.println("After reversing by method V1, the string is: " + reverseStringV1(inputV1));
        System.out.println("After reversing by method V2, the string is: " + reverseStringV2(inputV1));
        System.out.println('\n');

        System.out.println("----------------Q2. Check palindrome-----------------------");
        if (isPalindromeV1(inputV2)) {
            System.out.println("The original string is palindrome");
        } else {
            System.out.println("The original string is NOT palindrome");
        }
        System.out.println('\n');

        System.out.println("----------------Q3. Capitalize each word-----------------------");
        System.out.println("The original string is: " + inputV3);
        System.out.println("After capitalizing each word, the string is: " + capitalizeWord(inputV3));
        System.out.println('\n');

        System.out.println("----------------Q4. Reverse each word-----------------------");
        System.out.println("The original string is: " + inputV3);
        System.out.println("After reversing each word, the string is: " + reverseWord(inputV3));
        System.out.println('\n');

        System.out.println("----------------Q5. Testing performance by String and StringBuilder when concatenating-----------------------");
        testPerformanceStringVsStringBuilder();
        System.out.println('\n');

        System.out.println("----------------Q6. Check anagram of two strings-----------------------");
        boolean isAnagram = isAnagram(inputV4, inputV5);
        if (isAnagram) {
            System.out.println(inputV4 + " and " + inputV5 + " are anagrams.");
        } else {
            System.out.println(inputV1 + " and " + inputV5 + " are NOT anagrams.");
        }
        System.out.println('\n');

        System.out.println("----------------Q7. Find duplicates character in a string-----------------------");
        findDuplicateCharacter(inputV6);
        System.out.println('\n');

        System.out.println("----------------Q8. Find duplicates character in a string-----------------------");
        if (isRotation(inputV7, inputV8)) {
            System.out.println("The two string " + inputV7 + " and " + inputV8 + " are rotation.");
        } else {
            System.out.println("The two string " + inputV7 + " and " + inputV8 + " are NOT rotation.");
        }
        System.out.println('\n');

        System.out.println("----------------Q9. Remove character at particular position-----------------------");
        System.out.println("The original string is: " + inputV1);
        int position = 5;
        System.out.println("The modified string after remove character at " + position + " is " + removeCharacter(inputV1, position));
        System.out.println('\n');

        System.out.println("----------------Q10. Swap two strings without using temp variable-----------------------");
//        System.out.println("The original first string is: " + inputV1);
//        System.out.println("The original second string is: " + inputV2);
        swapTwoString(inputV1, inputV2);
//        System.out.println("The first string after swapping is: " + inputV1);
//        System.out.println("The second string after swapping is: " + inputV2);
        System.out.println('\n');

        System.out.println("----------------Q11. Re-implement concatenate method-----------------------");
        MyString myStringV1 = new MyString("Re-implement");
        String output = myStringV1.myConcat("concatenate method");
        System.out.println("The modified string is: " + output);
        System.out.println('\n');

        System.out.println("----------------Q12. Re-implement equals method-----------------------");
        MyString myStringV2 = new MyString("Le Khac Trinh");
        String target = "Le Khac Trinh";
        boolean checkV1 = myStringV2.myEquals(target);
        if (checkV1) {
            System.out.println("The two object " + myStringV2.getValue() + " and " + target + " equals.");
        } else {
            System.out.println("The two objects " + myStringV2.getValue() + " and " + target + " NOT equals");
        }
        System.out.println('\n');

        System.out.println("----------------Q13. Re-implement join method-----------------------");
        String date = MyString.myJoin("/",List.of("25","06","2024"));
        System.out.print(date);

        String time = MyString.myJoinV2(":", List.of("21","10","10"));
        System.out.print(" " + time);
        System.out.println('\n');

        System.out.println("----------------Q14. Re-implement replace method-----------------------");
        MyString myStringV3 = new MyString("Re-implement replace method");
        String resultV1 = myStringV3.myReplaceNaive('R', 'r');
        String resultV2 = myStringV3.myReplace('R', 'r');
        System.out.println("The string after modification by method V1 is: " + resultV1);
        System.out.println("The string after modification by method V2 is: " + resultV2);
        System.out.println('\n');

        System.out.println("----------------Q15. Re-implement startWith method-----------------------");
        MyString myStringV4 = new MyString("Re-implement startWith method");
        String startWithStringV1 = "Re--";
        String startWithStringV2 = "implement-";
        int offset = 3;

        boolean checkV2 = myStringV4.myStartsWith(startWithStringV1);  // offset = 0
        boolean checkV3 = myStringV4.myStartsWith(startWithStringV2, offset);
        if (checkV2) {
            System.out.println("The original string is startsWith " + startWithStringV1 + " at beginning.");
        } else {
            System.out.println("The original string is NOT startsWith " + startWithStringV1 + " at beginning.");
        }
        if (checkV3) {
            System.out.println("The original string is startsWith " + startWithStringV2 + " at offset " + offset);
        } else {
            System.out.println("The original string is NOT startsWith " + startWithStringV2 + " at offset " + offset);
        }
        System.out.println('\n');

        System.out.println("----------------Q16. Re-implement trim method-----------------------");
        MyString myStringV5 = new MyString("  hello world      ");
        String trimmedString = myStringV5.myTrim();
        System.out.println("The modified string after trimming is: " + trimmedString);
        System.out.println('\n');
    }
}


