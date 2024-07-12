package Basic;

import org.junit.Test;

import java.util.*;

/**
 * @Title: LinkedList
 * @Author Qin
 * @Package Basic
 * @Version
 * @Date 2024/6/12 15:44
 * @description:
 */
public class LinkedList<T> {
    public static class ListNodeOpr{
        static ListNode init(ListNode head, int[] arr) {
            ListNode p = head;
            for (int i = 0; i < arr.length; i++) {
                p.next = new ListNode(arr[i]);
                p = p.next;
            }
            return head.next;
        }

        static void print(ListNode head) {
            ListNode p = head;
            while (p != null) {
                System.out.print(p.val + " ");
                p = p.next;
            }
            System.out.println();
        }
        static ListNode merge(ListNode l1, ListNode l2){
            ListNode dummy = new ListNode(-1);
            dummy.next = l1;
            ListNode p = dummy;
            while (p.next != null) {
                p = p.next;
            }
            p.next = l2;
            return dummy.next;
        }
        static ListNode reverse(ListNode head) {
            ListNode p = head;
            ListNode pre = null;
            while (p != null) {
                ListNode next = p.next;
                p.next = pre;
                pre = p;
                p = next;
            }
            return pre;
        }
        static ListNode getLast(ListNode head) {
            ListNode p = head;
            while (p.next != null) {
                p = p.next;
            }
            return p;
        }
        static ListNode getMiddle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
        int getLength(ListNode head) {
        ListNode p = head;
            int len = 0;
            while (p != null) {
                len++;
                p = p.next;
            }
            return len;
        }
        static ListNode getKth(ListNode head, int k) {
            ListNode p = head;
            while (k > 1 && p != null) {
                p = p.next;
                k--;
            }
            return p;
        }
        static ListNode getKthFromEnd(ListNode head, int k) {
            ListNode p = head;
            int len = 0;
            while (p != null) {
                len++;
                p = p.next;
            }
            int i = len - k;
            p = head;
            while (i > 0) {
                p = p.next;
                i--;
            }
            return p;
        }
        static ListNode delete(ListNode head, int val) {
            ListNode p = head;
            while (p.next != null) {
                if (p.next.val == val)
                    p.next = p.next.next;
                p = p.next;
            }
            return  head;
        }
    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    int gcd(int x,int y){
        if(y==0) return x;
        return gcd(y,x%y);
    }
    @Test
    public void reverseKGroup25() {
        int target = 9;
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] nums = new int[10];
        for(int i=0;i<nums.length;++i){
            if(map.containsKey(target-nums[i])) return;
            map.put(nums[i],i);
        }
//        if(head==null||head.next==null) return head;
        int[] a = {-1,5,3,4,0};
        ListNode head = ListNodeOpr.init(new ListNode(), a);
        int k = 3;
        ListNode dummy = new ListNode(Integer.MIN_VALUE,head);
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        int n = 0;
        while(p1!=null){
            if(n%k==0){
                //
                System.out.println(p1.val);
            }
            n++;
            p1 = p1.next;
        }
    }

