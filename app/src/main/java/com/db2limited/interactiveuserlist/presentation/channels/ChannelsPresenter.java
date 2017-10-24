package com.db2limited.interactiveuserlist.presentation.channels;

import com.db2limited.interactiveuserlist.model.api.DB2LimitedApiClient;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

class ChannelsPresenter {

  private ChannelsView mChannelsView;
  private DB2LimitedApiClient mDB2LimitedApiClient;

  ChannelsPresenter(ChannelsView channelsView) {
    mChannelsView = channelsView;
    mDB2LimitedApiClient = new DB2LimitedApiClient();
  }

  void fetchChannels() {
    mDB2LimitedApiClient.getChannels()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(channels -> mChannelsView.onChannelsFetched(channels.getChannels()),
            Throwable::printStackTrace);


    /* This code need for check to failure

    final DB2LimitedApi api = mDB2LimitedApiClient.getChannels();
    Call<Channels> call = api.getChannels();

    call.enqueue(new Callback<Channels>() {
      @Override public void onResponse(@NonNull Call<Channels> call, @NonNull Response<Channels> response) {
        List<Channel> channelsList = new ArrayList<>();
        channelsList.add(response.body().getChannels().get(0));
        mChannelsView.onChannelsFetched(channelsList);
      }

      @Override public void onFailure(@NonNull Call<Channels> call, @NonNull Throwable t) {
        Log.e("ErrorResponseBody", t.getMessage());
      }
    });*/

  }
}
