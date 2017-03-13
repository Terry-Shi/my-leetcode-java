package leetcode;

import java.util.Arrays;

public class _027_RemoveElement {
	public static void main(String[] args) {
		int[] array = new int[]{1,1,2,2,3,4,5,6,6};
		int idx = solution(array , 2);
		
		System.out.println(idx);
		System.out.println(Arrays.toString(array));
	}

	public static int solution(int[] array, int target) {
		int idx = 0;
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] != target) {
				array[idx] = array[i];
				idx++;
			} 
		}
		return idx-1;
	}

}
