package com.cnblogs.yjmyzz.spring.cloud.study;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.client.RestTemplate;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @Author: cxx
 * SAX解析DOM
 * 一行一行  Handler
 * startElement
 * endElement
 * @Date: 2018/5/29 20:03
 */
public class SaxDemo {

    public static void main(String[] args) throws Exception {
    	RestTemplate restTemplate = new RestTemplate();
    	
    	HttpHeaders header = new HttpHeaders();
    	//输入自己的用户名和密码
    	String userAndPass = "yjmyzz:123456";
    	//Basic后有空格
    	//Base64需要maven引入commons-codec
    	header.add("Authorization", "Basic "+new String(Base64.encode(userAndPass.getBytes())));
    	header.add("Accept", "application/json");
    	HttpEntity<String> entity = new HttpEntity<>(header);
    	ResponseEntity<String> response = restTemplate.exchange("http://localhost:8200/eureka/apps", HttpMethod.GET, entity, String.class);
        //1.或去SAXParserFactory实例
        SAXParserFactory factory = SAXParserFactory.newInstance();
        //2.获取SAXparser实例
        SAXParser saxParser = factory.newSAXParser();
        //创建Handel对象
        SAXDemoHandel handel = new SAXDemoHandel();
        saxParser.parse(response.getBody(), handel);
    }
}

class SAXDemoHandel extends DefaultHandler {
    //遍历xml文件开始标签
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("sax解析开始");
    }

    //遍历xml文件结束标签
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("sax解析结束");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equals("student")){
            System.out.println("============开始遍历student=============");
            //System.out.println(attributes.getValue("rollno"));
        }
        else if (!qName.equals("student")&&!qName.equals("class")){
            System.out.print("节点名称:"+qName+"----");
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("student")){
            System.out.println(qName+"遍历结束");
            System.out.println("============结束遍历student=============");
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch,start,length).trim();
        if (!value.equals("")) {
            System.out.println(value);
        }
    }
}