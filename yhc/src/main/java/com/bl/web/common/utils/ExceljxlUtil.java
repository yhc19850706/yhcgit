package com.bl.web.common.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import com.bl.web.common.config.ExcelAnnotation;

public class ExceljxlUtil {

	/**
	 * 创建临时的文件
	 * 
	 * @return File
	 */
	public static File createTempFile(String folderName, String fName) {
		// String fileName = ExceljxlUtil.FILE_DIRECTORY + "\\" + folderName +
		// "\\" + fName + "_" + Calendar.getInstance().getTimeInMillis() +
		// ".xls";
		String fileName = folderName + "_" + fName + "_" + Calendar.getInstance().getTimeInMillis() + ".xls";
		File file = new File(fileName);
		return file;
	}

	/**
	 * 将List生成Excel文件,并返回Excel文件的输出流
	 * 
	 * @param title
	 *            标题
	 * @param list
	 *            要成才excel对象
	 * @param c
	 *            需要生成的对象
	 * @return
	 * @throws WriteException
	 * @throws IOException
	 */
	public static File write(String title, List<?> list, Class<?> c, String folderName, String fileName,
		HttpServletResponse response) throws WriteException, IOException {
		try {
			if (list == null || list.size() == 0 || c == null) {
				return null;
			}
			OutputStream output = response.getOutputStream();

			File file = ExceljxlUtil.createTempFile(folderName, fileName);

			response.reset();// 清空输出流
			response.setHeader("Content-disposition", "attachment; filename=" + file.getPath());// 设定输出文件头
			response.setContentType("application/msexcel");// 定义输出类型

			WritableWorkbook workbook = Workbook.createWorkbook(output);

			// 字体设置
			WritableFont font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false,
				UnderlineStyle.NO_UNDERLINE, jxl.format.Colour.BLUE);
			WritableCellFormat cellFormat = new WritableCellFormat(font);
			int sheetNum = 0;

			WritableSheet sheet = workbook.createSheet("Sheet" + sheetNum, 0);
			// Label titleLabel = new Label(0, 0, title, cellFormat);
			// try {
			// if (titleLabel != null)
			// sheet.addCell(titleLabel);
			// } catch (RowsExceededException e) {
			// e.printStackTrace();
			// } catch (WriteException e) {
			// e.printStackTrace();
			// }

			// 写文件
			String[] rowNames = ExceljxlUtil.getFieldAnnotation(c);
			// 首行显示
			for (int i = 0; i < rowNames.length; i++) {
				Label label = null;
				label = new Label(i, 0, rowNames[i], cellFormat);
				try {
					if (label != null)
						sheet.addCell(label);
				} catch (RowsExceededException e) {
					e.printStackTrace();
				} catch (WriteException e) {
					e.printStackTrace();
				}
			}

			int row = 1;
			// 数据显示
			for (int i = 0; i < list.size(); i++) {
				Object obj = list.get(i);
				List<Object> columnValues = ExceljxlUtil.getFieldValue(obj);
				for (int j = 0; j < columnValues.size(); j++) {
					Label label = null;
					// 超过5000条数据就再建一个sheet，这里设置为3用于测试
					if (row > 60000) {
						sheetNum++;
						sheet = workbook.createSheet("Sheet" + sheetNum, sheetNum);
						row = 1;
						WritableSheet newSheet = workbook.getSheet(0);
						Cell[] cells = newSheet.getRow(1);
						for (int k = 0; k < cells.length; k++) {
							Label newLabel = new Label(k, 0, cells[k].getContents(), cellFormat);
							try {
								sheet.addCell(newLabel);
							} catch (RowsExceededException e) {
								e.printStackTrace();
							} catch (WriteException e) {
								e.printStackTrace();
							}
						}
					}

					label = new Label(j, row, columnValues.get(j).toString());
					if (label != null)
						sheet.addCell(label);
				}
				row++;
			}

			// 保存

			workbook.write();
			workbook.close();
			return file;
		} catch (RowsExceededException e) {
			e.printStackTrace();
			throw e;
		} catch (WriteException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

	}

	public static String[] getFieldAnnotation(Class<?> c) {

		Field[] fields = c.getDeclaredFields();
		List<Field> list = new ArrayList<Field>();
		for (int i = 0; i < fields.length; i++) {
			if (!fields[i].isAnnotationPresent(ExcelAnnotation.class))
				continue;
			list.add(fields[i]);
			// ExcelAnnotation excel =
			// fields[i].getAnnotation(ExcelAnnotation.class);
			// newfields[i] = excel.name();
		}
		String[] fieldAnnotations = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ExcelAnnotation excel = list.get(i).getAnnotation(ExcelAnnotation.class);
			fieldAnnotations[excel.order() - 1] = excel.name();
		}

		return fieldAnnotations;
	}

	public static List<Object> getFieldValue(Object obj) {
		Class<? extends Object> c = obj.getClass();
		Field[] fields = c.getDeclaredFields();
		List<Object> lists = new ArrayList<Object>();
		List<Field> list = new ArrayList<Field>();
		Object o = null;

		for (int i = 0; i < fields.length; i++) {
			if (!fields[i].isAnnotationPresent(ExcelAnnotation.class)) {
				continue;
			}
			list.add(fields[i]);
		}

		Field[] fieldAnnotations = new Field[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ExcelAnnotation excel = list.get(i).getAnnotation(ExcelAnnotation.class);
			fieldAnnotations[excel.order() - 1] = list.get(i);
		}

		for (int i = 0; i < fieldAnnotations.length; i++) {
			PropertyDescriptor pd = null;
			try {
				// 只取有ExcelAnnotation的值

				pd = new PropertyDescriptor(fieldAnnotations[i].getName(), c);
				Method getMethod = pd.getReadMethod();// 获得get方法
				o = getMethod.invoke(obj);
				if (o == null || o.equals(""))
					o = "";
				lists.add(o);
			} catch (IntrospectionException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}

		}
		return lists;
	}
}
