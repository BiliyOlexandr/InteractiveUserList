package com.db2limited.interactiveuserlist.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Channels {

  @SerializedName("channels") @Expose private List<Channel> channels = null;

  public List<Channel> getChannels() {
    return channels;
  }
}
