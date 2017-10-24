package com.db2limited.interactiveuserlist.presentation.channels;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

class ChatsAdapter extends PagerAdapter {
  private final List<Integer> mViewList;
  private final List<String> mTitleList;
  private Context mContext;

  ChatsAdapter(Context context) {
    mContext = context;
    mViewList = new ArrayList<>();
    mTitleList = new ArrayList<>();
  }

  void addView(String viewTitle, int viewId) {
    mViewList.add(viewId);
    mTitleList.add(viewTitle);
  }

  @Override public Object instantiateItem(ViewGroup container, int position) {
    LayoutInflater inflater = LayoutInflater.from(mContext);
    ViewGroup layout = (ViewGroup) inflater.inflate(mViewList.get(position), container, false);
    container.addView(layout);
    return layout;
  }

  @Override public void destroyItem(ViewGroup container, int position, Object object) {
    container.removeView((View) object);
  }

  @Override public CharSequence getPageTitle(int position) {
    return mTitleList.get(position);
  }

  @Override public int getCount() {
    return mViewList.size();
  }

  @Override public boolean isViewFromObject(View view, Object object) {
    return view.equals(object);
  }
}