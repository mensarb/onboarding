package com.mensarb.onboarder.adapter;

import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.mensarb.onboarder.models.Page;
import com.mensarb.onboarder.modules.PageFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dkoller
 * @since 18.10.2017
 */

public class PageAdapter extends FragmentStatePagerAdapter {

    private List<Page> pages = new ArrayList<>();
    private List<PageFragment> fragments = new ArrayList<>();

    public PageAdapter(FragmentManager fm, List<Page> pages) {
        super(fm);
        this.pages = pages;

        addPages(pages);
    }

    private void addPages(List<Page> pages){
        for (int i=0; i<pages.size(); i++) {
            fragments.add(PageFragment.getNewInstance(pages.get(i)));
        }
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }
}
