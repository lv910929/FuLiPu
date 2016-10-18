package com.lv.fulipu.ui;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.lv.fulipu.R;
import com.lv.fulipu.ui.base.BaseActivity;
import com.lv.fulipu.utils.ActivityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends BaseActivity {

    @BindView(R.id.image_splash_logo)
    ImageView imageSplashLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        setStatusBar();
        initUI();
    }

    @Override
    protected void initUI() {
        super.initUI();
        final ScaleAnimation scaleAnim = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnim.setFillAfter(true);
        scaleAnim.setDuration(3000);
        scaleAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ActivityUtil.startActivityWithFinish(SplashActivity.this, MainActivity.class, null);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageSplashLogo.startAnimation(scaleAnim);
    }
}
