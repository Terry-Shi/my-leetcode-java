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
	
	
	
}
