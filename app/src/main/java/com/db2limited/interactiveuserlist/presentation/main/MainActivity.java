package com.db2limited.interactiveuserlist.presentation.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import com.db2limited.interactiveuserlist.R;
import com.db2limited.interactiveuserlist.presentation.channels.ChannelsActivity;

public class MainActivity extends AppCompatActivity implements MainView {

  private MainPresenter mMainPresenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mMainPresenter = new MainPresenter(this);
    Button mButton = (Button) findViewById(R.id.start_button);
    mButton.setOnClickListener(v -> mMainPresenter.onStartClicked());
  }

  @Override public void navigateToChannels() {
    Intent intent = new Intent(this, ChannelsActivity.class);
    startActivity(intent);
  }
}
