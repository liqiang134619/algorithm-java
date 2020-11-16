package algorithm.leetcode;

import sun.misc.ClassFileTransformer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * 1160. 拼写单词
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和。
 *
 *
 *
 * 示例 1：
 *
 * 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 * 输出：6
 * 解释：
 * 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 示例 2：
 *
 * 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * 输出：10
 * 解释：
 * 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 * @author liq
 * @date 2020/6/26
 */
public class Demo1106 {

    public static void main(String[] args) {

        String[] words = {"cat","bt","hat","tree"};
        String s  = "atach";
        System.out.println(countCharacters(words, s));


    }

    private static int countCharacters(String[] words, String chars) {
        char[] chars1 = chars.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>(chars.length());
        for (char c : chars1) {
            hashMap.put(c,hashMap.getOrDefault(c,0) + 1);
        }
        int sum = 0;
        Map<Character,Integer> map = null;
        for (String word : words) {
            boolean flag = true;
            char[] chars2 = word.toCharArray();
            map = new HashMap<>();
            for (char c : chars2) {
                map.put(c,map.getOrDefault(c,0) + 1);
            }
            Set<Character> characters = map.keySet();
            for (Character character : characters) {
                Integer integer = hashMap.getOrDefault(character,0);
                if(integer<map.get(character)){
                    flag = false;
                    break;
                }
            }
            if(flag) {
                sum +=chars2.length;
            }
        }
        return sum;
    }
}
