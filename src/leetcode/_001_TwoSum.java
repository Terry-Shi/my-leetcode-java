/**
 * 
 */
package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
题目描述

Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2 (注意这里认为下标从1开始)
 */
/**
 * @author terry
 *
 */
public class _001_TwoSum {

	public static void main(String[] args) {
		int[] nums = new int[]{ 1, 2, 7, 8, 9, 22, 33};
		
		int[] ret1 = twoSum1(nums, 15);
		System.out.println(ret1[0] + " and " + ret1[1]);
		
		int[] ret2 = twoSum2(nums, 15);
		System.out.println(ret2[0] + " and " + ret2[1]);
	}
	
	// 双层循环 O(n*n)
	public static int[] twoSum1(int[] nums, int target) {
		int[] ret = new int[]{-1,-1};
		if (nums==null || nums.length <= 1) {
			return ret;
		}
		// 判断char[i] 和它之后的元素相加是否=target
		for (int i = 0; i< nums.length-1; i++) {
			for (int k = i+1; k< nums.length; k++) {
				 if (nums[i] + nums[k] == target) {
					 ret[0] = i+1; // 注意题目要求下标从1开始
					 ret[1] = k+1; 
					 return ret;
				 }
			}
		}
		return ret;
	}
	
	// 单层循环+map记录前面遍历到的数据  O(n)
	// 空间换时间
	public static int[] twoSum2(int[] nums, int target) {
		int[] ret = new int[]{-1,-1};
		if (nums==null || nums.length <= 1) {
			return ret;
		}
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i< nums.length; i++) {
			if ( map.containsKey(target - nums[i]) ) {
				ret[0] = map.get(target - nums[i]) + 1; // 注意题目要求下标从1开始
				ret[1] = i+1;
				return ret;
			}
			map.put(nums[i], i);
		}
		return ret;
	}
}
