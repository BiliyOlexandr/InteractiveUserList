package com.db2limited.interactiveuserlist.model.api;

import com.db2limited.interactiveuserlist.model.Channels;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DB2LimitedApi {

  // Create requests
  @GET("/api/chat/channels/") Observable<Channels> getChannels();
}
