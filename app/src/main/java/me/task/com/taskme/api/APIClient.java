package me.task.com.taskme.api;

import java.io.IOException;

import me.task.com.taskme.helper.SharedPrefManager;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 2/2/18.
 */

public class APIClient {

    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {

//            OkHttpClient httpClient = new OkHttpClient.Builder()
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        public okhttp3.Response intercept(Chain chain) throws IOException {
//                            Request.Builder ongoing = chain.request().newBuilder();
//                            ongoing.addHeader("Accept", "application/json;versions=1");
//                            if (SharedPrefManager.getInstance(getActivity().getApplicationContext()).isLoggedIn()) {
//                                ongoing.addHeader("Authorization", "token " + SharedPrefManager.getInstance(getActivity().getApplicationContext()).getUserToken());
//                            }
//                            return chain.proceed(ongoing.build());
//                        }
//                    })
//                    .build();
//            .client(httpClient)
            retrofit = new Retrofit.Builder()
                    .baseUrl(APIUrl.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())

                    .build();
        }
        return retrofit;
    }
}
