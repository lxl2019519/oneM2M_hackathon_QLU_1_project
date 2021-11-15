package com.example.controller;

//import cn.hutool.json.JSONObject;
import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.common.Result;
import com.example.entity.Notice;
import com.example.service.NoticeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * @author by ZhaoKun
 * @version 1.0
 * @date 2021-10-11 10:24
 *
 *Get the data in the CSE in onem2m on the web
 *
 */
@RestController
@RequestMapping("/api/get")
public class GetController {

    @Resource
    private NoticeService noticeService;
    String ult = null;
    String water = null;
    String tem = null;
    String hum = null;

    @PostMapping
//    @GetMapping("/ult")
    public cn.hutool.json.JSONObject get() {

        //Cat food storage capacity
        String str =get111("http://192.168.209.14:8090/~/server/server/mydevice1/grainweight/la", "");
        //Convert the result into json format
        JSONObject object = JSONObject.parseObject(str);
        JSONObject object1=  (JSONObject) object.get("m2m:cin");
        ult = (String)object1.get("con");
        System.out.println("ult"+ult+"获取成功。");
        cn.hutool.json.JSONObject jsonObject = new cn.hutool.json.JSONObject();

        //Water storage
        String water1 =get111("http://192.168.209.14:8090/~/s|erver/server/mydevice1/waterHigh/la", "");
        //Convert the result into json format
        JSONObject waterobject = JSONObject.parseObject(water1);
        JSONObject waterobject1=  (JSONObject) waterobject.get("m2m:cin");
        water = (String)waterobject1.get("con");
        System.out.println("water"+water+"获取成功。");

        //Temperature and humidity
        String temp1 = get111("http://192.168.209.14:8090/~/server/server/mydevice1/temperature/la", "");
        JSONObject tempobject = JSONObject.parseObject(temp1);
        JSONObject tempobject1=  (JSONObject) tempobject.get("m2m:cin");
        String temp = (String)tempobject1.get("con");
        System.out.println("temp"+temp+"获取成功。");

        String[] split = temp.split("\\+");
        for (int i = 0; i < split.length; i++) {
            if (i==0){
                tem = split[0];
            }
            else if (i==1){
                hum = split[1];
            }
        }

        System.out.println(tem+"==="+hum);

        jsonObject.set("ult", ult);
        jsonObject.set("water", water);
        jsonObject.set("tem", tem);
        jsonObject.set("hum", hum);

        return jsonObject;
    }

//    @PostMapping
//    public Result<?> save(@RequestBody Notice notice) {
//        notice.setContent(ult);
//        return Result.success(noticeService.save(notice));
//    }
//    @PutMapping
//    public Result<?> update(@RequestBody Notice notice) {
//        return Result.success(noticeService.updateById(notice));
//    }



    public static String get111(String path, String data) {
        String str = "";
        String str1="";
        try {
            URL url = new URL(path);
            //Open the connection with the url
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            PrintWriter out = null;

            /**Set URLConnection parameters and common request attributes****start***/

            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
            conn.setRequestProperty("Accept","application/json");
            conn.setRequestProperty("X-M2M-Origin", "admin:admin");
            /**Set URLConnection parameters and common request attributes****end***/

            //Set whether to output to httpUrlConnection, set whether to read in from httpUrlConnection,
            // in addition to sending post requests, these two must be set

            //The most commonly used Http requests are nothing more than get and post.
            // Get requests can obtain static pages, or put parameters after the URL string and pass them to the servlet.

            //The difference between post and get is that the parameters of post are not placed in the URL string,
            // but placed in the body of the http request.
            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.setRequestMethod("GET");//GET和POST必须全大写
            /**GET method request*****start*/
            /**
             * If you just send a GET request, use the connet method to establish
             * an actual connection with the remote resource；
             * If you send a POST request, you need to obtain the output stream
             * corresponding to the URLConnection instance to send the request parameters.
             * */
            conn.connect();

            /**GET Method request*****end*/


            //Get the input stream corresponding to the URLConnection object
            InputStream is = conn.getInputStream();
            //Construct a character stream cache
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            while ((str = br.readLine()) != null) {
                //Solve the Chinese garbled problem
                str = new String(str.getBytes(), "UTF-8");
                //Str here is the acquired data
                str1=str1+str;
//                System.out.println(str);
            }

            //Close stream
            is.close();
            //Disconnect, it is best to write, disconnect is to cut off when the underlying tcp socket link is idle.
            // If it is being used by other threads, it will not be cut off.
            //If you have fixed multi-threading, if you don't disconnect, the link will increase until you can't
            // send and receive information. After writing disconnect, it will be normal.
            conn.disconnect();
            System.out.println("完整结束");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return str1;
    }

}
