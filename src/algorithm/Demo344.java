package algorithm;

import java.util.Arrays;

/**
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * @author liq
 * @date 2020/6/20
 */
public class Demo344 {

    public static void main(String[] args) {

        char[] s = {'h','e','l','l','o'};
        reverseString1(s);
        System.out.println(Arrays.toString(s));
    }


    // 时间复杂度O(n) 二分之一n次
    private static void reverseString(char[] s) {
        for (int i = 0; i <s.length >>1 ; i++) {
            char tmp = s[i];
            s[i] = s[s.length - i -1];
            s[s.length - i -1] = tmp;
        }
    }

    // 双指针
    private static void reverseString1(char[] s) {
        int i = 0;
        int j = s.length - 1;
        while (i != j) {
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