    @Test
    public void sortList148(){
        int[] a = {-1,5,3,4,0};
        ListNode head = ListNodeOpr.init(new ListNode(), a);

        ListNodeOpr.print(sortList(head));
//        ListNode dummy = new ListNode(Integer.MIN_VALUE,head);
//        ListNode p1 = dummy;
//        ListNode p2 = dummy.next;
//        while(p1.next!=null){
//            while(p2.next!=null) {
//                if (p1.next.val > p2.next.val) {
//                    ListNode next = p2.next.next;
//                    p2.next.next = p1.next;
//                    p1.next = p2.next;
//                    p2.next = next;
//                } else {
//                    p2 = p2.next;
//                }
//            }
//            p1 = p1.next;
//            p2 = p1.next;
//        }
//        ListNodeOpr.print(dummy.next);
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) return head;
        int n = 0;
        ListNode p1,p2;
        p1 = head;
        while(p1!=null){
            p1 = p1.next;
            n++;
        }
        p1 = head;
        for(int i = 0;i<n/2-1;++i){
            p1 = p1.next;
        }
        p2 = p1.next;
        p1.next = null;
        p1 = head;
        p1 = sortList(p1);
        p2 = sortList(p2);
        return mergeTwoLists(p1,p2);
    }
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode dummy = new ListNode(-1),p;
//        p = dummy;
//        while(list1!=null&&list2!=null) {
//            if (list1.val <= list2.val) {
//                p.next = list1;
//                list1 = list1.next;
//            } else {
//                p.next = list2;
//                list2 = list2.next;
//            }
//            p = p.next;
//        }
//        if(list1!=null)
//            p.next = list1;
//        if(list2!=null)
//            p.next = list2;
//        return dummy.next;
//    }
    @Test
    public void swapPairs24(){
        int[] a = {1,2,3,4};
        ListNode head = ListNodeOpr.init(new ListNode(), a);
        ListNodeOpr.print(head);
    }
    @Test
    public void removeNthFromEnd19(){
        int[] a = {1,2,3,4,5};
        int k = 2;
        ListNode head = ListNodeOpr.init(new ListNode(), a);
        ListNodeOpr.print(head);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int i = len - k;
        p = dummy;
        while (i > 0) {
            p = p.next;
            i--;
        }
        System.out.println(p.val);
        p.next = p.next.next;
        //p = ListNodeOpr.getKthFromEnd(dummy, 2+1);
        //p.next = p.next.next;
        ListNodeOpr.print(dummy.next);
    }
    @Test
    public void addTwoNumbers2(){
        int[] a = {2,4,3};
        int[] b = {5,6,4};
        ListNode l1 = ListNodeOpr.init(new ListNode(), a);
        ListNode l2 = ListNodeOpr.init(new ListNode(), b);
        ListNodeOpr.print(l1);
        ListNodeOpr.print(l2);
        ListNode dummy = new ListNode(-1),p;
        p=dummy;
        int carry=0;
        while(l1!=null||l2!=null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            p.next = new ListNode(sum % 10);
            p = p.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        if(carry>0){
            p.next = new ListNode(1);
        }
        ListNodeOpr.print(dummy.next);
    }
    @Test
    public void mergeTwoLists21(){
        int[] a = {1,2,4};
        int[] b = {1,3,4};
        ListNode l1 = ListNodeOpr.init(new ListNode(), a);
        ListNode l2 = ListNodeOpr.init(new ListNode(), b);
        ListNodeOpr.print(l1);
        ListNodeOpr.print(l2);
        ListNode dummy = new ListNode(-1),p;
        p = dummy;
        while(l1!=null&&l2!=null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1!=null)
            p.next = l1;
        if(l2!=null)
            p.next = l2;
        ListNodeOpr.print(dummy.next);
    }
    /**
     * Floyd 判圈算法 快慢指针
     */
    @Test
    public void hasCycle141(){
        int[] a = {3,2,0,-4};
        int pos = 1;
        int n = 10;
        ListNode head = ListNodeOpr.init(new ListNode(), a);
        ListNode last = ListNodeOpr.getLast(head);
        last.next = ListNodeOpr.getKth(head, pos+1);

        //哈希表法
//        ListNode p = head;
//
//        Map<ListNode, Boolean> map = new HashMap<>();
//        while(p != null){
//            if(map.get(p)!=null && map.get(p)) {
//                System.out.println("true");
//                return;
//            }
//            map.put(p, true);
//            p = p.next;
//        }
//        System.out.println("false");

        //哈希表Set
//        p = head;
//        Set<ListNode> set = new HashSet<>();
//        while(p!=null){
//            if (!set.add(p)) {
//                System.out.println("true");
//                return;
//            }
//            p=p.next;
//        }
//        System.out.println("false");
        //快慢指针法
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                System.out.println("false");
                return;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.val+"true");
    }
    @Test
    public void isPalindrome234(){
        int[] a = {1,2,2,1};
        ListNode head = ListNodeOpr.init(new ListNode(), a);
        ListNodeOpr.print(head);
        Stack<Integer> stack = new Stack<>();
        ListNode p = head;
        while(p != null){
            stack.push(p.val);
            p = p.next;
        }
        while(head != null){
            //System.out.println(head.val+","+stack.pop());
            if (head.val != stack.pop())
                System.out.println(false);
            head = head.next;
        }
        if (stack.isEmpty())
            System.out.println(true);
        System.out.println(false);
    }
    @Test
    public void reverseList206(){
        int[] a = {1,2,3,4,5};
        ListNode head = ListNodeOpr.init(new ListNode(), a);
        ListNodeOpr.print(head);
        head = ListNodeOpr.reverse(head);
        ListNodeOpr.print(head);
    }
    @Test
    public void getIntersectionNode160() {
        int[] a = {4,1};
        int[] b = {5,0,1};
        int[] c = {8,4,5};
        //int skipA = 2, skipB = 3;
        ListNode listNode1 = ListNodeOpr.init(new ListNode(), a);
        ListNode listNode2 = ListNodeOpr.init(new ListNode(), b);
        ListNode listNode3 = ListNodeOpr.init(new ListNode(), c);
        listNode1 = ListNodeOpr.merge(listNode1, listNode3);
        listNode2 = ListNodeOpr.merge(listNode2, listNode3);

        ListNodeOpr.print(listNode1);
        ListNodeOpr.print(listNode2);
        ListNode p1 = listNode1;
        ListNode p2 = listNode2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == p2) {
                break;
            }
            if (p1 == null) {
                p1 = listNode2;
            }
            if (p2 == null) {
                p2 = listNode1;
            }
        }
        ListNodeOpr.print(p1);
        System.out.println(p1.val);
