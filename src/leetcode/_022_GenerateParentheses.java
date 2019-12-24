package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
( -> (( -> (((
               -> ((()
                       -> ((())
                                -> ((()))
        -> (() -> (()(
                       -> (()()
                                -> (()())
               -> (()) -> (())(
                                -> (())()
     () -> ()( -> ()((
                       -> ()(()
                                -> ()(())
               -> ()() -> ()()(
                                -> ()()()


 */
public class _022_GenerateParentheses {
	public static void main(String[] args) {
		List<String> ret = new ArrayList<String>();
		generateParentheses(ret, "", 3,3);
		for (String string : ret) {
			System.out.println(string);
		}

		System.out.println(generateParenthesis(3));
	}

	/**
	 * 递归原理：每次可能的选择有连个，适用树型结构逐层向下扩展的过程，当到了"("")"都已经用尽时的字符串即为所求
	 *         任意时刻 ")"的数量 <= "(" 的数量
	 * @param ret
	 * @param left how many "(" remains
	 * @param right how many ")" remains
	 * @return
	 */
	public static void generateParentheses(List<String> ret, String currStr, int left, int right){
		if (left == 0 && right == 0) {
			ret.add(currStr);
			return;
		}
		if (left > 0) {
			generateParentheses(ret, currStr + "(", left-1, right);
		}

		if (right > 0 && right > left) {
			generateParentheses(ret, currStr + ")", left, right-1);
		}
	}

	 public static List<String> generateParenthesis(int n) {
	   List<String> ret = new ArrayList<>();
	   subGenerateParenthesis(ret, "", 0,0,n);
	    return ret;
	 }

	 /**
	  *
	  * @param ret 返回List
	  * @param currStr 目前拼成的字符串
	  * @param left 已经拼入多少个左括号
	  * @param right 已经拼入多少个右括号
	  * @param n 总共几对括号
	  */
	 public static void subGenerateParenthesis(List<String> ret, String currStr, int left, int right, int n) {
	   if (left == n && right == n) {
	     ret.add(currStr);
	     return;
	   }
	   if (left < n) {
	     subGenerateParenthesis(ret, currStr + "(", left+1, right, n);
	   }
	   if (right < n && right < left) {
	     subGenerateParenthesis(ret, currStr + ")", left, right+1, n);
	   }
	 }
}
