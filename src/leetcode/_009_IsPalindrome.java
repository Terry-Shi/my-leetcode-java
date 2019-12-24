package leetcode;

public class _009_IsPalindrome {

  public static void main(String[] args) {
    System.out.println("9 " + isPalindrome2(9));
    System.out.println("99 " + isPalindrome2(99));
    System.out.println("121 " + isPalindrome2(121));
    System.out.println("919 " + isPalindrome2(919));
    System.out.println("123321 " + isPalindrome2(123321));
    System.out.println("1233321 " + isPalindrome2(1233321));
    System.out.println("1233421 " + isPalindrome2(1233421));
    System.out.println("100 " + isPalindrome2(100));
  }

  // 方案1:转换为字符串


  // 方案2:不转换字符串, 直接比较数字的首尾，并逐渐向中心点靠近
  public static boolean isPalindrome1(int x) {
    if (x < 0) {
      return false;
    }

    // x % 10 = 最后一位
    // x / div = 第一位？  怎么快速判断一共是几位数？
    int div = 1;
    while (x / div >= 10) div *= 10;

    while ( x >= 10 ) {
      if ((x / div) != (x % 10)) { // 首尾数字是否相同
        return false;
      }
      x = x / 10 - x / div * div / 10; // 去头，去尾
      div = div / 100; // 去掉两位
    }
    return true;
  }

  // 方案3: 反转数字，如果和原数字相同则是回文
  public static boolean isPalindrome2(int x) {
    if (x < 0) {
      return false;
    }
    int originNum = x;
    int reversedNum = 0;
    while ( x > 0 ) {
      reversedNum = reversedNum * 10 + x % 10;
      x = x / 10;
    }
    return reversedNum == originNum;
  }

}
