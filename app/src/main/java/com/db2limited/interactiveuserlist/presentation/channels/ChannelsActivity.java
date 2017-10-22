package com.db2limited.interactiveuserlist.presentation.channels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.db2limited.interactiveuserlist.R;

public class ChannelsActivity extends AppCompatActivity implements ChannelsView{

  private ChannelsPresenter mChannelsPresenter;

  private ChannelsAdapter mChannelsAdapter;
  private RecyclerView mRecyclerView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_channels);

    mChannelsPresenter = new ChannelsPresenter(this);
    mChannelsAdapter = new ChannelsAdapter(mChannelsPresenter);

    mRecyclerView = (RecyclerView)findViewById(R.id.channel_rcycler_view);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.setAdapter(mChannelsAdapter);


  }
}
