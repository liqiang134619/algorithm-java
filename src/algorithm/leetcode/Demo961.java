package algorithm.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * 961. 重复 N 次的元素
 * 在大小为 2N 的数组 A 中有 N+1 个不同的元素，其中有一个元素重复了 N 次。
 *
 * 返回重复了 N 次的那个元素。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：[2,1,2,5,3,2]
 * 输出：2
 * 示例 3：
 *
 * 输入：[5,1,5,2,5,3,5,4]
 * 输出：5
 *
 * 提示：
 *
 * 4 <= A.length <= 10000
 * 0 <= A[i] < 10000
 * A.length 为偶数
 * @author liq
 * @date 2020/6/25
 */
public class Demo961 {

    public static void main(String[] args) {


    }

    private static int repeatedNTimes(int[] A) {
        int target = A.length >>1;
        Map<Integer,Integer> map = new HashMap<>(A.length);
        for (int value : A) {
            Integer integer = map.getOrDefault(value,0);
            if(integer > 1){
                return value;
            }
            map.put(value, integer + 1);
        }

        return -1;
    }
}
