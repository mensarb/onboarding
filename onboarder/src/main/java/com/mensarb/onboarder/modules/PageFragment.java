package com.mensarb.onboarder.modules;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.FontRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mensarb.onboarder.R;
import com.mensarb.onboarder.models.Page;

/**
 * @author dkoller
 * @since 18.10.2017
 */

public class PageFragment extends Fragment {

    private static final String PAGE_BACKGROUND_COLOR = "pageBackgroundColor";

    private static final String PAGE_IMAGE = "pageImage";
    private static final String PAGE_IMAGE_HEIGHT = "pageImageHeight";
    private static final String PAGE_IMAGE_ICON = "pageImageIcon";
    private static final String PAGE_IMAGE_ICON_COLOR = "pageImageIconColor";
    private static final String PAGE_IMAGE_ICON_TEXT_SIZE = "pageImageIconTextSize";
    private static final String PAGE_IMAGE_ICON_TYPEFACE_RESOURCE = "pageImageIconTypefaceResource";
    private static final String PAGE_IMAGE_ICON_TYPEFACE_ASSET = "pageImageIconTypefaceAsset";

    private static final String PAGE_TITLE = "pageTitle";
    private static final String PAGE_TITLE_COLOR = "pageTitleColor";
    private static final String PAGE_TITLE_TEXT_SIZE = "pageTitleTextSize";
    private static final String PAGE_DESCRIPTION = "pageDescription";
    private static final String PAGE_DESCRIPTION_COLOR = "pageDescriptionColor";
    private static final String PAGE_DESCRIPTION_TEXT_SIZE = "pageDescriptionTextSize";


    public static PageFragment getNewInstance(Page page){
        Bundle bundle = new Bundle();
        bundle.putInt(PAGE_BACKGROUND_COLOR, page.getBackgroundColor());
        bundle.putInt(PAGE_IMAGE, page.getImage());
        bundle.putInt(PAGE_IMAGE_HEIGHT, page.getImageHeight());
        bundle.putString(PAGE_IMAGE_ICON, page.getImageIcon());
        bundle.putInt(PAGE_IMAGE_ICON_COLOR, page.getImageIconColor());
        bundle.putFloat(PAGE_IMAGE_ICON_TEXT_SIZE, page.getImageIconTextSize());
        bundle.putInt(PAGE_IMAGE_ICON_TYPEFACE_RESOURCE, page.getImageIconTypefaceResource());
        bundle.putString(PAGE_IMAGE_ICON_TYPEFACE_ASSET, page.getImageIconTypefaceAsset());
        bundle.putString(PAGE_TITLE, page.getTitle());
        bundle.putInt(PAGE_TITLE_COLOR, page.getTitleColor());
        bundle.putFloat(PAGE_TITLE_TEXT_SIZE, page.getTitleTextSize());
        bundle.putString(PAGE_DESCRIPTION, page.getDescription());
        bundle.putInt(PAGE_DESCRIPTION_COLOR, page.getDescriptionColor());
        bundle.putFloat(PAGE_DESCRIPTION_TEXT_SIZE, page.getDescriptionTextSize());

        PageFragment fragment = new PageFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, container, false);

        CardView cardView = view.findViewById(R.id.cardView);
        ImageView image = view.findViewById(R.id.image);
        TextView imageIcon = view.findViewById(R.id.imageIcon);
        TextView title = view.findViewById(R.id.title);
        TextView description = view.findViewById(R.id.description);

        boolean showImage = false;

        Bundle bundle = getArguments();
        if (bundle != null){
            int backgroundColor = bundle.getInt(PAGE_BACKGROUND_COLOR);
            if (backgroundColor != 0){
                cardView.setCardBackgroundColor(backgroundColor);
            }


            @FontRes int fontRes = bundle.getInt(PAGE_IMAGE_ICON_TYPEFACE_RESOURCE, -1);
            String fontName = bundle.getString(PAGE_IMAGE_ICON_TYPEFACE_ASSET);

            showImage = fontRes != -1 && fontName == null;

            int imageHeight = bundle.getInt(PAGE_IMAGE_HEIGHT);
            if (showImage){
                image.setImageResource(bundle.getInt(PAGE_IMAGE));
                if (imageHeight != 0){
                    image.getLayoutParams().height = (int) dpToPixels(imageHeight);
                }
            }else {
                imageIcon.setText(bundle.getString(PAGE_IMAGE_ICON));
                imageIcon.setTextColor(bundle.getInt(PAGE_IMAGE_ICON_COLOR));
                imageIcon.setTextSize(bundle.getFloat(PAGE_IMAGE_ICON_TEXT_SIZE));

                Typeface typeface;
                if (fontName != null){
                    typeface = Typeface.createFromAsset(getContext().getAssets(), fontName);
                }else {
                    typeface = ResourcesCompat.getFont(getActivity(), fontRes);
                }
                imageIcon.setTypeface(typeface);

                if (imageHeight != 0){
                    imageIcon.getLayoutParams().height = (int) dpToPixels(imageHeight);
                }
            }

            title.setText(bundle.getString(PAGE_TITLE));
            int titleColor = bundle.getInt(PAGE_TITLE_COLOR);
            if (titleColor != 0) {
                title.setTextColor(titleColor);
            }
            float titleTextSize = bundle.getFloat(PAGE_TITLE_TEXT_SIZE);
            if (titleTextSize != 0) {
                title.setTextSize(titleTextSize);
            }

            description.setText(bundle.getString(PAGE_DESCRIPTION));
            int descriptionColor = bundle.getInt(PAGE_DESCRIPTION_COLOR);
            if (descriptionColor != 0) {
                description.setTextColor(descriptionColor);
            }
            float descriptionTextSize = bundle.getFloat(PAGE_DESCRIPTION_TEXT_SIZE);
            if (descriptionTextSize != 0){
                description.setTextSize(descriptionTextSize);
            }
        }

        if (showImage){
            image.setVisibility(View.VISIBLE);
            imageIcon.setVisibility(View.GONE);
        }else {
            image.setVisibility(View.GONE);
            imageIcon.setVisibility(View.VISIBLE);
        }

        return view;
    }

    private float dpToPixels(int dp) {
        return dp * getContext().getResources().getDisplayMetrics().density;
    }
}
