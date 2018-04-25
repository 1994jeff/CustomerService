package com.example.customerservicesystem.untils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.example.customerservicesystem.bean.User;
import com.example.customerservicesystem.bean.wx.TextMsg;
import com.example.customerservicesystem.service.UserService;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 *weixin 核心服务类
 */
public class CoreService {

	@Resource
	UserService userService;

	/**
	 * 处理微信发来的请求
	 * 
	 * @param request
	 * @return
	 */
	public Map<String, String> processRequest(HttpServletRequest request, HttpServletResponse response) {
			// 解析用户发送过来的信息
			// 拿取请求流
			// 将解析结果存储在HashMap中
			Map<String, String> map = null;
			try {
				InputStream is = null;
				Document document = null;
				String textMsg2Xml = "";
				is = request.getInputStream();
				map = new HashMap<String, String>();
				// 解析xml，将获取到的返回结果xml进行解析成我们习惯的文字信息
				SAXReader reader = new SAXReader();// 第三方jar:dom4j【百度：saxreader解析xml】
					document = reader.read(is);
				// 得到xml根元素
				Element root = document.getRootElement();
				// 得到根元素的所有子节点
				List<Element> elementList = root.elements();

				// 遍历所有子节点to Map
				for (Element e : elementList) {
					map.put(e.getName(), e.getText());
				}
			} catch (IOException e) {
			} catch (DocumentException e) {
			}
			return map;
	}

	public String MsgToString(TextMsg textMsg) {
		xstream.alias("xml", textMsg.getClass());
		String textMsg2Xml = xstream.toXML(textMsg);
		return textMsg2Xml;
	}

	/**
	 * emoji表情转换(hex -> utf-16)
	 * 
	 * @param hexEmoji
	 * @return
	 */
	public static String emoji(int hexEmoji) {
		return String.valueOf(Character.toChars(hexEmoji));
	}
	
	/**
     * 扩展xstream使其支持CDATA
     */
    private static XStream xstream = new XStream(new XppDriver() {
        public HierarchicalStreamWriter createWriter(Writer out) {
            return new PrettyPrintWriter(out) {
                // 对所有xml节点的转换都增加CDATA标记
                boolean cdata = true;

                @SuppressWarnings("unchecked")
                public void startNode(String name, Class clazz) {
                    super.startNode(name, clazz);
                }
                protected void writeText(QuickWriter writer, String text) {
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
}