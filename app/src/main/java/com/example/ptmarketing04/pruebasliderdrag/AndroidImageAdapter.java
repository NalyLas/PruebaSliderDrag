package com.example.ptmarketing04.pruebasliderdrag;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

/**
 * Created by ptmarketing04 on 17/05/2017.
 */

public class AndroidImageAdapter extends PagerAdapter {

    Context mContext;

    AndroidImageAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return sliderImagesId.length;
    }

    private int[] sliderImagesId = new int[]{
            R.drawable.bgalaxy, R.drawable.bgaming, R.drawable.bhp
    };

    @Override
    public boolean isViewFromObject(View v, Object obj) {
        return v == ((ImageSwitcher) obj);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int i) {
        ImageSwitcher mImageSwitcher = new ImageSwitcher(mContext);
        mImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            public View makeView() {
                return new ImageView(mContext);
            }
        });
        // Set animations
        Animation fadeIn = AnimationUtils.loadAnimation(mContext, R.anim.fade_in);
        Animation fadeOut = AnimationUtils.loadAnimation(mContext, R.anim.fade_out);
        mImageSwitcher.setInAnimation(fadeIn);
        mImageSwitcher.setOutAnimation(fadeOut);
        mImageSwitcher.setImageResource(sliderImagesId[i]);

        container.addView(mImageSwitcher,0);
        return mImageSwitcher;



     /*   ImageView mImageView = new ImageView(mContext);
        mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        mImageView.setImageResource(sliderImagesId[i]);
        container.addView(mImageView, 0);
        return mImageView;*/
    }


    @Override
    public void destroyItem(ViewGroup container, int i, Object obj) {
        container.removeView((ImageSwitcher) obj);
    }



}
