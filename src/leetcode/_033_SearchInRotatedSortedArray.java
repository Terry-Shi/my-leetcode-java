package leetcode;

/**********************************************************************************
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 **********************************************************************************/
public class _033_SearchInRotatedSortedArray {
	public static void main(String[] args) {
		int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		int startIdx = 0;
		int endIdx = nums.length - 1;
		int ret = search(nums, startIdx, endIdx, 6);
		System.out.println(ret);
	}

	public static int search(int[] nums, int startIdx, int endIdx, int target) {
		int midIdx = 0;
		while (startIdx + 1 < endIdx) { // 这个边界条件怎么得到的？
			midIdx = startIdx + (endIdx - startIdx) / 2;
			if (nums[midIdx] >= nums[endIdx]) { // 转折点在右半边
				if (target <= nums[midIdx] && target >= nums[startIdx]) {
					// 目标在左半边,已经是完全从小到大的排列
					endIdx = midIdx;
				} else {
					startIdx = midIdx;
				}
			} else if (nums[midIdx] < nums[endIdx]) { // 转折点在左半边
				if (target >= nums[midIdx] && target <= nums[endIdx]) {
					// 目标在右半边,已经是完全从小到大的排列
					startIdx = midIdx;
				} else {
					endIdx = midIdx;
				}
			}
		}

		if (nums[midIdx] == target) {
			return midIdx;
		}
		if (nums[startIdx] == target) {
			return startIdx;
		}
		if (nums[endIdx] == target) {
			return endIdx;
		}
		return -1;
	}
}
