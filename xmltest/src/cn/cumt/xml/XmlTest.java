package cn.cumt.xml;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;

public class XmlTest {

    public static void main(String[] args) throws IOException {

        String path = XmlTest.class.getClassLoader().getResource("students.xml").getPath();
        Document document = Jsoup.parse(new File(path),"utf-8");

        System.out.println(document);
    }
}
