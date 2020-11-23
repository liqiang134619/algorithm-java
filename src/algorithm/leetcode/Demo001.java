package algorithm.leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *  
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * @author Liq
 * @date 2020/6/29
 */
public class Demo001 {

    public static void main(String[] args) {

        String s = "tactcoar";
        System.out.println(canPermutePalindrome(s));


    }

    private static boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char aChar : chars) {
            map.put(aChar,map.getOrDefault(aChar,0) + 1);
        }

        int count = 0;
        for (Integer value : map.values()) {
            if(value % 2 ==1){
                count++;
            }
            if(count > 1) {
                return false;
            }
        }

        return true;

    }



    public boolean canPermutePalindrome1(String s) {


        int[] arr = new int[128];
        for (int c: s.toCharArray()) {
            arr[c]++;
        }
        int flag = 0;
        for (int i: arr) {
            if (i%2==1){
                flag++;
            }
        }
        if (flag<=1){
            return true;
        }
        return false;
    }
}
