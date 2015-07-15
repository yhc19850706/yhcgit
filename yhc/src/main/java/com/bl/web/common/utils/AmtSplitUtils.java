package com.bl.web.common.utils;

import java.math.BigDecimal;
import java.util.List;

public class AmtSplitUtils {

	public static String[] getAmtSplitString(BigDecimal orginAmt) {
		String[] sb = new String[10];
		for (int i = 0; i < sb.length; i++) {
			sb[i] = "";
		}
		String original = orginAmt.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
		        // 整数部分
				String integerPart = "";
				// 小数部分
				String floatPart = "";
				
				if (original.contains(".")) {
					// 如果包含小数点
					int dotIndex = original.indexOf(".");
					integerPart = original.substring(0, dotIndex);
					floatPart = original.substring(dotIndex + 1);
				} else {
					// 不包含小数点
					integerPart = original;
				}
				int integerLength = integerPart.length();
				int floatPartLength = 2;
				
				// 整数部分处理
				for (int i = 0; i < integerPart.length(); i++) {
					char part = integerPart.charAt(i);
					sb[10-(integerLength+floatPartLength)+i] = String.valueOf(part);
				}
				
				for (int i = 0; i < floatPartLength; i++) {
					char part = floatPart.charAt(i);
					sb[10-floatPartLength+i] = String.valueOf(part);
				}
				return sb;
	}
	
	public static void main(String[] args) {
		BigDecimal bi = new BigDecimal(12587.1);
		String[] sb = getAmtSplitString(bi);
		for (int i = 0; i < sb.length; i++) {
			System.out.print(sb[i]);
		}
	}
	
	public static List<String> getAmtSplitList(BigDecimal orginAmt) {
		String[] sb = getAmtSplitString(orginAmt);
		List<String> list = java.util.Arrays.asList(sb);
		return list;
	}
}

