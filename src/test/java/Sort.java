import org.junit.Test;

import java.util.Comparator;

/**
 * @Title: Sort
 * @Author Qin
 * @Package PACKAGE_NAME
 * @Version
 * @Date 2024/6/12 9:48
 * @description:
 */
public class Sort {

    @Test
    public void test(){
        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; i++) {
            a[i] = (int) (Math.random() * 100);
        }
        Merge.sort(a);
        Example.show(a);
    }
    /**
     * 归并排序
     */
    public static class Merge{
        private static Comparable[] aux;       // 归并所需的辅助数组
        public static void sort(Comparable[] a) {
            aux = new Comparable[a.length];    // 一次性分配空间
            sort(a, 0, a.length -1);
        }
        private static void sort(Comparable[] a, int lo, int hi) {  // 将数组a[lo..hi]排序
            if (hi <= lo) return;
            int mid = lo + (hi - lo)/2;
            sort(a, lo, mid);        // 将左半边排序
            sort(a, mid+1, hi);      // 将右半边排序
            merge(a, lo, mid, hi);  // 归并结果（代码见“原地归并的抽象方法”）
        }
        public static void merge(Comparable[] a, int lo, int mid, int hi) {
            // 将a[lo..mid] 和a[mid+1..hi] 归并
            int i = lo, j = mid+1;
            // 将a[lo..hi]复制到aux[lo..hi]
            if (hi + 1 - lo >= 0) System.arraycopy(a, lo, aux, lo, hi + 1 - lo);
            for (int k = lo; k <= hi; k++)  // 归并回到a[lo..hi]
                if      (i > mid)                       a[k] = aux[j++];
                else if (j > hi )                       a[k] = aux[i++];
                else if (Example.less(aux[j], aux[i]))  a[k] = aux[j++];
                else                                    a[k] = aux[i++];
        }
    }
    /**
     * 插入排序
     */
    public static class Insertion {
        /**
         * 对数组a进行排序
         * @param a
         */
        public static void sort(Comparable[] a) {
            for (int i = 1; i < a.length; i++) {
                for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                    exch(a, j, j - 1);
                }
            }
        }
        /**
         * 比较数组中两个元素的大小
         * low小于high时返回真
         * @param low
         * @param high
         * @return
         */
        private static boolean less(Comparable low, Comparable high) {
            return low.compareTo(high) < 0;
        }

        /**
         * 交换两个元素
         * @param a
         * @param i
         * @param j
         */
        private static void exch(Comparable[] a, int i, int j) {
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        /**
         * 遍历并打印数组
         * @param a
         */
        private static void show(Comparable[] a) {  // 在单行中打印数组
            for (int i = 0; i < a.length; i++){
                System.out.println(a[i] + " ");
            }
        }

        public static boolean isSorted(Comparable[] a) {  // 测试数组元素是否有序
            for (int i = 1; i <a.length; i++) {
                if (less(a[i], a[i - 1])) return false;
            }
            return true;
        }
    }
    /**
     * 排序算法需要实现的API
     */
    public static class Selection {
        /**
         * 对数组a进行排序
         * @param a
         */
        public static void sort(Comparable[] a) {
            if (a.length <= 1) return;
            for (int i = 0; i < a.length; i++) {
                int min = i;
                for (int j = i; j < a.length; j++) {
                    if (less(a[j], a[min])) {
                        min = j;
                    }
                }
                exch(a, i, min);
            }
        }
        /**
         * 比较数组中两个元素的大小
         * low小于high时返回真
         * @param low
         * @param high
         * @return
         */
        private static boolean less(Comparable low, Comparable high) {
            return low.compareTo(high) < 0;
        }

        /**
         * 交换两个元素
         * @param a
         * @param i
         * @param j
         */
        private static void exch(Comparable[] a, int i, int j) {
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        /**
         * 遍历并打印数组
         * @param a
         */
        private static void show(Comparable[] a) {  // 在单行中打印数组
            for (int i = 0; i < a.length; i++){
                System.out.println(a[i] + " ");
            }
        }

        public static boolean isSorted(Comparable[] a) {  // 测试数组元素是否有序
            for (int i = 1; i <a.length; i++) {
                if (less(a[i], a[i - 1])) return false;
            }
            return true;
        }
    }
    public static class Example {
        /**
         * 对数组a进行排序
         * @param a
         */
        public static void sort(Comparable[] a) {
            System.out.println("算法未实现");
        }
        /**
         * 比较数组中两个元素的大小
         * low小于high时返回真
         * @param low
         * @param high
         * @return
         */
        private static boolean less(Comparable low, Comparable high) {
            return low.compareTo(high) < 0;
        }

        /**
         * 交换两个元素
         * @param a
         * @param i
         * @param j
         */
        private static void exch(Comparable[] a, int i, int j) {
            Comparable t = a[i];
            a[i] = a[j];
            a[j] = t;
        }

        /**
         * 遍历并打印数组
         * @param a
         */
        private static void show(Comparable[] a) {  // 在单行中打印数组
            for (int i = 0; i < a.length; i++){
                System.out.println(a[i] + " ");
            }
        }

        public static boolean isSorted(Comparable[] a) {  // 测试数组元素是否有序
            for (int i = 1; i <a.length; i++) {
                if (less(a[i], a[i - 1])) return false;
            }
            return true;
        }
    }
}
