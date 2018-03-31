package com.yhc.weixin.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.yhc.weixin.model.WeixinMessage;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * 消息文本处理工具类
 * <p>类的描述:</p>
 * <p>@Description: TODO</p>
 * <p>@author 小海</p>
 * <p>@time:2017年4月30日 下午1:28:16</p>
 * <p>@Vesion: 1.0</p>
 */
public class MessageUtil {
    // 请求的文本类型
    public static final String REQ_MESSAGE_TYPE_TEXT = "text";

    // 响应的文本类型
    public static final String RESP_MESSAGE_TYPE_TEXT = "text";

    /**
     * 解析从请求的获取的xml格式的字符串
     * 使用dom4j的方式进行解析
     * @param request
     * @return
     * @throws IOException
     * @throws Exception
     */
    public static Map<String, String> parseXML(HttpServletRequest request) throws Exception {
        /*
         * 请求中的XML的格式：请查询微信开发文档
         *<xml>
         *<ToUserName><![CDATA[toUser]]></ToUserName>
         *<FromUserName><![CDATA[fromUser]]></FromUserName>
         *<CreateTime>1348831860</CreateTime>
         *<MsgType><![CDATA[text]]></MsgType>
         *<Content><![CDATA[this is a test]]></Content>
         *<MsgId>1234567890123456</MsgId>
         *</xml>
         */

        // 记录XML解析处理的数据进行存储：key是ToUserName，value是<![CDATA[toUser]]>....
        Map<String, String> map = new LinkedHashMap<String,String>();

        // 根据请求request对象获取流对象
        final InputStream inputStream = request.getInputStream();

        /* DOM4J解析 */
        // 创建SAX解析构造器对象
        final SAXReader reader = new SAXReader();
        // 通过读取流的对象，获取文档对象
        final Document document = reader.read(inputStream);
        // 获取跟节点:<xml> 这个是就更节点
        final Element root = document.getRootElement();
        // 获取跟节点下的子节点
        final List<Element> elements = root.elements();
        // 遍历解析
        for (Element element : elements) {
            // 节点名称和节点的值
            map.put(element.getName(), element.getText());
        }

        // 关闭流
        if (inputStream != null) {
            inputStream.close();
        }
        return map;
    }

    /**
     * 将消息文本对象的数据转换成XML格式的字符串
     * @param messges 消息文本对象
     * @return
     */
    public static String messageToXml(WeixinMessage messges) {
        // 给对象取个别名
        xStream.alias("xml", messges.getClass());
        final String resultMml = xStream.toXML(messges);
        System.out.println(resultMml);
        return resultMml;
    }

    /*@Test
    public void test() {
        TextMessges messges = new TextMessges();
        messges.setToUserName("1");
        messges.setFromUserName("2");
        messges.setCreateTime(new Date().getTime());
        messges.setContent("3");
        messges.setMsgType("text");
        MessageUtil.messageToXml(messges);
    }*/

    /**
     * 用于扩展节点数据按照<ToUserName><![CDATA[toUser]]></ToUserName>，中间加上CDATA。
     */
    private static XStream xStream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                boolean cdata = true;

                public void startNode(String name, Class claszz) {
                    // 将字符串的首个字母转换成大写：微信规定是标签首个字母大写，除了根标签xml外
                    /*if (!"xml".equals(name)) {
                        name = toUpperCaseFirstOne(name);
                    }*/
                    super.startNode(name, claszz);
                }

                protected void writerText(QuickWriter writer, String text) {
                    if (cdata) {
                        writer.write("<![CDATA[");
                        writer.write(text);
                        writer.write("]]>");
                    } else {
                        writer.write(text);
                    }
                }
            };
        }
    });

    /**
     * 将字符串的的首个字符变成大写
     * @param name
     * @return
     */
    public static String toUpperCaseFirstOne(String name) {
        if (name != null) {
            char[] ch = name.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (i == 0) {
                    ch[0] = Character.toUpperCase(ch[0]);
                } else {
                    ch[i] = Character.toLowerCase(ch[i]);
                }
            }
            StringBuffer a = new StringBuffer();
            a.append(ch);
            return a.toString();
        }
        return name;
    }
}
