package algorithm.leetcode;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "race a car"
 * 输出: false
 *
 * @author liq
 * @date 2020/6/22
 */
public class Demo25 {

    public static void main(String[] args) {
        String s = "0P";

        System.out.println(isPalindrome(s));

    }

    private static boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;
        while (begin < end) {
            char bchar = s.charAt(begin);
            char echar = s.charAt(end);

            if (!Character.isAlphabetic(bchar) && !Character.isDigit(bchar)) {
                begin++;
                continue;
            }
            if (!Character.isAlphabetic(echar) && !Character.isDigit(echar)) {
                end--;
                continue;
            }
            if (Character.toLowerCase(bchar) == Character.toLowerCase(echar)) {
                begin++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
