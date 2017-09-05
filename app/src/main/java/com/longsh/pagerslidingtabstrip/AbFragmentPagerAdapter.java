package com.longsh.pagerslidingtabstrip;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;

/****
 * 页面视频器
 * @author lambert_lei\
 */
public class AbFragmentPagerAdapter extends FragmentPagerAdapter {
	/** The m fragment list. */
	private ArrayList<Fragment> mFragmentList = null;
	private int currentPageIndex = 0;
	private String[] titles=null;

	/**
	 * Instantiates a new ab fragment pager adapter.
	 * @param mFragmentManager the m fragment manager
	 * @param fragmentList the fragment list
	 */
	public AbFragmentPagerAdapter(FragmentManager mFragmentManager, ArrayList<Fragment> fragmentList, String[] titles) {
		super(mFragmentManager);
		mFragmentList = fragmentList;
		this.titles=titles;
	}
	@Override
	public CharSequence getPageTitle(int position) {
		// TODO Auto-generated method stub
		if(titles!=null&&titles.length>0){
			return titles[position];
		}else{return super.getPageTitle(position);}

	}
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(mFragmentList.get(position).getView());
	}
	/**
	 * 页面数
	 *
	 * @return the count
	 * @see android.support.v4.view.PagerAdapter#getCount()
	 */
	@Override
	public int getCount() {
		return mFragmentList.size();
	}

	/**
	 * 获取大每个Fragment.
	 *
	 * @param position the position
	 * @return the item
	 * @see FragmentPagerAdapter#getItem(int)
	 */
	@Override
	public Fragment getItem(int position) {

		Fragment fragment = null;
		if (position < mFragmentList.size()){
			fragment = mFragmentList.get(position);
		}else{
			fragment = mFragmentList.get(0);
		}
		return fragment;

	}
}
