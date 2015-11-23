package com.yhc.common.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

public class ClientInfoUtil {
	private String info = "";
	private String explorerVer = "未知";
	private String OSVer = "未知";

	/*
	 * 构造函数 参数：String request.getHeader("user-agent")
	 * 
	 * IE7:Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 6.1; Trident/4.0;
	 * SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media
	 * Center PC 6.0; .NET4.0C) IE8:Mozilla/4.0 (compatible; MSIE 8.0; Windows
	 * NT 6.1; Trident/4.0; SLCC2; .NET CLR 2.0.50727; .NET CLR 3.5.30729; .NET
	 * CLR 3.0.30729; Media Center PC 6.0; .NET4.0C) Maxthon:Mozilla/4.0
	 * (compatible; MSIE 7.0; Windows NT 6.1; Trident/4.0; SLCC2; .NET CLR
	 * 2.0.50727; .NET CLR 3.5.30729; .NET CLR 3.0.30729; Media Center PC 6.0;
	 * .NET4.0C; Maxthon 2.0) firefox:Mozilla/5.0 (Windows; U; Windows NT 6.1;
	 * zh-CN; rv:1.9.2.11) Gecko/20101012 Firefox/3.6.11 Chrome:Mozilla/5.0
	 * (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.7 (KHTML, like Gecko)
	 * Chrome/7.0.517.44 Safari/534.7 Opera:Opera/9.80 (Windows NT 6.1; U;
	 * zh-cn) Presto/2.6.30 Version/10.63
	 * 
	 * 操作系统： Win7 : Windows NT 6.1 WinXP : Windows NT 5.1
	 */
	public ClientInfoUtil(String info) {
		this.info = info;
	}

	/*
	 * 获取核心浏览器名称
	 */
	public String getExplorerName() {
		String str = "未知";
		Pattern pattern = Pattern.compile("");
		Matcher matcher;
		if (info.indexOf("MSIE") != -1) {
			str = "MSIE"; // 微软IE
			pattern = Pattern.compile(str + "\\s([0-9.]+)");
		} else if (info.indexOf("Firefox") != -1) {
			str = "Firefox"; // 火狐
			pattern = Pattern.compile(str + "\\/([0-9.]+)");
		} else if (info.indexOf("Chrome") != -1) {
			str = "Chrome"; // Google
			pattern = Pattern.compile(str + "\\/([0-9.]+)");
		} else if (info.indexOf("Opera") != -1) {
			str = "Opera"; // Opera
			pattern = Pattern.compile("Version\\/([0-9.]+)");
		}
		matcher = pattern.matcher(info);
		if (matcher.find())
			explorerVer = matcher.group(1);
		return str;
	}

	/*
	 * 获取核心浏览器版本
	 */
	public String getExplorerVer() {
		return this.explorerVer;
	}

	/*
	 * 获取浏览器插件名称（例如：遨游、世界之窗等）
	 */
	public String getExplorerPlug() {
		String str = "无";
		if (info.indexOf("Maxthon") != -1)
			str = "Maxthon"; // 遨游
		return str;
	}

	/*
	 * 获取操作系统名称
	 */
	public String getOSName() {
		String str = "未知";
		Pattern pattern = Pattern.compile("");
		Matcher matcher;
		if (info.indexOf("Windows") != -1) {
			str = "Windows"; // Windows NT 6.1
			pattern = Pattern.compile(str + "\\s([a-zA-Z0-9]+\\s[0-9.]+)");
		}
		matcher = pattern.matcher(info);
		if (matcher.find())
			OSVer = matcher.group(1);
		return str;
	}

	/*
	 * 获取操作系统版本
	 */
	public String getOSVer() {
		return this.OSVer;
	}

	/**
	 * 获取当前操作系统名称. return 操作系统名称 例如:windows xp,linux 等.
	 */
	// public static String getOSName() {
	// return System.getProperty("os.name").toLowerCase();
	// }

