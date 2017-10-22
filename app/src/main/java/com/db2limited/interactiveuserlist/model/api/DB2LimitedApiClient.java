package com.db2limited.interactiveuserlist.model.api;

import com.db2limited.interactiveuserlist.model.Channels;
import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class DB2LimitedApiClient {

  private static final String URL = "https://iostest.db2dev.com/";

  private DB2LimitedApi mApiInterface;

  public DB2LimitedApiClient() {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
    mApiInterface = retrofit.create(DB2LimitedApi.class);
  }

  public Observable<Channels> getChannels(){
    return mApiInterface.getChannels();
  }
}
