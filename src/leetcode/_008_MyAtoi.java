package leetcode;

public class _008_MyAtoi {

  public static void main(String[] args) {

  }

  public static int myAtoi(String str) {
    int ret = 0;
    if(str==null || str.length()==0)
      return 0;
    ret = Integer.valueOf(str);
    return ret;
  }
}
