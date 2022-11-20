package com.example.reservation;

import android.util.Log;

import java.io.*;
import java.net.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/***
 * @Author jianghanchen
 * @Date 13:53 2022/11/13
 ***/
public class GetPostUtil {
//    public static String sendPost(String url, String params){
//        final String TAG = "data";
//        PrintWriter out = null;
//        BufferedReader in = null;
//        String res = "";
//        try{
//            URL realURL = new URL(url);
//            URLConnection conn = realURL.openConnection();
//            conn.setRequestProperty("accept", "*/*");
//            conn.setRequestProperty("connection", "Keep-Alive");
//            conn.setDoInput(true);
//            conn.setDoOutput(true);
//
//            out = new PrintWriter(conn.getOutputStream());
//            out.print(params);
//            out.flush();
//            in = new BufferedReader(
//                    new InputStreamReader(conn.getInputStream())
//            );
//            String line;
//            while((line = in.readLine()) != null){
//                res += "\n" + line;
//            }
////            conn.setRequestProperty("user-agent","");
//
//        } catch (Exception e) {
//            Log.i(TAG,"sendPost: "+res);
//            e.printStackTrace();
//        } finally {
//            try{
//                if(out != null){
//                    out.close();
//                }
//                if(in != null){
//                    in.close();
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//        return res;
//
////    }
//public static String httpGet(String url,String token) throws URISyntaxException {
//    //创建HttpClient对象
//    CloseableHttpClient httpClient = HttpClients.createDefault();
//    CloseableHttpResponse httpResponse ;
//    String finalString = null;
//    HttpGet httpGet = new HttpGet(url);
//    httpGet.setHeader("accept", "*/*");
//    httpGet.setHeader("Accept-Encoding","gzip, deflate");
//    httpGet.setHeader("Cache-Control","no-cache");
//    httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");
//    httpGet.setHeader("authorization",token);
//
//    System.out.println("发起请求的信息："+httpGet);
//    try {
//        httpResponse = httpClient.execute(httpGet);
//        HttpEntity entity = httpResponse.getEntity();
//        finalString= EntityUtils.toString(entity, "UTF-8");
//        try {
//            httpResponse.close();
//            httpClient.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    } catch (IOException e) {
//        e.printStackTrace();
//    }
//    return finalString;
//}


    private static String URL_PATH="http://www.baidu.com";
    private static HttpURLConnection httpURLConnection = null;
    public GetPostUtil(){}



    public static String sendPost(String url, String params){
        InputStream inputStream = getInputStream(url);
        String result= null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            result = "";
            String line = "";
            try {
                while((line = reader.readLine())!= null){
                    result = result+ line;
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(result);
            httpURLConnection.disconnect();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;

    }
    /**
     * 获取服务端的数据，以InputStream返回
     * @return
     */
    public static InputStream getInputStream(String urlPath){
        InputStream inputStream = null;

        try {
            URL url = new URL(urlPath);
            if(url != null){
                try {
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    //设置超时时间
                    httpURLConnection.setConnectTimeout(3000);
                    //设置请求方式
                    httpURLConnection.setRequestMethod("GET");
                    int responsecode = httpURLConnection.getResponseCode();
                    if(responsecode == HttpURLConnection.HTTP_OK){
                        inputStream = httpURLConnection.getInputStream();
                    }
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return inputStream;
    }
}
