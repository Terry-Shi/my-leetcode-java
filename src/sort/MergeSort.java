package sort;

// 归并排序
public class MergeSort {
	public static void main(String[] args) {
		
	}
	
	// 把数组分成左右两份，分别排序，再合并
	// 拆分成两份的过程是递归调用，直到每份仅剩一个元素
	public void sort(int[] nums, int left, int right) {
		
		while (left < right) {
			int midIdx = (right + left) / 2;
			
			sort(nums, left, midIdx);
			sort(nums, midIdx+1, right);
			merge(nums, left, midIdx, right);
		}
		
	}
	// 合并左右两个已经排序的部分
	public void merge(int[] nums, int left, int midIdx, int right) {
		int[] temp = new int[nums.length];
		int copyStartIdx = left;
		// 左侧已排序部分的边界是 [left，midIdx]
		// 右侧已排序部分的边界是 [midIdx+1, right]
		int rightIdx = midIdx + 1;
		
		int i = 0;
		while (left <= midIdx && rightIdx <= right) {
			if (nums[left] < nums[rightIdx]) {
				temp[i++] = nums[left++];
			} else {
				temp[i++] = nums[rightIdx++];
			}
		}
		
		while (left<=midIdx){
			temp[i++] = nums[left++];
		}
		while (rightIdx<=right){
			temp[i++] = nums[rightIdx++];
		}
		// 把temp的内容copy回nums
		for (int j = 0; j < right-copyStartIdx+1; j++) {
			nums[copyStartIdx + j] = temp[j];
		}
	}
}
