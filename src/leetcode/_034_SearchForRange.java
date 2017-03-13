package leetcode;

import java.util.Arrays;

public class _034_SearchForRange {
	public static void main(String[] args) {
		int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] ret = searchForRange2(nums, 8);
        for (int i = 0; i < ret.length; i++) {
			System.out.println(ret[i]);
		}
	}

	// 非递归
	public static int[] searchForRange1(int[] nums, int target) {
		int[] ret = new int[]{-1, -1};
		// 边界case
		if (nums == null || nums.length == 0) {
			return ret;
		}
		
		int begin = 0;
		int end = nums.length -1;
		
		while (begin <= end) {
			int midIdx = (end - begin + 1) / 2;
			if (nums[midIdx] > target) {
				end = midIdx - 1;
			} else if (nums[midIdx] < target) {
				begin = midIdx + 1;
			} else {
				 // nums[idx] == target
				 begin = midIdx;
				 end = midIdx;
				 while (begin >=0 && nums[begin] == target) {
					 begin--;
				 }
				 while (end < nums.length && nums[end] == target) {
					 end++;
				 }
				 ret[0] = begin+1;
				 ret[1] = end-1;
				 return ret;
			}
		}
		return ret;
	}
	
	// 递归
	public static int[] searchForRange2(int[] nums, int target) {
		 int[] ret = new int[2];
		 int idx = nums.length / 2;
		 
		 if (nums[idx] > target) {
			 return searchForRange2(Arrays.copyOfRange(nums, 0, idx+1), target);
		 } else if (nums[idx] < target) {
			 return searchForRange2(Arrays.copyOfRange(nums, idx, nums.length), target);
		 } else {
			 // nums[idx] == target
			 int begin = idx;
			 int end = idx;
			 while (begin >=0 && nums[begin] == target) {
				 begin--;
			 }
			 while (end < nums.length && nums[end] == target) {
				 end++;
			 }
			 ret[0] = begin+1;
			 ret[1] = end-1;
			 return ret;
		 }
		 
	}
}
