package leetcode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static leetcode.ListNodeHelper.*;

public class _019_RemoveNthFromEnd {

  

  public static void main(String[] args) throws IOException {
    ListNode head = stringToListNode("1,2,3,4,5,6,7");
    ListNode ret = new _019_RemoveNthFromEnd().removeNthFromEnd3(head, 2);
    String out = listNodeToString(ret);
    System.out.print(out);
  }

  public static ListNode removeNthFromEnd1(ListNode head, int n) {
    ListNode originalHead = head;
    // 记录序号和引用
    Map<Integer, ListNode> idxMap = new HashMap<>();
    int idx = 0;
    while (head.next != null) {
      head = head.next;
      idx++;
      idxMap.put(idx, head);
    }
    idxMap.get(idxMap.size() - n).next = idxMap.get(idxMap.size() - n).next.next;
    return originalHead;
  }

  // 优化：只需要记录最近遍历到的最多n+1个元素。用什么数据结构记录？ 数组？
  public static ListNode removeNthFromEnd2(ListNode head, int n) {
    ListNode originalHead = head;
    ListNode[] lastN = new ListNode[n + 1];
    int currentIdx = 0;
    while (head.next != null) {
      head = head.next;
      lastN[currentIdx] = head;

      if (currentIdx == lastN.length - 1) {
        currentIdx = 0;
      } else {
        currentIdx++;
      }
    }
    ListNode beforeNth = lastN[currentIdx];
    if (beforeNth != null) {
      beforeNth.next = beforeNth.next.next;
    }
    return originalHead;
  }

  // 优化：只记录延迟n+1步的节点引用。类似双指针
  public static ListNode removeNthFromEnd3(ListNode head, int n) {
    ListNode x = null, currentNode = head;
    int step = 0;
    while (currentNode.next != null) {
      currentNode = currentNode.next;
      step++;
      if (step == n) {
        x = head;
      } else if (step > n) {
        x = x.next;
      }
    }
    if (x != null && x.next != null) {  
      x.next = x.next.next;
    }
    return head;
  }
}
