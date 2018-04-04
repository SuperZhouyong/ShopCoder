package com.intention.sqtwin.ui.main.activity.fragment;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.intention.sqtwin.R;
import com.intention.sqtwin.app.AppConstant;
import com.intention.sqtwin.ui.main.activity.LoginActivity;
import com.intention.sqtwin.ui.main.activity.MainActivity;
import com.intention.sqtwin.utils.conmonUtil.SPUtils;
import com.intention.sqtwin.utils.conmonUtil.UserUtil;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/4/25 0025.
 */

public class FragmentThree extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mContentView = inflater.inflate(R.layout.three_layout, null);
        ImageView ivOnew = (ImageView) mContentView.findViewById(R.id.iv_3);
        ivOnew.setImageBitmap(BitmapFactory.decodeResource(getResources(),R.mipmap.splash3,getBitmapOption()));
        mContentView.findViewById(R.id.bt_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SPUtils.setSharedBooleanData(getContext(), AppConstant.isFirstStart, true);

                startActivity(new Intent(getActivity(), MainActivity.class));
                getActivity().finish();

            }
        });
//        ButterKnife.bind(this, mContentView);
        return mContentView;
    }

  /*  @OnClick(R.id.bt_next)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_next:

                break;
        }
    }*/
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
