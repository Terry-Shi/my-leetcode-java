package leetcode;

import java.util.Arrays;

public class _026_RemoveDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] array = new int[]{1,1,2,2,3,4,5,6,6};
		int idx = removeDuplicates(array);

		System.out.println(idx);
		System.out.println(Arrays.toString(array));


	}

	public static int solution(int[] array) {
		if (array.length <= 1) {
			return 0;
		}

		int idx = 0; // 指向当前形成的不重复的数组最后一个元素
		for (int i = 1; i < array.length; i++) {
			if (array[idx] != array[i]) {
				 array[idx+1] = array[i];
				 idx++;
			}
		}
		return idx;
	}


	// 双指针
	public static int removeDuplicates(int[] nums) {
      int fisrtPoint = 0;
      int secondPoint = 0;
      while (secondPoint < nums.length) {
        if (nums[fisrtPoint] == nums[secondPoint]) {
          secondPoint++;
        } else {
          fisrtPoint++;
          nums[fisrtPoint] = nums[secondPoint];
          secondPoint++;
        }
      }
      return fisrtPoint + 1;
    }
}
