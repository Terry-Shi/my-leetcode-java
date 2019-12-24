package leetcode;

import java.util.Arrays;

// 数组
// 复杂度 = O(log (m+n))
public class _004_MidNumFrom2SortedArray {
  public static void main(String[] args) {
    int[] array1 = new int[] {1,2};
    int[] array2 = new int[] {3};
    System.out.println(findMidNumFrom2SortedArray(array1, array2));
  }

  public static double findMidNumFrom2SortedArray(int[] array1, int[] array2) {
    // 两个数组组成一个大的数组，找到中位数。
    int[] newArray = new int[array1.length + array2.length];
    System.arraycopy(array1, 0,  newArray , 0, array1.length);
    System.arraycopy(array2, 0, newArray, array1.length, array2.length);
    Arrays.sort(newArray);
    int idxStart = newArray.length / 2;
    int idxEnd = (newArray.length -1) /2;
    return (newArray[idxStart] + newArray[idxEnd]) / 2;
  }


}
