package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _006_ZigZagConversion {
	
	public static void main(String[] args) {
        // convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
		String s = "PAYPALISHIRING";
		
		System.out.println(zigZagConversion(s, 3));
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
}
