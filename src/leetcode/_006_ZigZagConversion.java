package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _006_ZigZagConversion {

	public static void main(String[] args) {
        // convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
		String s = "PAYPALISHIRING";

		System.out.println(zigZagConversion(s, 3)); // 错误
	    System.out.println(zigZagConversion2(s, 3)); // 正确
		System.out.println(zLine(s, 3)); // 正确
	}

	// 审题错误：此方案适合行列转换 (offset 等需要相应调整)
	// 1 4 7
	// 2 5 8
	// 3 6 9
	// ->
	// 1 2 3
	// 4 5 6
	// 7 8 9
	public static String zigZagConversion(String s, int row) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < row; i++) {
			str.append(s.charAt(i));
			int offset = 1;
			while (i + offset * (row + 1) < s.length()) {
				str.append(s.charAt(i + offset * (row + 1)));
				offset++;
			}
		}
		return str.toString();
	}

	public static String zigZagConversion2(String s, int row) {
		List<String> rowList = new ArrayList<String>(row);
		for (int i = 0; i < row; i++) {
		  rowList.add("");
        }

		int rowIdx = 0;
		int step = 0;
		for (int i = 0; i < s.length(); i++) {
			if (rowIdx == 0) step = 1;
			if (rowIdx == row-1) step = -1;
			rowList.set(rowIdx, rowList.get(rowIdx) + s.charAt(i));
			rowIdx = rowIdx + step;
		}

		StringBuilder str = new StringBuilder();
		for (String string : rowList) {
			str.append(string);
		}
		return str.toString();
	}

	public static String zLine(String str, int rows) {

	  // 边缘case
	  if (rows == 1) return str;

	  StringBuilder[] strBuilder = new StringBuilder[rows];
	  for (int i = 0; i < strBuilder.length; i++) {
	    strBuilder[i] = new StringBuilder();
      }

	  int idx = 0;
	  int change = 1; // 1 or -1. if idx = rows-1 ---> change=-1; if idx = 0 ---> change = 1
	  for (int i = 0; i < str.length(); i++) {
	    strBuilder[idx].append(str.charAt(i));
	    if (idx == 0) {
	      change = 1;
	    } else if (idx == rows -1) {
	      change = -1;
	    }
	    idx = idx + change; // next index
	  }
	  StringBuilder ret = new StringBuilder();
	  for (int i = 0; i < strBuilder.length; i++) {
	    ret.append( strBuilder[i] );
      }
	  return ret.toString();
	}
}
