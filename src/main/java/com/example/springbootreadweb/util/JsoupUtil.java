package com.example.springbootreadweb.util;


import com.example.springbootreadweb.entity.Chapter;
import com.example.springbootreadweb.entity.ChapterContent;
import com.example.springbootreadweb.service.ChapterContentService;
import com.example.springbootreadweb.service.ChapterService;
import com.example.springbootreadweb.service.impl.ChapterContentServiceImpl;
import com.example.springbootreadweb.service.impl.ChapterServiceImpl;
import com.example.springbootreadweb.util.vo.ChapterBean;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class JsoupUtil {

    @Autowired
    private ChapterService chapterService;

    @Autowired
    private ChapterContentService chapterContentService;



    public static void main(String[] args) {

        JsoupUtil jsoupUtil = new JsoupUtil();
        long id = 1787637821658415106L;
        String str = "https://www.biqooge.com/0_9/";
        jsoupUtil.h1(str,id);
//        h1(str,id);

    }
/*

    public void handler1(String urlStr, long bookId) {

//        List<String> resultList = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(urlStr).get();
            List<ChapterBean> beans = parseBySelector(doc);

            for (ChapterBean bean : beans) {
                String result = handler2(bean.getLink());
                if (result == ""){ return;}


                ChapterContent content = new ChapterContent();

                content.setContent(result);

                chapterContentService.save(content);
                long contentId = content.getId();

                Chapter chapter = new Chapter();
                chapter.setContentId(contentId);
                chapter.setBookId(bookId);
                chapter.setName(bean.getName());

                chapterService.save(chapter);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        System.out.println(resultList.size());

    }


    public String handler2(String urlStr) throws Exception {

        Document document = Jsoup.connect(urlStr).get();
        Elements vipEle = document.select("div.vip-limit-wrap");
        if (vipEle.size() > 0) {
            return "";
        }
        Element divEle = document.select("div.read-content.j_readContent").first();
        return divEle.text();
    }

    public List<ChapterBean> parseBySelector(Document doc) {
        List<ChapterBean> links = new ArrayList<>();
        // css选择器
        Elements elements = doc.select("h2.book_name > a");
        for (Element h2Ele : elements) {
            Element aEle = h2Ele.getElementsByTag("a").get(0);

            ChapterBean bean = new ChapterBean();
            bean.setLink("https:" + aEle.attr("href"));
            bean.setName(aEle.text());
            links.add(bean);
        }
        return links;
    }

 */

    public void h1(String urlStr,Long bookId) {


        List<ChapterBean> links = h2(urlStr);
        for (ChapterBean bean : links) {
            String result = h3(bean.getLink());

            ChapterContent content = new ChapterContent();

            content.setContent(result);

            chapterContentService.save(content);

            long contentId = content.getId();

            Chapter chapter = new Chapter();
            chapter.setContentId(contentId);
            chapter.setBookId(bookId);
            chapter.setName(bean.getName());
            chapterService.save(chapter);

        }

    }

    public static List<ChapterBean> h2(String urlStr) {
        Document document = null;
        List<ChapterBean> links = new ArrayList<>();
        try {
            document = Jsoup.connect(urlStr).get();

            Elements ddElements = document.select("dd");
            int i = 0;
            for (Element ddElement : ddElements) {

                if (i < 9) {
                    i++;
                    continue;
                }
                Element aElement = ddElement.getElementsByTag("a").first();
                String link = aElement.attr("href");
                link = urlStr + link.substring(5);
                ChapterBean bean = new ChapterBean();
                bean.setName(aElement.text());
                bean.setLink(link);
                links.add(bean);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return links;
    }

    public static String h3(String urlStr){
        String result = "";
        try {
            Document document = Jsoup.connect(urlStr).get();
            Element divElement = document.select("div#content").first();
            result = divElement.text();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


}
