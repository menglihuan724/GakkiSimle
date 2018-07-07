package com.terry.gakkisimle.wechat.spider;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 下载百度图片 
 *
 **/


public class DownloadBaiduPicture implements PageProcessor {
    private Site site = Site.me()//.setHttpProxy(new HttpHost("127.0.0.1",8888))
            .setRetryTimes(3).setSleepTime(1000).setUseGzip(true).setCharset("utf-8");
    List<String> urls;
    List<String> names;
    static String key;
    int pageNum;

    public DownloadBaiduPicture(int page) {
        this.pageNum = page;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }


    public List<String> getUrls() {
        return urls;
    }

    public List<String> getNames() {
        return names;
    }

    public Site getSite() {
        return site;
    }


    public void process(Page page) {
        List<String> url_list = new ArrayList();
        List<String> name_list = new ArrayList();
        JSONObject jsonObject = (JSONObject) JSONObject.parse(page.getRawText());
        JSONArray data = (JSONArray) jsonObject.get("imgs");
        //JSONArray data = (JSONArray) jsonObject.get("data");
        for(int i=0;i<data.size();i++){
            String url = (String) data.getJSONObject(i).get("objURL");
            String name = (String) data.getJSONObject(i).get("fromPageTitle");
            if(url!=null){
                url_list.add(url);
                name_list.add(name);
            }
        }
        setUrls(url_list);
        setNames(name_list);
        List<String> urlList =getUrls();
        for (int j = 0; j <urlList.size() ; j++) {
            new Thread(new DownLoader(urlList.get(j),j,pageNum)).start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        key = "新垣结衣";    //百度图片 关键词

        for(int pageNum=0;pageNum<24;pageNum++){   //控制爬取页数，一页30张图片
            //String url = "https://image.baidu.com/search/acjson?tn=resultjson_com&ipn=rj&queryWord="+key+"&word="+key+"&pn="+i*3+"0";
            String url="http://image.baidu.com/search/avatarjson?tn=resultjsonavatarnew&ie=utf-8&word="+key+"&cg=star&pn="+pageNum*30+"&rn=30&itg=0&z=0&fr=&width=&height=&lm=-1&ic=0&s=0&st=-1&gsm="+Integer.toHexString(pageNum*30);
            DownloadBaiduPicture downloadPicture=new DownloadBaiduPicture(pageNum);
            Spider spider=Spider.create(downloadPicture);
            spider.addUrl(url).start();
        }

    }
    /*图片下载*/
    static class  DownLoader implements Runnable{  
        String myurl;
        int name;
        int page;
        public DownLoader(String url,int name,int page) {
            this.myurl=url;
            this.name=name;
            this.page=page;
        }

        private void downloadPicture() {
            URL url = null;
            try {
                url = new URL(myurl);
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                String imageName = page+"_"+name + ".jpg";
                File file=new File("F:\\Pic\\"+key);    //设置下载路径
                if(!file.isDirectory()){
                    file.mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File("F:\\Pic\\"+ key +"\\"+ imageName.trim()));
                byte[] buffer = new byte[1024];
                int length;
                while ((length = dataInputStream.read(buffer)) > 0) {
                    fileOutputStream.write(buffer, 0, length);
                }
                dataInputStream.close();
                fileOutputStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        public void run() {
            downloadPicture();
        }
    }
}  