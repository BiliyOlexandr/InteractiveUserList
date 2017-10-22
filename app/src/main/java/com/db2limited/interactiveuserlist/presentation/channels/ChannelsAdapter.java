package com.db2limited.interactiveuserlist.presentation.channels;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.db2limited.interactiveuserlist.R;
import com.db2limited.interactiveuserlist.model.Channel;
import com.db2limited.interactiveuserlist.model.Channels;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ChannelsAdapter extends RecyclerView.Adapter<ChannelsAdapter.ViewHolder> {

  private static final String NO_CHECK_MESSAGE = "1";

  private Channels mChannelList;
  private ChannelsPresenter mChannelsPresenter;

  ChannelsAdapter(ChannelsPresenter userPresenter) {
    mChannelsPresenter = userPresenter;
  }

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
    return new ViewHolder(view);
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {
    Channel channel = mChannelList.getChannels().get(position);

    Picasso.with(holder.itemView.getContext())
        .load(channel.getLastMessage().getSender().getPhoto())
        .placeholder(R.mipmap.ic_launcher)
        .error(R.mipmap.ic_launcher)
        .into(holder.mImageSender);
    holder.mNameSender.setText(
        channel.getLastMessage().getSender().getFirstName() + " " + channel.getLastMessage()
            .getSender()
            .getLastName());
    holder.mMessageSender.setText(channel.getLastMessage().getText());
    holder.mDateSender.setText(channel.getLastMessage().getCreateDate());
    if (!channel.getLastMessage().getIsRead()) {
      holder.mNoChekMessage.setText(NO_CHECK_MESSAGE);
    }
  }

  @Override public int getItemCount() {
    return 0;
  }

  static class ViewHolder extends RecyclerView.ViewHolder {
    private final ImageView mImageSender;
    private final TextView mNameSender;
    private final TextView mMessageSender;
    private final TextView mDateSender;
    private final TextView mNoChekMessage;

    ViewHolder(View itemView) {
      super(itemView);
      mImageSender = (ImageView) itemView.findViewById(R.id.sender_image_view);
      mNameSender = (TextView) itemView.findViewById(R.id.sender_name_text_view);
      mMessageSender = (TextView) itemView.findViewById(R.id.sender_message_text_view);
      mDateSender = (TextView) itemView.findViewById(R.id.sender_date_text_view);
      mNoChekMessage = (TextView) itemView.findViewById(R.id.message_no_check_text_view);
    }
  }
}
