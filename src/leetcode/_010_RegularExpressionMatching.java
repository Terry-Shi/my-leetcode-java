package leetcode;

/**********************************************************************************
*
* Implement regular expression matching with support for '.' and '*'.
*
* '.' Matches any single character.
* '*' Matches zero or more of the preceding element.
*
* The matching should cover the entire input string (not partial).
*
* The function prototype should be:
* bool isMatch(const char *s, const char *p)
*
* Some examples:
* isMatch("aa","a") → false
* isMatch("aa","aa") → true
* isMatch("aaa","aa") → false
* isMatch("aa", "a*") → true
* isMatch("aa", ".*") → true
* isMatch("ab", ".*") → true
* isMatch("aab", "c*a*b") → true
*
*
**********************************************************************************/
// 参考
public class _010_RegularExpressionMatching {
	public static void main(String[] args) {
		System.out.println(isMatch("aa", "a") == false);
		System.out.println(isMatch("aa", "aa") == true);
		System.out.println(isMatch("aaa", "aa") == false);
		System.out.println(isMatch("aa", "a*") == true);
		System.out.println(isMatch("aa", ".*") == true);
		System.out.println(isMatch("ab", ".*") == true);
		System.out.println(isMatch("aab", "c*a*b") == true);


		System.out.println(isMatch2("aaa", "a*a") == true);
		System.out.println(isMatch2("aaa", "a*b") == false);

	}

	public static boolean isMatch2(String s, String pattern) {
		// pattern.length == 0
		if (pattern.length() == 0) {
			return s.length() == 0;
		}

		// pattern.length == 1
		if (pattern.length() == 1) {
			if (pattern.charAt(0) == '.') {
				return isMatch2(s.substring(1), pattern.substring(1));
			} else {
				if (pattern.charAt(0) == s.charAt(0)) {
					return isMatch2(s.substring(1), pattern.substring(1));
				} else {
					return false;
				}
			}
		} else { // pattern.length() >= 2 // FIXME: 逻辑错误
			// when the second char of p is '*'
			if (pattern.charAt(1) == '*') {
				if (s.length() == 0) {
					return true;
				}
				if (pattern.charAt(0) == s.charAt(0) || pattern.charAt(0) == '.') {
					return isMatch2(s.substring(1, s.length()), pattern);
				} else {
					return isMatch2(s, pattern.substring(2));
				}
			} else {
				if (pattern.charAt(0) == '.') {
					return isMatch2(s.substring(1), pattern.substring(1));
				} else {
					if (pattern.charAt(0) == s.charAt(0)) {
						return isMatch2(s.substring(1), pattern.substring(1));
					} else {
						return false;
					}
				}
			}
		}
	}

	public static boolean isMatch(String s, String p) {
		// base case
		if (p.length() == 0) {
			return s.length() == 0;
		}

		// special case
		if (p.length() == 1) {

			// if the length of s is 0, return false
			if (s.length() < 1) {
				return false;
			}

			//if the first does not match, return false
			else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			}

			// otherwise, compare the rest of the string of s and p.
			else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}

		// case 1: when the second char of p is not '*'
		if (p.charAt(1) != '*') {
			if (s.length() < 1) {
				return false;
			}
			if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}

		// case 2: when the second char of p is '*', complex case.
		else {
			//case 2.1: a char & '*' can stand for 0 element
			if (isMatch(s, p.substring(2))) {
				return true;
			}

			//case 2.2: a char & '*' can stand for 1 or more preceding element,
			//so try every sub string
			int i = 0;
			while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}

	public static boolean isMatch3(String text, String pattern) {
      if (pattern.isEmpty()) return text.isEmpty();

      boolean first_match = (!text.isEmpty() &&
                             (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

      if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
          return (isMatch3(text, pattern.substring(2)) ||
                  (first_match && isMatch3(text.substring(1), pattern)));
      } else {
          return first_match && isMatch3(text.substring(1), pattern.substring(1));
      }
  }

}
