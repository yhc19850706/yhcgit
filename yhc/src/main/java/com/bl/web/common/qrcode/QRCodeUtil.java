package com.bl.web.common.qrcode;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.bl.web.common.config.BlGlobalVariable;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
* QRCode Util
* @description
*
* @author qiancheng  
* @version 1.0  
* @created 2015-4-24 上午12:56:15 
*
*/
public class QRCodeUtil {
	  public static final String CHARSET = "utf-8";
	    
	    public static final String FORMAT_JPG = "jpg";
	    
	    public static final String FORMAT_GIF = "gif";
	    
	    public static final String FORMAT_PNG = "png";
	    
	    // 二维码尺寸
	    private static final int QRCODE_SIZE = 300;
	    
	    // LOGO尺寸
	    private static final int LOGO_SIZE =215 ;
	    
	    /**
	     * 生成二维码<br>
	     * 不带logo
	     * @param content
	     * @param imgPath
	     * @param needCompress
	     * @return
	     * @throws Exception
	     */
	    public static BufferedImage createQRCode(String content) throws Exception {
	    	return createQRCode(content, false);
	    }
	    
	    /**
	     * 生成二维码<br/>
	     * 带 logo
	     * @param content
	     * @param imgPath
	     * @param needCompress
	     * @return
	     * @throws Exception
	     */
	    public static BufferedImage createQRCodeWithLogo(String content) throws Exception {
	    	return createQRCode(content,true);
	    }
	    

		public static BufferedImage createQRCodeWithLogo(String url, Integer size) throws Exception {
			return createQRCode(url, true,size);
		}

		public static BufferedImage createQRCode(String url, Integer size) throws Exception {
			return createQRCode(url,false,size);
		}
		
		
	    /**
	     * 生成二维码<br>
	     * 可自定义logo，可自定义二维码尺寸
	     * @param content
	     * @param imgPath
	     * @param needCompress
	     * @return
	     * @throws Exception
	     */
	    public static BufferedImage createQRCode(String content, boolean isWithLogo, Integer size) throws Exception {
	    	size = size!=null?size:QRCODE_SIZE;
	    	Map<EncodeHintType,Object> hints = new HashMap<EncodeHintType,Object>();
	    	hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
	    	hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
	    	hints.put(EncodeHintType.MARGIN, 1);
	    	BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE, size, size, hints);
	    	int width = bitMatrix.getWidth();
	    	int height = bitMatrix.getHeight();
	    	BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	    	for (int x = 0; x < width; x++) {
	    		for (int y = 0; y < height; y++) {
	    			image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
	    		}
	    	}
	    	
