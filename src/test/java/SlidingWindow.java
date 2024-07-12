import org.junit.Test;

import java.util.*;

/**
 * @Title: SlidingWindow
 * @Author Qin
 * @Package PACKAGE_NAME
 * @Version 1.0
 * @Date 2024/6/6 10:47
 * @description:
 */
public class SlidingWindow {
    @Test
    public void lengthOfLongestSubstring3() {
        String s = "abcabcbb";
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        System.out.println(ans);
    }
    @Test
    public void findallanagramsinastring438(){
        String s = "cbaebabacd", p = "abc";
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            System.out.println("没有");
        }

        // 哈希表，记录字符出现的次数
        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];

        // 初始化
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        // 数组相等，说明窗口已形成
        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        // 开始滑动窗口
        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        System.out.println(ans);
    }
}
