package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class _030_SubstringWithConcatenationOfAllWords {
	public static void main(String[] args) {
		String s = "barfoothefoobarman";
	    List<String> l = new ArrayList<String>();
	    l.add("foo");
	    l.add("bar");
	    
	    System.out.println(substringWithConcatenationOfAllWords(s, l));
	}
	
	public static List<Integer> substringWithConcatenationOfAllWords(String s, List<String> words) {
		List<Integer> ret = new ArrayList<Integer>();
		// 处理边界情况
		if (words.size() == 0) {
		    return ret;
		}
		
		int wordLen = words.get(0).length();

		for (int i = 0; i< s.length() - wordLen*words.size()+1; i++) {
			if (isSubstringWithConcatenation(s.substring(i, i+wordLen*words.size()), words, wordLen)) {
				ret.add(i);
			}
		}
		return ret;
	}
	
	// 判断方法1: 用list.containsAll()
	// 效率不佳
	public static boolean isSubstringWithConcatenation(String s, List<String> words, int wordLen) {
		List<String> strList = new ArrayList<>();
		for (int i=0; i<s.length(); i=i+wordLen ) {
		    strList.add(s.substring(i, i+wordLen));
		}
		
		if (strList.containsAll(words) && words.containsAll(strList)) {
			return true;
		} else {
			return false;
		}
	}
	
	// 判断方法2每次生成一个map，word作为Key，截取规定长度的字符，看map的是否containsKey
	public static boolean isSubstringWithConcatenation(String s, Map<String, Integer> words, int wordLen) {
		for (int i=0; i<s.length(); i=i+wordLen ) {
		    String word = s.substring(i, i+wordLen);
		    if (words.containsKey(word)) {
				words.remove(word);
			} else {
				return false;
			}
		}
		return true;
	}
	
}
