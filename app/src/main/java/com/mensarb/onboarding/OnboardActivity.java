package com.mensarb.onboarding;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.mensarb.onboarder.models.Page;
import com.mensarb.onboarder.modules.OnboardingActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dkoller
 * @since 18.10.2017
 */

public class OnboardActivity extends OnboardingActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
        List<Integer> backgroundColors = new ArrayList<>();
        backgroundColors.add(ContextCompat.getColor(this, R.color.primary));
        backgroundColors.add(ContextCompat.getColor(this, R.color.primary_dark));
        backgroundColors.add(ContextCompat.getColor(this, R.color.primary_light));
        backgroundColors.add(ContextCompat.getColor(this, R.color.colorAccent));

        //setBackgroundColor(backgroundColors);
        //setBackgroundImage(R.drawable.girl, ImageView.ScaleType.CENTER_CROP);
        setGradientBackground();

        Page page1 = new Page.Builder()
                .backgroundColor(ContextCompat.getColor(this, R.color.black_transparent_image))
                .image(R.drawable.boat)
                .title("Boat")
                .titleColor(ContextCompat.getColor(this, R.color.colorPrimary))
                .description(getString(R.string.lipsum_short))
                .descriptionColor(ContextCompat.getColor(this, R.color.grey_200))
                .build();

        Page page2 = new Page.Builder()
                .image(R.drawable.beach)
                .imageHeight(150)
                .backgroundColor(ContextCompat.getColor(this, R.color.black_transparent))
                .title("Beach")
                .titleColor(ContextCompat.getColor(this, R.color.accent))
                .titleTextSize(32)
                .description(getString(R.string.lipsum_long))
                .descriptionColor(ContextCompat.getColor(this, R.color.grey_200))
                .descriptionTextSize(16)
                .build();

        Page page3 = new Page.Builder()
                .image(R.drawable.swimsuit)
                .backgroundColor(ContextCompat.getColor(this, R.color.primary_light))
                .title("Swimsuit")
                .titleColor(ContextCompat.getColor(this, R.color.primary_text))
                .description(getString(R.string.lipsum_short))
                .descriptionColor(ContextCompat.getColor(this, R.color.secondary_text))
                .build();

        Page page4 = new Page.Builder()
                .image("\uEB3E", ContextCompat.getColor(this, R.color.primary_light), 64, "materialicons_regular.ttf")
                .backgroundColor(ContextCompat.getColor(this, R.color.white))
                .title("IconFont")
                .titleColor(ContextCompat.getColor(this, R.color.black))
                .description("uses font in asset folder")
                .descriptionColor(ContextCompat.getColor(this, R.color.black))
                .build();

        Page page5 = new Page.Builder()
                .image("\uEB3E", ContextCompat.getColor(this, R.color.primary_light), 64, R.font.materialicons_regular)
                .backgroundColor(ContextCompat.getColor(this, R.color.white))
                .title("IconFont")
                .titleColor(ContextCompat.getColor(this, R.color.black))
                .description("uses font in res/font folder")
                .descriptionColor(ContextCompat.getColor(this, R.color.black))
                .build();

        List<Page> pages = new ArrayList<>();
        pages.add(page1);
        pages.add(page2);
        pages.add(page3);
        pages.add(page4);
        pages.add(page5);

        setPages(pages);
    }
}
