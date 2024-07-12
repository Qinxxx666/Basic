import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Title: DoublePoints
 * @Author Qin
 * @Package PACKAGE_NAME
 * @Version 1.0
 * @Date 2024/6/5 16:15
 * @description:
 */
public class DoublePoints {
    @Test
    public void moveZeros283(){
        int[] nums = {0,1,0,3,12};
        int[] expected = {1,3,12,0,0};
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
        int j = 0;
        for(int i=0;i<nums.length;++i) {
            if(nums[i]!=0) {
                nums[j++] = nums[i];
            }
        }
        //非0元素统计完了，剩下的都是0了
        //所以第二次遍历把末尾的元素都赋为0即可
        for(int i=j;i<nums.length;++i) {
            nums[i] = 0;
        }
        for(int i=0;i<nums.length;++i) {
            System.out.println(nums[i]);
        }
    }
    @Test
    public void containerWithMostWater11(){
        int[] height = {1,8,6,2,5,4,8,3,7};
        int expected = 49;
        int i,j,res;
        res=0;
        for(i=0;i<height.length;++i){
            for(j=i;j<height.length;++j){
                res = Math.max(res,(j-i)*Math.min(height[i],height[j]));
            }
        }
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        System.out.println(res);
    }
    @Test
    public void _3sum15(){
        int[] nums = {-1,0,1,2,-1,-4};
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        System.out.println(ans);
    }
    @Test
    public void rain42(){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int n = height.length;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];

        // 计算每个位置左侧的最大高度
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // 计算每个位置右侧的最大高度
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;

        // 每个位置能接的雨水量等于两个最大高度的较小值减去当前高度
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        System.out.println(ans);
    }
}
