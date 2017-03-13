package leetcode;

import java.util.HashMap;

/********************************************************************************** 
* 最长的不重复的子字符串的长度
* Given a string, find the length of the longest substring without repeating characters. 
* For example, the longest substring without repeating letters for "abcabcbb" is "abc", 
* which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
*               
**********************************************************************************/
public class _003_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		String input = "aabcddedghijkdd";//mnopqrstuvwxyz
		int ret = solution1(input);
		System.out.println("Length of Longest Substring = " + ret);
		
		ret = solution2(input);
		System.out.println("Length of Longest Substring = " + ret);
	}

	public static int solution1(String s) {
		int maxLen = 0;
		for (int i = 0; i < s.length(); i++) {
			 // i 开始的最长不重复子字符串
			for (int j = i; j < s.length(); j++) {
//				// 判断index在i到j之间的字符串是否有重复
//				if 不重复
//				    maxLen=Math.max(maxLen, j-1+1)
//				else
//					break
			}
		}
		return maxLen;
	}
	
	// leetcode 官网上的答案
	// https://discuss.leetcode.com/topic/8232/11-line-simple-java-solution-o-n-with-explanation
	// map说明：key=字符，value=字符到目前为止最后一次出现的index
	public static int solution2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                // "j" is used to indicate the index of first character of this substring. 
            	    // If the repeated character's index is less than j itself, 
            	    // which means the repeated character in the hash map is no longer available this time
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-j+1);
        }
        //System.out.println(map);
        return max;
    }
	
}
