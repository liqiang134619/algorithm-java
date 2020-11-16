package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 *
 * @author Liq
 * @date 2020/6/23
 */
public class Demo844 {

    public static void main(String[] args) {
        String s = "ab#c";

        String s1 = "ad#c";
        System.out.println(backspaceCompare(s, s1));
    }

    public static boolean backspaceCompare(String S, String T) {
        List<Character> list1 = new ArrayList<>();

        List<Character> list2 = new ArrayList<>();


        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '#') {
                if(!(list1.size()<=0)){
                    list1.remove(list1.size() - 1);
                }
            } else {
                list1.add(c);
            }
        }
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c == '#') {
                if(!(list2.size()<=0)){
                    list2.remove(list2.size() - 1);
                }
            } else {
                list2.add(c);
            }
        }
        if(list1.size() != list2.size()) {
            return false;
        }
        int k = 0;
        while (k < list1.size()) {
            if (!list1.get(k).equals(list2.get(k))){
                return false;
            }

        }
        return true;

    }
}
