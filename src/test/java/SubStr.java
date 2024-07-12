import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;

/**
 * @Title: SubStr
 * @Author Qin
 * @Package PACKAGE_NAME
 * @Version 1.0
 * @Date 2024/6/6 14:32
 * @description: 子串
 */
public class SubStr {
    @Test
    public void subarraySum560(){
        int[] nums = {1,1,1,2,1,1,3,4,5};
        int k = 2;

        // 计算子数组和等于 k 的个数
        int count = 0, pre = 0;

        // 哈希表存储前缀和及其出现次数
        HashMap<Integer,Integer> mp = new HashMap<> ();

        // 初始化哈希表
        mp.put(0, 1);

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {

            // 更新前缀和
            pre += nums[i];

            // 如果前缀和 - k 存在于哈希表中，则说明存在一个子数组和为 k
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }

            // 更新哈希表中前缀和的出现次数
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        System.out.println(mp.toString());
        System.out.println(count);
    }
    @Test
    public void maxSlidingWindow239(){
        //真几把难
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;

        //这个解法根本看不懂啊，得整点看得懂的解法
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; ++i) {
            //如果刚好是k的倍数就写入当前值
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }
            //如果不是就写入前一个值和当前值中最大的那一个
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }

        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        System.out.println(Arrays.toString(prefixMax));
        System.out.println(Arrays.toString(suffixMax));
        System.out.println(Arrays.toString(ans));
    }
}
