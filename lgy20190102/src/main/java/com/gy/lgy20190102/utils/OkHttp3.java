package com.gy.lgy20190102.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttp3 {

    private static OkHttpClient okHttpClient;
    private static Request request;

    public static void getHttp(String url, final Httpinterface httpinterface){
        //初始化OkHttpClient
        okHttpClient = new OkHttpClient();
        //初始化request
        request = new Request.Builder().url(url).method("GET", null).build();
        //通过okHttpClient创建call
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //请求成功返回的数据
                    try {
                        httpinterface.ruslt(response.body().string());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
            }
        });
    }
    //创建接口
    public interface Httpinterface{
        //接口方法
        void ruslt(String t);
    }
}
