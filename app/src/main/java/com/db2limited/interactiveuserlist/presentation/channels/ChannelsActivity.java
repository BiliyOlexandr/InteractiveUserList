package com.db2limited.interactiveuserlist.presentation.channels;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.db2limited.interactiveuserlist.R;
import com.db2limited.interactiveuserlist.model.Channel;
import com.db2limited.interactiveuserlist.presentation.empty.EmptyActivity;
import java.util.List;

public class ChannelsActivity extends AppCompatActivity implements ChannelsView {

  private ChannelsAdapter mChannelsAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_channels);

    // View Pager needs for switching to views
    ViewPager mViewPager = (ViewPager) findViewById(R.id.channels_pager);
    ChatsAdapter pagerAdapter = new ChatsAdapter(this);
    pagerAdapter.addView(getString(R.string.chats), R.layout.chats_view);
    pagerAdapter.addView(getString(R.string.live_chats), R.layout.live_chats_view);

    mViewPager.setAdapter(pagerAdapter);

    TabLayout tabLayout = (TabLayout) findViewById(R.id.channels_tabs);
    tabLayout.setupWithViewPager(mViewPager);

    // Add nome button and set title to actionbar
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setHomeButtonEnabled(true);
      actionBar.setDisplayHomeAsUpEnabled(true);
    }

    ChannelsPresenter mChannelsPresenter = new ChannelsPresenter(this);

    mChannelsAdapter = new ChannelsAdapter();

    mChannelsPresenter.fetchChannels();

    View view = getLayoutInflater().inflate(R.layout.chats_view, null);
    RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_channels);
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.setAdapter(mChannelsAdapter);
  }

  // Call adapter method for update channels list
  @Override public void onChannelsFetched(List<Channel> channelList) {
    mChannelsAdapter.updateChannels(channelList);
  }
  // Needs for setting elements to Menu
  @Override public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  // Return to home activity and go to empty activity
  @Override public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        finish();
        return true;

      case R.id.new_chat:
        startActivity(new Intent(this, EmptyActivity.class));
        return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
