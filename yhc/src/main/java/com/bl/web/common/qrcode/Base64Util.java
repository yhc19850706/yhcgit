package com.bl.web.common.qrcode;
import com.google.common.base.Strings;

import sun.misc.BASE64Decoder;

public class Base64Util {
	
	/**
	 *  base64编码的文本转为图片
	 * @param imgStr
	 * @return
	 */
	public static byte[] base64StringToImage(String imgStr) {
		try {
			if(!Strings.isNullOrEmpty(imgStr)) {
				BASE64Decoder decoder = new BASE64Decoder();
				// Base64解码
				byte[] b = decoder.decodeBuffer(imgStr);
				for (int i = 0; i < b.length; ++i) {
					if (b[i] < 0) {// 调整异常数据
						b[i] += 256;
					}
				}
				return b;
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

}
