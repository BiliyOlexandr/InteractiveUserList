package com.db2limited.interactiveuserlist.presentation.channels;

import com.db2limited.interactiveuserlist.model.Channel;
import java.util.List;


interface ChannelsView {

  void onChannelsFetched(List<Channel> channelList);
}
