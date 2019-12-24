package leetcode;

public class _007_ReverseInt {

  public static void main(String[] args) {
    System.out.println("MAX_VALUE = " + Integer.MAX_VALUE + "");
    System.out.println("MIN_VALUE = " + Integer.MIN_VALUE + "");

    int testNum1 = 0;
    System.out.println(reverse1(testNum1));
    System.out.println(reverse2(testNum1));
  }

  /**
   * 转换为字符串处理
   * @param x
   * @return
   */
  public static int reverse1(int x) {
    String strX = String.valueOf(x);
    StringBuilder strB = new StringBuilder();
    String minus = "";
    if (x < 0) {
      minus = "-";
    }
    // 反序拼接字符串，不包括负号
    for (int i = strX.length() - 1; i >= 0; i--) {
      if (strX.charAt(i) != '-') {
        strB.append(strX.charAt(i));
      }
    }
    String strNum = strB.toString();
    strNum = minus + strNum; // 加上符号（如果>0 + ""; 如果<0 + "-"）

    // 判断是否溢出
    if (x > 0 && strNum.length() == String.valueOf(Integer.MAX_VALUE).length() && strNum.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0) {
      return 0;
    } else if ( x < 0 && strNum.length() == String.valueOf(Integer.MIN_VALUE).length() && strNum.compareTo( String.valueOf(Integer.MIN_VALUE)) > 0){
      return 0;
    }
    int ret = Integer.valueOf(strNum);
    return ret;
  }

  /**
   * 不使用字符串转换
   * @param x
   * @return
   */
  public static int reverse2(int x) {
    int ret = 0;
    while (x != 0) {
      int pop = x % 10; // 取余数
      // 需要判断溢出
      if (Math.abs(x) < 10) { // 还剩最后一位数
        // 只有在此情况才需要判断是否溢出
        if (ret > Integer.MAX_VALUE / 10) {
          return 0;
        } else if (ret == Integer.MAX_VALUE / 10 &&  pop > Integer.MAX_VALUE % 10) {
          return 0;
        }

        if (ret < Integer.MIN_VALUE / 10) {
          return 0;
        } else if (ret == Integer.MIN_VALUE / 10 && pop <  Integer.MIN_VALUE % 10) {
          return 0;
        }
      }
      // 确保不溢出后累加
      ret = ret * 10 + pop;
      x = x / 10;
    }
    return ret;
  }

}
