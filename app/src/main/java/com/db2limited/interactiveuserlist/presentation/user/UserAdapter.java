package com.db2limited.interactiveuserlist.presentation.user;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.db2limited.interactiveuserlist.R;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder>{

  @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return null;
  }

  @Override public void onBindViewHolder(ViewHolder holder, int position) {

  }

  @Override public int getItemCount() {
    return 0;
  }

  //Data is sent through constructor
  static class ViewHolder extends RecyclerView.ViewHolder{
    private final ImageView mImageUser;
    private final TextView mNameUser;
    private final TextView mMessageUser;
    private final TextView mDateUser;
    private final TextView mNoChekMessage;
    ViewHolder(View itemView){
      super(itemView);
      mImageUser = (ImageView)itemView.findViewById(R.id.user_image_view);
      mNameUser = (TextView)itemView.findViewById(R.id.user_name_text_view);
      mMessageUser = (TextView)itemView.findViewById(R.id.user_message_text_view);
      mDateUser = (TextView)itemView.findViewById(R.id.user_date_text_view);
      mNoChekMessage = (TextView)itemView.findViewById(R.id.message_no_check_text_view);
    }
  }
}
