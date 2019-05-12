package search;

/**
 * 二分查找
 */
public class BitSearch {

    /**
     * 二分查找
     *
     * @param array 排好序的数组
     * @param value 要查找的值
     * @return
     */
    public static int bitSearch(int[] array, int value) {
        int length = array.length;
        int low = 0;
        int high = length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == value) {
                return mid;
            }else if (array[mid] > value) {
                high = mid - 1;
            } else if (array[mid] < value) {
                low = mid + 1;
            }
        }
        return -1;
    }

    // 二分查找的递归实现
    public static int bsearch(int[] a, int val) {
        return bsearchInternally(a, 0, a.length - 1, val);
    }

    private static int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;

        int mid =  low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid+1, high, value);
        } else {
            return bsearchInternally(a, low, mid-1, value);
        }
    }


}
