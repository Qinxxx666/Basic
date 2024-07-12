package Basic;

import org.junit.Test;

import java.util.*;

/**
 * @Title: Basic.ArraysBasic
 * @Author Qin
 * @Package PACKAGE_NAME
 * @Version
 * @Date 2024/6/11 13:58
 * @description:
 */
public class ArraysBasic {
    @Test
    public void productExceptSelf238(){
        int[] nums = {1,2,3,4};
        int temp = 1;
        int[] b = new int[nums.length];
        int[] c = new int[nums.length];
        b[0] = 1;
        c[nums.length-1] = 1;
        for (int i = 1; i < nums.length; ++i) {
            b[i] = b[i-1]*nums[i-1];
        }
        System.out.println(Arrays.toString(b));
        for (int i = nums.length-2; i >= 0; --i) {
            temp = temp*nums[i+1];
            b[i] = b[i]*temp;
        }
        System.arraycopy(b, 0, nums, 0, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void rotate189() {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int[] b = new int[nums.length];
        for (int i = 0; i < nums.length-k; i++) {
            b[k+i] = nums[i];
        }
        for (int i = 0; i < k; i++) {
            b[i] = nums[nums.length-k+i];
        }
        System.arraycopy(b, 0, nums, 0, nums.length);
        System.out.println(Arrays.toString(b));
    }
    @Test
    public void merge56() {
        int[][] a = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(a)));
    }

    /**
     * 合并区间
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //二维数组按一位排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        int[][] ans = new int[intervals.length][2];
        int j = 0;
        ans[0] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            //判断buff与当前位置是否构成区间，构成则合并，不构成则buff推入
            if (ans[j][1]>=intervals[i][0]){
                ans[j][1] = Math.max(ans[j][1], intervals[i][1]);
            }else{
                ans[++j] = intervals[i];
            }
        }
        int[][] res = new int[j+1][2];
        System.arraycopy(ans, 0, res, 0, j+1);

        return res;
    }
    @Test
    public void testArray() {
        int[] arr1 = {1,1,2,2,4,6,8,9,10};
        int[] arr2 = {1,2,3,4,5,6,7,8,9,10};
        ArrayList<Integer> list = new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]==arr2[j]){
                System.out.print(arr1[i]+" ");
                list.add(arr1[i]);
                i++;
                j++;
            }else if(arr1[i]<arr2[j]){
                i++;
            }else{
                j++;
            }
        }
        System.out.println(Arrays.toString(list.toArray()));
    }
    //该题目存在多种拓展
    @Test
    public void maxProfit121() {
        int[] prices = {1,2,4,2,5,7,2,4,9,0};
        int maxProfit = 0;
        int minPrice = prices[0];
        int j = 1;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < minPrice) {
//                minPrice = prices[i];
//            } else if (prices[i] - minPrice > maxProfit) {
//                maxProfit = prices[i] - minPrice;
//            }
//        }
        //int n = prices.length;
        int count = 0;
        int[] profit = new int[prices.length];
        int dp0=0,dp1=0;
        profit[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i]<prices[i-1]){
                minPrice = prices[i];
                profit[i] = 0;
                ++count;
            }else{
                profit[i] = prices[i]-minPrice;
            }
            if(profit[i]>dp0&&profit[i]>dp1){
                dp1 = dp0;
                dp0 = profit[i];
            } else if (profit[i]<=dp0&&profit[i]>dp1) {
                dp1 = profit[i];
            }
            System.out.println(count+","+dp0+","+dp1+","+profit[i]);
        }
        System.out.println("最大利润：" + (dp0+dp1));

        int n = 5;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(1);
        //if (n == 0) return ans;
        ans.add(path);
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < i; k++) {
                Stack<Integer> stack = new Stack<>();
                stack.add(12);
                stack.peek();
                stack.pop();
                stack.push(12);
            }
        }

    }
}
