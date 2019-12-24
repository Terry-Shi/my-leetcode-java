package leetcode;

import java.util.EmptyStackException;
import java.util.Stack;

public class _020_ValidParentheses {
  public static void main(String[] args) {
    // true cases
    System.out.println(isValidParentheses2("()[]{}") == true);
    System.out.println(isValidParentheses2("([]{})") == true);
    System.out.println(isValidParentheses2("([]){}") == true);


    // false cases
    System.out.println(isValidParentheses2("([]{}(") == false);
    System.out.println(isValidParentheses2("(") == false);
  }

  public static boolean isValidParentheses(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }

    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      Character currChar = s.charAt(i);
      if (currChar == '(' || currChar == '[' || currChar == '{') {
        stack.push(currChar);
      } else if (currChar == ')' || currChar == ']' || currChar == '}') {
        if (stack.isEmpty()) {
          return false;
        }
        Character charInStack = stack.pop();
        if (charInStack == '(' && currChar != ')') {
          return false;
        }
        if (charInStack == '[' && currChar != ']') {
          return false;
        }
        if (charInStack == '{' && currChar != '}') {
          return false;
        }
      }
    }
    return stack.isEmpty();
  }


  public static boolean isValidParentheses2(String s) {
    if (s == null || s.isEmpty()) {
      return true;
    }

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      Character ch = s.charAt(i);
      Character peekChar = stack.isEmpty() ? null : stack.peek();

      if (ch.equals('(') || ch.equals('{') || ch.equals('[')) {
        stack.push(ch);
      } else if (ch.equals(')')) {

        if (peekChar != null && peekChar.equals('(')) {
          stack.pop();
        } else {
          stack.push(ch);
        }

      } else if (ch.equals('}')) {
        if (peekChar != null && peekChar.equals('{')) {
          stack.pop();
        } else {
          stack.push(ch);
        }
      } else if (ch.equals(']')) {
        if (peekChar != null && peekChar.equals('[')) {
          stack.pop();
        } else {
          stack.push(ch);
        }
      } else {
        return false;
      }
    }

    return stack.isEmpty();
  }

}
