package leetcode;

public class _028_ImplementStrstr {
	public static void main(String[] args) {

	}

	public static int solution(String haystack, String needle) {
		int j = 0;
		for (int i = 0; i < haystack.length() - needle.length() +1; i++) {
			for (j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i+j) != needle.charAt(j)) {
					break;
				}
			}
			if (j == needle.length() -1) {
				return i;
			}
		}
		return -1;
		
	}
}
