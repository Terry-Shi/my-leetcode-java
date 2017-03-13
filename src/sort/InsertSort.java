package sort;

public class InsertSort {
	public static void main(String[] args) {
		
	}
	
	public void insertSort(int[] nums) {
		// 和理牌的过程类似
		// 认为左侧都是理好的牌 从i开始是未理的牌。 将i与之前的牌比较，如小于则交换。
		for (int i = 1; i < nums.length; i++) {
			for (int j = i; j > 0; j--) {
				if (nums[j] < nums[j-1]) {
					// swap
				} else {
					break;
				}
			}
		}
	}
}
