package leetcode;

import java.util.Arrays;
import java.util.List;

// 按一定顺序／要求穷举
// 详细介绍 http://harrifeng.github.io/algo/leetcode/next-permutation.html
public class _031_NextPermutation {

	public static void main(String[] args) {
		int[] num = new int[]{1,1,5};
		nextPermutation(num);
		List ret = Arrays.asList(num[0], num[1], num[2]);
		System.out.println(ret);

		num = new int[]{3,2,1};
		nextPermutation(num);
		ret = Arrays.asList(num[0], num[1], num[2]);
		System.out.println(ret);
	}
	
	public static void nextPermutation(int[] num) {
		// edge case
		if (num.length <= 1) {
            return;
        }
		// 从后向前遍历 i=[n-1, 0)
		//     如果相邻的两个数字，后面的数字大于前面的数字 num[i] > num[i-1] 
		//         num[i-1] 和从最后开始 n-1 到 i 的数字中第一个大于它数字swap
		//         [k <-> n-1] 从小到大排序
		for (int i = num.length-1; i > 0; i--) {
			if (num[i] > num[i-1]) {
				for (int k = num.length-1; k>=i; k--) {
					if (num[k] > num[i-1]) {
						int temp = num[k];
						num[k] = num[i-1];   
						num[i-1] = temp;
						//
						Arrays.sort(num, i, num.length);
						return;
					}
				}
			}
		}
		
		// 注意特殊case
		// 所有数字已经从大到小排列 -> 
		//  从小到大排序
		Arrays.sort(num, 0, num.length);
		// or 逆序
	}
}
