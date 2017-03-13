package leetcode;

public class _005_LongestPalindromicSubstring {
	public static void main(String[] args) {
		String s = "abcdzzzdcab_abcdzdcab_abcdzzdcab"; //, return "cdzdc".
		String ret = "";
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			ret = longestPalindromicSubstring(s);
		}
		System.out.println(ret);
		System.out.println(System.currentTimeMillis() - start);
		//----------------------------------------------------
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
		    ret = leetcodeSolution(s);
		}
		System.out.println(ret);
		System.out.println(System.currentTimeMillis() - start);
	}
	
	
	public static String longestPalindromicSubstring(String s) {
		int maxLength = 0;
	    int startIdx = 0;
 
		// 位置i开始，位置k结束的字符串是否为回文
		for (int i = 0; i < s.length(); i++) {
			// 这里k = i+maxLength 表示i，k之间字符串长度至少要>maxLength才有必要考虑是否为回文
			for (int k = i+maxLength; k < s.length(); k++) { 
				if (isPalindromicByLoop(s, i, k)) {
					//maxSubString = s.substring(i, k+1);
					startIdx = i;
					maxLength = k-i+1;
				} 
			}
		}
		return s.substring(startIdx, maxLength+startIdx);
	}
	
	// 循环方式判断是否回文
	public static boolean isPalindromicByLoop(String s, int startIdx, int endIdx) {
//		if (s.length() <= 1) return true;
//		int startIdx = 0;
//		int endIdx = s.length()-1;
		// 首尾比较，逐步向中心靠近
		while (endIdx - startIdx > 0 ) {
			if (s.charAt(startIdx) != s.charAt(endIdx)) {
				return false;
			}
			startIdx++;
			endIdx--;
		}
		return true;
	}
	
	//----------------------------------------------------
	// leetcode 上的最佳答案。任意以（i）或 （i，i+1）为中心的字符串是否为回文     
	// https://discuss.leetcode.com/topic/23498/very-simple-clean-java-solution
	//----------------------------------------------------
	public static int beginIdx = 0;
	public static int maxLength = 0;
	public static String leetcodeSolution(String s) {
		// 为了本方法能被多次调用，在这里再次初始化=0
		beginIdx = 0;
		maxLength = 0;
		
		int len = s.length();
		// 边界case
		if (len < 2)
			return s;
		
		for (int i = 0; i < s.length()-1; i++) {
			isPalindromicByGivenMiddlePoint(s, i, i+1); // 偶数个字符
			isPalindromicByGivenMiddlePoint(s, i, i); // 奇数个字符
		}
		return s.substring(beginIdx, beginIdx + maxLength);
	}
	
	// 由中心向两边扩展
	public static void isPalindromicByGivenMiddlePoint(String s, int left, int right) {
		while (left>=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		if ( maxLength < right - left - 1 ) {
			maxLength = right - left - 1;
			beginIdx = left + 1;
		}
	}
	
}
