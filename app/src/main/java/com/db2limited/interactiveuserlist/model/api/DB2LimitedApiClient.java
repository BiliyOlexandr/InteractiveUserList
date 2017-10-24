package com.db2limited.interactiveuserlist.model.api;

import com.db2limited.interactiveuserlist.model.Channels;
import io.reactivex.Observable;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DB2LimitedApiClient {

  private static final String URL = "https://iostest.db2dev.com";
  private static final String LOGIN = "iostest";
  private static final String PASSWORD = "iostest2k17!";
  private DB2LimitedApi mApiInterface;

  public DB2LimitedApiClient() {
    // Create client for authorization and build request
    OkHttpClient okHttpClient = new OkHttpClient().newBuilder().addInterceptor(chain -> {
      Request originalRequest = chain.request();
      Request.Builder builder =
          originalRequest.newBuilder().header("Authorization", Credentials.basic(LOGIN, PASSWORD));
      Request newRequest = builder.build();
      return chain.proceed(newRequest);
    }).build();
    Retrofit retrofit = new Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .build();
    mApiInterface = retrofit.create(DB2LimitedApi.class);
  }

  // Get needs information from server
  public Observable<Channels> getChannels() {

    return mApiInterface.getChannels();
  }
}