	    	if (isWithLogo) {
	    		//QRCodeUtil.addLogo(image,size);
	    	}
	    	return image;
	    }
	   
	    /**
	     * 生成二维码<br>
	     * 可自定义logo
	     * @param content
	     * @param imgPath
	     * @param needCompress
	     * @return
	     * @throws Exception
	     */
		public static BufferedImage createQRCode(String content, boolean isWithLogo) throws Exception {
			Map<EncodeHintType,Object> hints = new HashMap<EncodeHintType,Object>();
	        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
	        hints.put(EncodeHintType.CHARACTER_SET, CHARSET);
	        hints.put(EncodeHintType.MARGIN, 1);
	        BitMatrix bitMatrix = new MultiFormatWriter().encode(content,BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE, hints);
	        int width = bitMatrix.getWidth();
	        int height = bitMatrix.getHeight();
	        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	        for (int x = 0; x < width; x++) {
	            for (int y = 0; y < height; y++) {
	                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
	            }
	        }
	        
	        if (isWithLogo) {
	        	//QRCodeUtil.addLogo(image);
	        }
	        return image;
	    }
		/**
		 * 生成员工二维码
		 * @param empId
		 * @param size
		 */
		public static void encoderEmpQRCode(String empId,int size) { 
			try {
				String content=ShortUtils.getShortUrl("http://m.xmfin.com/app.bl?empId="+empId);
				BufferedImage bufImg =createQRCode(content,size);
				File imgFile = new File(BlGlobalVariable.IMG_QRCODE_EMP_DIR+"/"+empId+"_"+size+".jpg");
				ImageIO. write(bufImg, "jpg" , imgFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		/**
		 * 生成门店二维码
		 * @param storeCode
		 * @param size
		 */
		public static void encoderStoreQRCode(String storeCode,int size) { 
			try {
				String content=ShortUtils.getShortUrl("http://m.xmfin.com/app.bl?storeCode="+storeCode);
				BufferedImage bufImg =createQRCode(content,size);
				File imgFile = new File(BlGlobalVariable.IMG_QRCODE_STORE_DIR+"/"+storeCode+"_"+size+".jpg");
				ImageIO. write(bufImg, "jpg" , imgFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		public static void main(String[] args){
			QRCodeUtil.encoderEmpQRCode("01001001", 256);
			
			
		}

		/**
		 * 生成加盟店门店二维码
		 * @param storeCode
		 * @param size
		 */
		public static void encoderJMStoreQRCode(String storeCode,int size) { 
			try {
				String content=ShortUtils.getShortUrl("http://m.xmfin.com/app.bl?jmStoreCode="+storeCode);
				BufferedImage bufImg =createQRCode(content,size);
				File imgFile = new File(BlGlobalVariable.IMG_QRCODE_STORE_DIR+"/"+storeCode+"_"+size+".jpg");
				ImageIO. write(bufImg, "jpg" , imgFile);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		/**
		 * 添加LOGO
		 * @param source
		 * @param imgPath
		 * @param needCompress
		 * @throws Exception
		 */
		private static void addLogo(BufferedImage source) throws Exception {
			boolean needCompress = true;
			ByteArrayInputStream in = new ByteArrayInputStream(Base64Util.base64StringToImage(""));
			Image src = ImageIO.read(in);
			int width = src.getWidth(null);
			int height = src.getHeight(null);
			if (needCompress) { // 压缩LOGO
				if (width > LOGO_SIZE) {
					width = LOGO_SIZE;
				}
				if (height > LOGO_SIZE) {
					height = LOGO_SIZE;
				}
				Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
				BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
				Graphics g = tag.getGraphics();
				g.drawImage(image, 0, 0, null); // 绘制缩小后的图
				g.dispose();
				src = image;
			}
			// 插入LOGO
			Graphics2D graph = source.createGraphics();
			int x = (QRCODE_SIZE - width) / 2;
			int y = (QRCODE_SIZE - height) / 2;
			graph.drawImage(src, x, y, width, height, null);
			Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
			graph.setStroke(new BasicStroke(3f));
			graph.draw(shape);
			graph.dispose();
		}
		  /**
	     * 给二维码图片添加Logo
	     * 
	     * @param qrPic
	     * @param logoPic
	     */
	    public void addLogo_QRCode(BufferedImage image,String imgPath)
	    {
	        try
	        {
	            Graphics2D g = image.createGraphics();
	            File logoPic=new File("D:\\qrcode\\logo\\logo156.jpg");
//	            ByteArrayInputStream in = new ByteArrayInputStream(Base64Util.base64StringToImage(Constant.QC_LOGO_BASE64));
				
	            /**
	             * 读取Logo图片
	             */
	            BufferedImage logo = ImageIO.read(logoPic);
	             
	            int widthLogo = logo.getWidth(), heightLogo = logo.getHeight();
	            if (widthLogo > LOGO_SIZE) {
	            	widthLogo = LOGO_SIZE;
				}
				if (heightLogo > LOGO_SIZE) {
					heightLogo = LOGO_SIZE;
				} 
	            // 计算图片放置位置
	            int x = (image.getWidth() - widthLogo) / 2;
	            int y = (image.getHeight() - logo.getHeight()) / 2;
	 
	            //开始绘制图片
	            g.drawImage(logo, x, y, widthLogo, heightLogo, null);
	            g.drawRoundRect(x, y, widthLogo, heightLogo, 15, 15);
	            g.setStroke(new BasicStroke(2f));
	            g.setColor(Color.WHITE);
	            g.drawRect(x, y, widthLogo, heightLogo);
	             
	            g.dispose();
	             
	            ImageIO.write(image, "jpg", new File(imgPath));
	        }
	        catch (Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
	    /**
	     * 添加LOGO<br/>
	     * 可自定义二维码尺寸
	     * @param source
	     * @param imgPath
	     * @param needCompress
	     * @throws Exception
	     */
	    private static void addLogo(BufferedImage source, Integer size) throws Exception {
	        boolean needCompress = true;
	        size = size!=null?size:QRCODE_SIZE;
	        int logoSize = (int)(0.2 * size);
	        ByteArrayInputStream in = new ByteArrayInputStream(Base64Util.base64StringToImage(""));
	        Image src = ImageIO.read(in);
	        int width = src.getWidth(null);
	        int height = src.getHeight(null);
	        if (needCompress) { // 压缩LOGO
	            if (width > logoSize) {
	                width = logoSize;
	            }
	            if (height > logoSize) {
	                height = logoSize;
	            }
	            Image image = src.getScaledInstance(width, height, Image.SCALE_SMOOTH);
	            BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	            Graphics g = tag.getGraphics();
	            g.drawImage(image, 0, 0, null); // 绘制缩小后的图
	            g.dispose();
	            src = image;
	        }
	        // 插入LOGO
	        Graphics2D graph = source.createGraphics();
	        int x = (size - width) / 2;
	        int y = (size - height) / 2;
	        graph.drawImage(src, x, y, width, height, null);
	        Shape shape = new RoundRectangle2D.Float(x, y, width, width, 6, 6);
	        graph.setStroke(new BasicStroke(3f));
	        graph.draw(shape);
	        graph.dispose();
	    }

}