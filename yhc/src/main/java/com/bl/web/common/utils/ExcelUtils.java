package com.bl.web.common.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.extractor.ExcelExtractor;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelUtils {
	
	public static List<Map<String, Object>> read(MultipartFile form, String[] title) throws IOException {
		
        String fileName = form.getOriginalFilename().trim(); // 文件名  
        String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
		if ("xls".equals(extension)) {
			return read2003Excel(fileName, form.getInputStream(), title);
		} else if ("xlsx".equals(extension)) {
			return read2007Excel(fileName, form.getInputStream(), title);
		} else {
			throw new IOException("不支持的文件类型");
		}
	}
	
	public static List<Map<String, Object>> read(String excel, String[] title) throws IOException {
		File file = new File(excel);
		if (!file.exists() || !file.isFile() || !file.canRead()) {
			throw new IOException(excel);
		}
		String fileName = file.getName();
		String extension = fileName.lastIndexOf(".") == -1 ? "" : fileName.substring(fileName.lastIndexOf(".") + 1);
		if ("xls".equals(extension)) {
			return read2003Excel(fileName, null, title);
		} else if ("xlsx".equals(extension)) {
			return read2007Excel(fileName, null, title);
		} else {
			throw new IOException("不支持的文件类型");
		}
	}
	
	
	public static List<Map<String, Object>> read(String excel) throws IOException {
		return read(excel, null);
	}
	
	private static List<Map<String, Object>> read2003Excel(String fileName, InputStream is, String[] title) throws IOException {
		
		// Workbook
		HSSFWorkbook wb = null;
		
		if (is == null) {
			File file = new File(fileName);
			wb = new HSSFWorkbook(new FileInputStream(file));
		} else { 
			wb = new HSSFWorkbook(is);
		}
		// Text Extraction
		ExcelExtractor extractor = new ExcelExtractor(wb);
		extractor.setFormulasNotResults(true);
		extractor.setIncludeSheetNames(false);

		Map<String, Object> paramMap = null;
		List<Map<String, Object>> rowList = null;
		// Getting cell contents
//		for (int sheetNum = 0; sheetNum < wb.getNumberOfSheets(); sheetNum++) {
		int sheetNum = 0;
		HSSFSheet sheet = wb.getSheetAt(sheetNum);
		if (sheet != null) {
			int rows = sheet.getPhysicalNumberOfRows(); // 获得行数
			if (rows > 1) {
				
				int cells = title.length;// 获得列数
				boolean bool = false;
				for (int cellNum = 0; cellNum < cells; cellNum++) { 
					HSSFCell cell = sheet.getRow(0).getCell(cellNum);
					if (cell != null && StringUtils.isNotBlank(cell.getStringCellValue()) && title[cellNum].equals(cell.getStringCellValue())) {
						bool = true;
					} else {
						bool = false;
					}
				}
				
				if (bool) {
					throw new IOException("导入的 Excel 模板错误！");
				} 
				
				rowList = new ArrayList<Map<String, Object>>();
				sheet.getMargin(Sheet.TopMargin);
				for (int rowNum = 1; rowNum < rows; rowNum++) {
					HSSFRow row = sheet.getRow(rowNum);
					if (row != null) {
						paramMap = new HashMap<String, Object>();
						
						int nullCol = 0;
						
						for (int cellNum = 0; cellNum < title.length; cellNum++) { // 列循环

							HSSFCell cell = row.getCell(cellNum);
							
							if (cell != null) {
								if (StringUtils.isNotBlank(cell.getStringCellValue())) {
									paramMap.put(title[cellNum]+"", StringUtils.trim(cell.getStringCellValue()));
								} else {
									paramMap.put(title[cellNum]+"", null);
									nullCol++;
								}
							} else {
								paramMap.put(title[cellNum], null);
								nullCol++;
							}
						}
						
						if (title.length == nullCol)
							continue;
						
						paramMap.put("FILE_NM", fileName);
						paramMap.put("ROW_NO", rowNum + 1);
						rowList.add(paramMap);
					}
				}
			} else {
				String message = "上传的 EXCEL 里没有数据！";
				throw new IOException(message);
			}
		} 
		return rowList;
	}
	
	private static List<Map<String, Object>> read2007Excel(String fileName, InputStream is, String[] title) throws IOException {

		// Workbook
		XSSFWorkbook wb = null;
		if (is == null) {
			File file = new File(fileName);
			wb = new XSSFWorkbook(new FileInputStream(file));
		} else {
			wb = new XSSFWorkbook(is);
		}
		// Text Extraction
		XSSFExcelExtractor extractor = new XSSFExcelExtractor(wb);
		extractor.setFormulasNotResults(true);
		extractor.setIncludeSheetNames(false);
		// System.out.println( extractor.getText() );

		Map<String, Object> paramMap = null;
		List<Map<String, Object>> rowList = null;
		// Getting cell contents
//		for (int sheetNum = 0; sheetNum < wb.getNumberOfSheets(); sheetNum++) {
		int sheetNum = 0;
		XSSFSheet sheet = wb.getSheetAt(sheetNum);
		if (sheet != null) {
			int rows = sheet.getPhysicalNumberOfRows(); // 获得行数
			if (rows > 1) {
				
				int cells = title.length;// 获得列数
				boolean bool = false;
				for (int cellNum = 0; cellNum < cells; cellNum++) { 
					XSSFCell cell = sheet.getRow(0).getCell(cellNum);
					if (cell != null && StringUtils.isNotBlank(cell.getStringCellValue()) && title[cellNum].equals(cell.getStringCellValue())) {
						bool = true;
					} else {
						bool = false;
					}
				}
				
				if (bool) {
					throw new IOException("导入的 Excel 模板错误！");
				} 
				
				rowList = new ArrayList<Map<String, Object>>();
				sheet.getMargin(Sheet.TopMargin);
				for (int rowNum = 1; rowNum < rows; rowNum++) {
					XSSFRow row = sheet.getRow(rowNum);
					if (row != null) {
						paramMap = new HashMap<String, Object>();
						
						int nullCol = 0;
						
						for (int cellNum = 0; cellNum < title.length; cellNum++) { // 列循环

							XSSFCell cell = row.getCell(cellNum);
							if (cell != null) {
								if (StringUtils.isNotBlank(cell.getStringCellValue())) {
									paramMap.put(title[cellNum]+"", StringUtils.trim(cell.getStringCellValue()));
								} else {
									paramMap.put(title[cellNum]+"", null);
									nullCol++;
								}
							} else {
								paramMap.put(title[cellNum], null);
								nullCol++;
							}
						}
						
						if (title.length == nullCol)
							continue;
						
						paramMap.put("FILE_NM", fileName);
						paramMap.put("ROW_NO", rowNum);
						rowList.add(paramMap);
					}
				}
			} else {
				String message = "上传的 EXCEL 里没有数据！";
				throw new IOException(message);
			}
		}
		return rowList;
	}
	
	@SuppressWarnings("unused")
	private static String getValue(Cell cell) throws UnsupportedEncodingException {
		if (cell == null)
			return null;
		
		if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
			return replaceValue(String.valueOf(cell.getBooleanCellValue()));
		} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			short format = cell.getCellStyle().getDataFormat();  
		    SimpleDateFormat sdf = null;  
		    if (format == 14 || format == 31 || format == 57 || format == 58 || format == 20 || format == 32) {
			    if(format == 14 || format == 31 || format == 57 || format == 58){  
			        //日期  
			        sdf = new SimpleDateFormat("yyyy-MM-dd");  
			    } else if (format == 20 || format == 32) {  
			        //时间  
			        sdf = new SimpleDateFormat("HH:mm");  
			    }  
			    double value = cell.getNumericCellValue();  
			    Date date = org.apache.poi.ss.usermodel.DateUtil.getJavaDate(value);  
			    return  sdf.format(date);  
		    } else {
		    	return replaceValue(String.valueOf(cell.getNumericCellValue()));
		    }
		} else {
			return replaceValue(String.valueOf(cell.getStringCellValue()));
		}
	}  
	
	private static String replaceValue(String inStr) throws UnsupportedEncodingException {
		String str = utf8ToUnicode(inStr);
		return unicodeToUtf8(str);
	}
	
	/**
	  * unicode 转换成 utf-8
	  * @author fanhui
	  * 2007-3-15
	  * @param theString
	  * @return
	  */
	private static String unicodeToUtf8(String theString) {
		char aChar;
		int len = theString.length();
		StringBuffer outBuffer = new StringBuffer(len);
		for (int x = 0; x < len;) {
			aChar = theString.charAt(x++);
			if (aChar == '\\') {
				aChar = theString.charAt(x++);
				if (aChar == 'u') {
					// Read the xxxx
					int value = 0;
					for (int i = 0; i < 4; i++) {
						aChar = theString.charAt(x++);
						if (aChar == '\\' || aChar == 'u') {
							x--;
							break;
						}
						switch (aChar) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							value = (value << 4) + aChar - '0';
							break;
						case 'a':
						case 'b':
						case 'c':
						case 'd':
						case 'e':
						case 'f':
							value = (value << 4) + 10 + aChar - 'a';
							break;
						case 'A':
						case 'B':
						case 'C':
						case 'D':
						case 'E':
						case 'F':
							value = (value << 4) + 10 + aChar - 'A';
							break;
						default:
//							logger.debug("theString ======>" + theString);
							throw new IllegalArgumentException(
									"Malformed   \\uxxxx   encoding. value " + theString);
						}
					}
					outBuffer.append((char) value);
				} else {
					if (aChar == 't')
						aChar = '\t';
					else if (aChar == 'r')
						aChar = '\r';
					else if (aChar == 'n')
						aChar = '\n';
					else if (aChar == 'f')
						aChar = '\f';
					outBuffer.append(aChar);
				}
			} else
				outBuffer.append(aChar);
		}
		return outBuffer.toString();
	}
	
	private static String utf8ToUnicode(String inStr) {
		char[] myBuffer = inStr.toCharArray();

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < inStr.length(); i++) {
			UnicodeBlock ub = UnicodeBlock.of(myBuffer[i]);
			if (ub == UnicodeBlock.BASIC_LATIN) {
				// 英文及数字等
				sb.append(myBuffer[i]);
			} else if (ub == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
				// 全角半角字符
//				int j = (int) myBuffer[i] - 65248;
//				sb.append((char) j);
				sb.append(myBuffer[i]);
			} else {
				// 汉字
				int s = (int) myBuffer[i];
				String hexS = Integer.toHexString(s);
				String unicode = "\\u" + hexS;
//				if (s == 11264) {
//					System.out.println("====================");
//				}
				if (s != 128)
				sb.append(unicode.toLowerCase());
			}
		}

		return sb.toString();
	}
	
	public static void main(String argv[]) {
		try {
			StringBuffer sBuffer = new StringBuffer();
			int value = 0;
			value = (value << 4) + '8' - '0';
			char cv = (char) value;
			sBuffer.append(cv);
			value = (value << 4) + '0' - '0';
			char iv = (char) value;
			sBuffer.append(iv);
			System.out.println(sBuffer.toString());
		} catch (Exception e) {
			System.out.println("Exception occurred! : " + e);
		}
	}
}

