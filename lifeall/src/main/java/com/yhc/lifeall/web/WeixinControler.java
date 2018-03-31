package com.yhc.lifeall.web;

import com.thoughtworks.xstream.XStream;
import com.yhc.lifeall.service.GetWeixinToken;
import com.yhc.weixin.api.TokenAPI;
import com.yhc.weixin.api.UserAPI;
import com.yhc.weixin.model.*;
import com.yhc.weixin.util.MapUtil;
import com.yhc.weixin.util.MessageUtil;
import com.yhc.weixin.util.XMLConverUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@RestController
public class WeixinControler {
    Logger logger = LoggerFactory.getLogger(WeixinControler.class);
        @Value("${weixin.Token}")
        private String token;
        @Value("${weixin.EncodingAESKey}")
        private String encodingAESKey;
        @Autowired
        private GetWeixinToken getWeixinToken;
       @RequestMapping(value = "/weixin")
       public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           logger.info("签名校验开始。");
           boolean isGet = request.getMethod().toLowerCase().equals("get");
           if (isGet) {
               String signature = request.getParameter("signature");//微信加密签名signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
               String timestamp = request.getParameter("timestamp");//时间戳
               String nonce = request.getParameter("nonce");//随机数
               String echostr = request.getParameter("echostr");//随机字符串
               //排序
               String sortString = sort(token, timestamp, nonce);
               //加密
               String mySignature = sha1(sortString);
               //校验签名
               if (mySignature != null && mySignature != "" && mySignature.equals(signature)) {
                   logger.info("签名校验通过。");
                   //如果检验成功输出echostr，微信服务器接收到此输出，才会确认检验完成。
                   response.getWriter().println(echostr);
//               response.getWriter().write(echostr);
               } else {
                   logger.info("签名校验失败.");
               }
           }else {
               // 进入POST聊天处理
               try {
                   // 接收消息并返回消息
                   acceptMessage(request, response);
               } catch (IOException e) {
                   e.printStackTrace();
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }

    }

    public String sort(String token, String timestamp, String nonce) {
         String[] strArray = {token, timestamp, nonce};
         Arrays.sort(strArray);
         StringBuilder sb = new StringBuilder();
         for (String str : strArray) {
                 sb.append(str);
             }
         
         return sb.toString();
    }

    /**
     75      * 将字符串进行sha1加密
     76      *
     77      * @param str 需要加密的字符串
     78      * @return 加密后的内容
     79      */
     public String sha1(String str) {
       try {
           MessageDigest digest = MessageDigest.getInstance("SHA-1");
           digest.update(str.getBytes());
           byte messageDigest[] = digest.digest();
           // Create Hex String
           StringBuffer hexString = new StringBuffer();
           // 字节数组转换为 十六进制 数
           for (int i = 0; i < messageDigest.length; i++) {
               String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
               if (shaHex.length() < 2) {
                   hexString.append(0);
               }
               hexString.append(shaHex);
           }
           return hexString.toString();

       }catch (NoSuchAlgorithmException e) {
              e.printStackTrace();
          }
          return "";
      }


    private void acceptMessage(HttpServletRequest request, HttpServletResponse response) throws Exception {
         request.setCharacterEncoding("UTF-8");
         response.setCharacterEncoding("UTF-8");
        final Map<String, String> resultMap = MessageUtil.parseXML(request);
        WeixinMessage weixinMessage = new WeixinMessage();
        MapUtil.map2Java(weixinMessage, resultMap);
        // 获取想要的数据
        // 开发者微信号:接收者，就是自己的服务器
        final String toUserName = resultMap.get("ToUserName");
        // 发送方帐号（一个OpenID）：微信用户
        final String fromUserName = resultMap.get("FromUserName");
        // 消息创建时间 （整型）
        final int createTime = Integer.parseInt(resultMap.get("CreateTime"));
        // 文本类型
        final String msgType = resultMap.get("MsgType");
        // 文本消息内容
        final String content = resultMap.get("Content");
        // 消息id，64位整型
        final String msgId = resultMap.get("MsgId");
        // 输入获取的信息
        final StringBuilder reqData = new StringBuilder();

        Token token=getWeixinToken.getToken();
        Long returnTime = Calendar.getInstance().getTimeInMillis() / 1000;// 返回时间
        // 根据消息类型获取对应的消息内容
        if (msgType.equals(MessageType.text.toString())) {
            // 文本消息
            System.out.println("开发者微信号：" + toUserName);
            System.out.println("发送方帐号：" + fromUserName);
            System.out.println("消息创建时间："  + new Date(createTime * 1000l));
            System.out.println("消息内容：" + "1111");
            System.out.println("消息Id：" + msgId);

            StringBuffer str = new StringBuffer();
            str.append("<xml>");
            str.append("<ToUserName><![CDATA[" + fromUserName + "]]></ToUserName>");
            str.append("<FromUserName><![CDATA[" + toUserName + "]]></FromUserName>");
            str.append("<CreateTime>" + returnTime + "</CreateTime>");
            str.append("<MsgType><![CDATA[" + msgType + "]]></MsgType>");
            str.append("<Content><![CDATA[你说的是：" + content + "，吗？]]></Content>");
            str.append("</xml>");
            System.out.println(str.toString());
            response.getWriter().write(str.toString());
        }else if(msgType.equals(MessageType.event.toString())){
            String eventType=resultMap.get("Event");
            if(eventType.equals("subscribe")){
//                //关注时间
                UserAPI userAPI=new UserAPI();
                User userInfo=userAPI.userInfo(token.getAccess_token(),fromUserName);
                System.out.println(MapUtil.objectToMap(userInfo));
            }
        }
    }
}
