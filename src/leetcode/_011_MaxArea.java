package leetcode;

public class _011_MaxArea {

  public static void main(String[] args) {
    int[] height = new int[] { 1,8,6,2,5,4,8,3,7};
    System.out.println(maxArea(height) == 49);

    System.out.println(maxArea2(height) == 49);

  }

  
  public static int maxArea(int[] height) {
    int ret = 0;
    int tempArea = 0; // min(height[start], height[end]) * (end - start)
    for (int start = 0; start < height.length; start++)
      for (int end=start+1; end< height.length; end++ ) {
        tempArea = Math.min(height[start], height[end]) * (end - start);
        ret = Math.max(ret, tempArea);
      }

    return ret;
  }

  // 双指针
  public static int maxArea2(int[] height) {
    int start = 0, end = height.length-1;
    int ret = Math.min(height[start], height[end]) * (end - start);

    while (start < end) {
      if (height[start] < height[end]) {
        start ++;
      } else {
        end --;
      }
      ret = Math.max(ret, Math.min(height[start], height[end]) * (end - start));
    }
    return ret;
  }
}
