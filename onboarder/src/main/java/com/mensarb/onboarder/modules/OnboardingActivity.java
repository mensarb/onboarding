package com.mensarb.onboarder.modules;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import com.mensarb.onboarder.R;
import com.mensarb.onboarder.adapter.PageAdapter;
import com.mensarb.onboarder.animation.FlowingFrame;
import com.mensarb.onboarder.animation.FlowingGradient;
import com.mensarb.onboarder.animation.FlowingHelper;
import com.mensarb.onboarder.models.Page;
import com.mensarb.onboarder.view.CircleIndicatorView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dkoller
 * @since 18.10.2017
 */

public abstract class OnboardingActivity extends AppCompatActivity implements View.OnClickListener,
        ViewPager.OnPageChangeListener {

    protected ConstraintLayout root;
    protected ImageView backgroundImage;
    protected ViewPager viewPager;
    protected FrameLayout bottomLayout;
    protected CircleIndicatorView circleIndicatorView;
    protected ImageView previous;
    protected ImageView next;

    protected List<Page> pages;
    protected PageAdapter pageAdapter;
    protected List<Integer> colors;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        root = findViewById(R.id.root);
        backgroundImage = findViewById(R.id.backgroundImage);
        viewPager = findViewById(R.id.viewpager);
        bottomLayout = findViewById(R.id.bottomLayout);
        circleIndicatorView = findViewById(R.id.circleIndicatorView);
        previous = findViewById(R.id.previous);
        next = findViewById(R.id.next);

        hideActionBar();

        viewPager.addOnPageChangeListener(this);
        previous.setOnClickListener(this);
        next.setOnClickListener(this);

        setPreviousVisibility(false);
    }

    public void setPages(List<Page> pages){
        this.pages = pages;

        pageAdapter = new PageAdapter(getSupportFragmentManager(), pages);
        viewPager.setAdapter(pageAdapter);
        circleIndicatorView.setPageIndicators(pages.size());
    }

    /**
     * =============================================================================================
     * Layout
     *  =============================================================================================
     */

    private void hideActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }

    protected void setBackgroundColor(int color){
        root.setBackgroundColor(color);
    }

    protected void setBackgroundColor(List<Integer> colors){
        this.colors = colors;
        if (colors.size()>0) {
            setBackgroundColor(colors.get(0));
        }
    }

    protected void setBackgroundImage(int resourceId, ImageView.ScaleType scaleType){
        backgroundImage.setImageResource(resourceId);
        backgroundImage.setScaleType(scaleType);
    }

    protected void setBackgroundImage(Bitmap image, ImageView.ScaleType scaleType){
        backgroundImage.setImageBitmap(image);
        backgroundImage.setScaleType(scaleType);
    }

    protected void setGradientBackground(){
        setGradientBackground(getDefaultFrames(), 4000);
    }

    protected void setGradientBackground(List<FlowingFrame> frames, int transitionDuration){
        AnimationDrawable animation = new AnimationDrawable();
        for (int i=0; i<frames.size(); i++){
            FlowingFrame frame = frames.get(i);
            animation.addFrame(FlowingHelper.getFrame(frame.getStartColor(), frame.getEndColor()), frame.getDuration());
        }
        animation.setOneShot(false);

        new FlowingGradient()
                .setAnimation(animation)
                .layout(root)
                .setTransitionDuration(transitionDuration)
                .start();
    }

    protected List<FlowingFrame> getDefaultFrames(){
        int defaultDuration = 4000;

        List<FlowingFrame> frames = new ArrayList<>();
        frames.add(new FlowingFrame(Color.parseColor("#D38312"), Color.parseColor("#FF6B6B"), defaultDuration));
        frames.add(new FlowingFrame(Color.parseColor("#e43a15"), Color.parseColor("#d53369"), defaultDuration));
        frames.add(new FlowingFrame(Color.parseColor("#E55D87"), Color.parseColor("#5FC3E4"), defaultDuration));
        frames.add(new FlowingFrame(Color.parseColor("#FFB88C"), Color.parseColor("#DE6262"), defaultDuration));
        frames.add(new FlowingFrame(Color.parseColor("#e96443"), Color.parseColor("#904e95"), defaultDuration));
        frames.add(new FlowingFrame(Color.parseColor("#5f2c82"), Color.parseColor("#49a09d"), defaultDuration));
        frames.add(new FlowingFrame(Color.parseColor("#43cea2"), Color.parseColor("#185a9d"), defaultDuration));
        return frames;
    }

    public void setCircleIndicatorColors(int activeColor, int inactiveColor){
        circleIndicatorView.setActiveIndicatorColor(activeColor);
        circleIndicatorView.setInactiveIndicatorColor(inactiveColor);
    }

    @Override
    public void onClick(View view) {
        int currentPosition = viewPager.getCurrentItem();
        boolean isFirstPage = currentPosition == 0;
        boolean isLastPage = currentPosition == pageAdapter.getCount()-1;

        int id = view.getId();
        if (id == R.id.previous) {
            if (isFirstPage){
                onSkip();
            }else {
                onPrevious();
            }
        } else if (id == R.id.next) {
            if (isLastPage){
                onFinish();
            }else {
                onNext();
            }
        }
    }

    /**
     * =============================================================================================
     * Navigation
     *  =============================================================================================
     */

    protected void onPrevious(){
        viewPager.setCurrentItem(viewPager.getCurrentItem()-1);
    }

    protected void onNext(){
        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
    }

    protected void onSkip(){
        viewPager.setCurrentItem(pageAdapter.getCount()-1);
    }

    protected void onFinish(){
        finish();
    }

    protected void setPreviousVisibility(boolean visibility){
        if (visibility){
            previous.setVisibility(View.VISIBLE);
        }else {
            previous.setVisibility(View.GONE);
        }
    }

    /**
     * =============================================================================================
     * Viewpager
     *  =============================================================================================
     */

    @Override
    public void onPageScrolled(int position, float v, int i1) {

    }

    @Override
    public void onPageSelected(int position) {
        circleIndicatorView.setCurrentPage(position);

        if (colors != null && position<colors.size()){
            setBackgroundColor(colors.get(position));
        }

        int firstPosition = 0;
        int lastPosition = pageAdapter.getCount()-1;

        // TODO: 19.10.2017 change button images?

        if (position == firstPosition){
            //skip button
            setPreviousVisibility(false);
        }else if (position == lastPosition){
            //finish button
            setPreviousVisibility(true);
        }else {
            setPreviousVisibility(true);
        }
    }

    @Override
    public void onPageScrollStateChanged(int position) {

    }
}
