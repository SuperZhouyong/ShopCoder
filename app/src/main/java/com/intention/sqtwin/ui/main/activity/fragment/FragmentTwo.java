package com.intention.sqtwin.ui.main.activity.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.intention.sqtwin.R;

/**
 * Created by Administrator on 2017/4/25 0025.
 */

public class FragmentTwo extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mContentView = inflater.inflate(R.layout.two_layout, null);
        ImageView ivOnew = (ImageView) mContentView.findViewById(R.id.iv_2);
        ivOnew.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.splash2,getBitmapOption()));
        return mContentView;
    }
    private BitmapFactory.Options getBitmapOption() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inJustDecodeBounds = false;
        options.inDither = false;
        options.inScaled = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = 1;
        return options;
    }
}
