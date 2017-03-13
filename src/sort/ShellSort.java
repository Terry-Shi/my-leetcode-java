package sort;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static void shellSort(int[] nums) {
		 
		int gap = nums.length / 2 ;
		
		// gap = 1 是最后一次循环
		while (gap > 0) {
			for (int i = gap; i<nums.length; i++) {
				for (int j = i; j>0; j-=gap) {
					if (nums[j] < nums[j-gap]) {
						//swap[j, j-gap]
					} else {
						break;
					}
				}
			}
			gap = gap / 2;
		}
		
	}

}