//        ListNode dummy1 = new ListNode(-1);
//        dummy1.next = listNode1;
//
//        ListNode dummy2 = new ListNode(-1);
//        dummy2.next = listNode2;
//        while(dummy1.next != null) {
//            while (dummy2.next != null) {
//                if (dummy1.next == dummy2.next){
//                    ListNodeOpr.print(dummy1.next);
//                }
//                dummy2.next = dummy2.next.next;
//            }
//            dummy2.next = listNode2;
//            dummy1.next = dummy1.next.next;
//        }
    }

    /**
     * 合并两个有序链表
     */
    @Test
    public void testLinkedList() {
        int[] a = {1,2,4,5,8};
        int[] b = {1,3,4,6,9,10};

        ListNode listNode1 = new ListNode(a[0]);
        ListNode listNode2 = new ListNode(b[0]);
        ListNode dummy = new ListNode(-1);
        //头插法
        dummy.next = listNode1;
        for (int i = 1; i < a.length; i++) {
            listNode1.next = new ListNode(a[i]);
            listNode1 = listNode1.next;
        }
        listNode1 = dummy.next;
        dummy.next = listNode2;
        //试试尾插法
        for (int i = b.length-1; i > 0; --i) {
            ListNode p = new ListNode(b[i]);
            p.next = listNode2.next;
            listNode2.next = p;
        }
        //listNode2 = dummy.next;
        ListNode listNode3 = mergeTwoLists(listNode1, listNode2);
        while (listNode3 != null) {
            System.out.print(listNode3.val + " ");
            listNode3 = listNode3.next;
        }
    }

    /**
     * 分隔链表 leetcode86
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        // 存放小于 x 的链表的虚拟头结点
        ListNode dummy1 = new ListNode(-1);
        // 存放大于等于 x 的链表的虚拟头结点
        ListNode dummy2 = new ListNode(-1);
        // p1, p2 指针负责生成结果链表
        ListNode p1 = dummy1, p2 = dummy2;
        // p 负责遍历原链表，类似合并两个有序链表的逻辑
        // 这里是将一个链表分解成两个链表
        ListNode p = head;
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            } else {
                p1.next = p;
                p1 = p1.next;
            }
            // 不能直接让 p 指针前进，
            // p = p.next
            // 断开原链表中的每个节点的 next 指针
            ListNode temp = p.next;
            p.next = null;
            p = temp;
        }
        // 连接两个链表
        p1.next = dummy2.next;
        return dummy1.next;
    }

    /**
     * 合并有序链表
     * @param l1
     * @param l2
     * @return
     */
    ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 虚拟头结点
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = l1, p2 = l2;

        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }
        if (p1 != null) {
            p.next = p1;
        }
        if (p2 != null) {
            p.next = p2;
        }
        return dummy.next;
    }
}