	/**
	 * 获取unix网卡的mac地址. 非windows的系统默认调用本方法获取. 如果有特殊系统请继续扩充新的取mac地址方法.
	 * 
	 * @return mac地址
	 */
	public static String getUnixMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			// linux下的命令，一般取eth0作为本地主网卡
			process = Runtime.getRuntime().exec("ifconfig eth0");
			// 显示信息中包含有mac地址信息
			bufferedReader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				// 寻找标示字符串[hwaddr]
				index = line.toLowerCase().indexOf("hwaddr");
				if (index >= 0) {// 找到了
					// 取出mac地址并去除2边空格
					mac = line.substring(index + "hwaddr".length() + 1).trim();
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}
		return mac;
	}

	/**
	 * 获取widnows网卡的mac地址.
	 * 
	 * @return mac地址
	 */
	public static String getWindowsMACAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			// windows下的命令，显示信息中包含有mac地址信息
			process = Runtime.getRuntime().exec("ipconfig /all");
			bufferedReader = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				System.out.println(line);
				// 寻找标示字符串[physical
				index = line.toLowerCase().indexOf("physical address");

				if (index >= 0) {// 找到了
					index = line.indexOf(":");// 寻找":"的位置
					if (index >= 0) {
						System.out.println(mac);
						// 取出mac地址并去除2边空格
						mac = line.substring(index + 1).trim();
					}
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}

		return mac;
	}

	/**
	 * windows 7 专用 获取MAC地址
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getMACAddress() throws Exception {

		// 获取本地IP对象
		InetAddress ia = InetAddress.getLocalHost();
		// 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
		byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();

		// 下面代码是把mac地址拼装成String
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < mac.length; i++) {
			if (i != 0) {
				sb.append("-");
			}
			// mac[i] & 0xFF 是为了把byte转化为正整数
			String s = Integer.toHexString(mac[i] & 0xFF);
			sb.append(s.length() == 1 ? 0 + s : s);
		}

		// 把字符串所有小写字母改为大写成为正规的mac地址并返回
		return sb.toString().toUpperCase();
	}

	/**
	 * 多级反向代理下，Java获取请求客户端的真实IP地址
	 * 
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request) {
		String ipAddress = null;
		// ipAddress = this.getRequest().getRemoteAddr();
		ipAddress = request.getHeader("x-forwarded-for");
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ipAddress == null || ipAddress.length() == 0
				|| "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if (ipAddress.equals("127.0.0.1")) {
				// 根据网卡取本机配置的IP
				InetAddress inet = null;
				try {
					inet = InetAddress.getLocalHost();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				ipAddress = inet.getHostAddress();
			}

		}

		// 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if (ipAddress != null && ipAddress.length() > 15) { // "***.***.***.***".length()
															// = 15
			if (ipAddress.indexOf(",") > 0) {
				ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	public static void getClientOtheInfo(HttpServletRequest request) {
		String agent = request.getHeader("user-agent");
		System.out.println(agent);
		StringTokenizer st = new StringTokenizer(agent, ";");
		st.nextToken();
		String userbrowser = st.nextToken();
		System.out.println(userbrowser);
		String useros = st.nextToken();
		System.out.println(useros);
		System.out.println(System.getProperty("os.name")); // win2003竟然是win xp？
		System.out.println(System.getProperty("os.version"));
		System.out.println(System.getProperty("os.arch"));
		System.out.println(request.getHeader("user-agent")); // 返回客户端浏览器的版本号、类型
		System.out.println(request.getMethod()); // ：获得客户端向服务器端传送数据的方法有get、post、put等类型
		System.out.println(request.getRequestURI()); // ：获得发出请求字符串的客户端地址
		System.out.println(request.getServletPath()); // ：获得客户端所请求的脚本文件的文件路径
		System.out.println(request.getServerName()); // ：获得服务器的名字
		System.out.println(request.getServerPort()); // ：获得服务器的端口号
		System.out.println(request.getRemoteAddr()); // ：获得客户端的ip地址
		System.out.println(request.getRemoteHost()); // ：获得客户端电脑的名字，若失败，则返回客户端电脑的ip地址
		System.out.println(request.getProtocol()); // ：
		System.out.println(request.getHeaderNames()); // ：返回所有request
														// header的名字，结果集是一个enumeration（枚举）类的实例
		System.out.println("Protocol: " + request.getProtocol());
		System.out.println("Scheme: " + request.getScheme());
		System.out.println("Server Name: " + request.getServerName());
		System.out.println("Server Port: " + request.getServerPort());
		System.out.println("Protocol: " + request.getProtocol());
		// System.out.println("Server Info: " +
		// getServletConfig().getServletContext().getServerInfo());
		System.out.println("Remote Addr: " + request.getRemoteAddr());
		System.out.println("Remote Host: " + request.getRemoteHost());
		System.out.println("Character Encoding: "
				+ request.getCharacterEncoding());
		System.out.println("Content Length: " + request.getContentLength());
		System.out.println("Content Type: " + request.getContentType());
		System.out.println("Auth Type: " + request.getAuthType());
		System.out.println("HTTP Method: " + request.getMethod());
		System.out.println("Path Info: " + request.getPathInfo());
		System.out.println("Path Trans: " + request.getPathTranslated());
		System.out.println("Query String: " + request.getQueryString());
		System.out.println("Remote User: " + request.getRemoteUser());
		System.out.println("Session Id: " + request.getRequestedSessionId());
		System.out.println("Request URI: " + request.getRequestURI());
		System.out.println("Servlet Path: " + request.getServletPath());
		System.out.println("Accept: " + request.getHeader("Accept"));
		System.out.println("Host: " + request.getHeader("Host"));
		System.out.println("Referer : " + request.getHeader("Referer"));
		System.out.println("Accept-Language : "
				+ request.getHeader("Accept-Language"));
		System.out.println("Accept-Encoding : "
				+ request.getHeader("Accept-Encoding"));
		System.out.println("User-Agent : " + request.getHeader("User-Agent"));
		System.out.println("Connection : " + request.getHeader("Connection"));
		System.out.println("Cookie : " + request.getHeader("Cookie"));
	}

	public static void main(String[] args) {

	}
}
