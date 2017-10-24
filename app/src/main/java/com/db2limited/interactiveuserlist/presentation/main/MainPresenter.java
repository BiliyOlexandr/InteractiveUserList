package com.db2limited.interactiveuserlist.presentation.main;

class MainPresenter {
  private MainView mMainView;

  MainPresenter(MainView mainView) {
    mMainView = mainView;
  }

  void onStartClicked() {
    mMainView.navigateToChannels();
  }
}
