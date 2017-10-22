package com.db2limited.interactiveuserlist.presentation.channels;

import com.db2limited.interactiveuserlist.model.api.DB2LimitedApiClient;
import io.reactivex.Observable;

public class ChannelsPresenter {

  private ChannelsView mChannelsView;
  private DB2LimitedApiClient mDB2LimitedApiClient;

  ChannelsPresenter(ChannelsView channelsView){
    mChannelsView = channelsView;
    mDB2LimitedApiClient = new DB2LimitedApiClient();
  }

}
