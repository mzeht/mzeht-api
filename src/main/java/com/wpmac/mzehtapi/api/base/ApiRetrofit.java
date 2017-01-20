/*
* Copyright (c) 2017 mzeht. All Rights Reserved.
*/
package com.wpmac.mzehtapi.api.base;

import com.wpmac.mzehtapi.api.CommonApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.annotation.PostConstruct;

/**
 * @author: wpmac  Date: 2017/1/17 Time: 上午10:58
 */
@Component
public class ApiRetrofit {

    private static final Logger log = Logger.getLogger(ApiRetrofit.class);

    private CommonApi commonApi;

    public CommonApi getCommonApi() {
        return commonApi;
    }

    @Value("${api.common}")
    private  String COMMON_BASE_URL ;//= "http://10.10.168.79:10100/";

    @PostConstruct
    public void init(){
        HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor(new HttpLogger());
        logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addNetworkInterceptor(logInterceptor)
                .build();

        Retrofit retrofit_common = new Retrofit.Builder()
                .baseUrl(COMMON_BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        commonApi = retrofit_common.create(CommonApi.class);

    }


    private class HttpLogger implements HttpLoggingInterceptor.Logger {
//        private StringBuilder mMessage = new StringBuilder();

        @Override
        public void log(String message) {
            log.info(message);
//
//            if (message.startsWith("--> POST")) {
//                mMessage.setLength(0);
//                mMessage.append("\n");
//            }
//            // 以{}或者[]形式的说明是响应结果的json数据，需要进行格式化
//            if ((message.startsWith("{") && message.endsWith("}"))
//                    || (message.startsWith("[") && message.endsWith("]"))) {
//                message = JSONUtil.formatJson(message);
//            }
//            mMessage.append(message.concat("\n"));
//            // 请求或者响应结束，打印整条日志
//            if (message.startsWith("<-- END HTTP")) {
//                log.info(mMessage.toString());
//            }

        }
    }
}