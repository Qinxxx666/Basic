package Basic;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Title: Basic.BasicData
 * @Author Qin
 * @Package PACKAGE_NAME
 * @Version 1.0
 * @Date 2024/6/7 9:47
 * @description:
 */
public class BasicData {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //数组题目：485，283，27
    @Test
    public void ArrayListTest() {
        int[] a = {1,2,3};
    }
    @Test
    public void findMaxConsecutiveOnes485(){
        int[] nums = {1,1,0,1,1,1};
        int ans=0,count=0;

        for (int num : nums){
            count=num==1?count+1:0;
            ans=Math.max(ans,count);
        }
        System.out.println(ans);
        // int maxCount = 0, count = 0;
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     if (nums[i] == 1) {
        //         count++;
        //     } else {
        //         maxCount = Math.max(maxCount, count);
        //         count = 0;
        //     }
        // }
        // maxCount = Math.max(maxCount, count);
        // return maxCount;

        // int n = nums.length, res = 0;
        // for (int i = 0; i < n; i++) {
        //     int j = i;
        //     while (j < n && nums[j] == 1) j++;
        //     res = Math.max(res, j - i);
        //     i = j;
        // }
        // return res;
    }

    @Test
    public void removeElement27(){
        int[] nums = {0,1,2,2,3,4,0,2};
        int val = 2;
        int j = 0;
        for(int i = 0;i<nums.length;++i){
            if(nums[i]!=val){
                nums[j] = nums[i];
                ++j;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void removeDuplicates26(){
        int[] nums = {1,1,2,2,2,3,4,5,5,6};
        int j = 0;
        if(nums.length == 1) return;
        for(int i = 1;i<nums.length;++i){
            if(nums[i]!=nums[i-1]){
                ++j;
                nums[j] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(nums.length);
    }

    @Test
    public void removeDuplicates80(){
        int[] nums = {1,1,2,2,2,3,4,5,5,6};
        int j = 0;
        if(nums.length <= 2) return;
        for(int i = 2;i<nums.length;++i){
            if(nums[i]!=nums[i-2]){
                ++j;
                nums[j] = nums[i-1];
            }
        }
        nums[++j] = nums[nums.length-1];
        System.out.println(Arrays.toString(nums));
        System.out.println(j);
    }
    //removeDuplicates的通用解法
    int process(int[] nums, int k) {
        int u = 0;
        for (int x : nums) {
            if (u < k || nums[u - k] != x) nums[u++] = x;
        }
        return u;
    }

    @Test
    public void applyOperations2460(){
        int[] nums = {1,2,2,1,1,0};
        int[] ans = new int[nums.length];
        int j = 0;
        for(int i = 0;i<nums.length-1;++i){
            if(nums[i]==nums[i+1]&&nums[i]!=0){
                nums[i]=2*nums[i];
                nums[i+1]=0;
            }
        }
        for(int i = 0;i<nums.length;++i){
            if(nums[i]!=0){
                nums[j]=nums[i];
                ++j;
            }
        }
        while(j<nums.length){
            nums[j] = 0;
            ++j;
        }
        System.out.println(Arrays.toString(nums));
    }
    /**
     * 链表习题：
     */
    @Test
    public void deleteDuplicates82(){
        ListNode head = new ListNode(1,
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(3)))));
        //去重但保留重复
//        ListNode op = head;
//        while(op.next!=null){
//            if(op.next.val == op.val){
//                op.next = op.next.next;
//            }else{
//                op = op.next;
//            }
//        }
//        printList(head);
        //去重并删除所有重复
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        printList(dummy.next);
    }
    void printList(ListNode head){
        System.out.println(head.val);
        while(head.next!=null){
            System.out.println(head.next.val);
            head = head.next;
        }
    }
    /**
     * 队列习题
     */
    @Test
    public void RecentCounter933(){
    }
    Queue<Integer> queue = new LinkedList<>();
    public int ping(int t) {
        queue.add(t);
        while(queue.peek()<t-3000){
            queue.poll();
        }
        return queue.size();
    }
    /**
     * 栈习题
     */
    @Test
    public void isValid20(){
        String s = "({{[]}})";
        char[] stack = new char[s.length()];
        int top = -1;
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stack[++top] = c;
            }else{
                if(top==-1) return;
                char topChar = stack[top--];
                if(c==')'&&topChar!='(') return;
                if(c=='}'&&topChar!='{') return;
                if(c==']'&&topChar!='[') return;
            }
        }
        System.out.println(top);
    }
}
