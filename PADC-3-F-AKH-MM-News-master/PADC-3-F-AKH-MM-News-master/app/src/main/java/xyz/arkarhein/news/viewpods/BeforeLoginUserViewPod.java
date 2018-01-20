package xyz.arkarhein.news.viewpods;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.arkarhein.news.R;
import xyz.arkarhein.news.delegates.BeforeLoginDelegate;

/**
 * Created by Acer on 1/20/2018.
 */

public class BeforeLoginUserViewPod extends RelativeLayout {
    private BeforeLoginDelegate mDelegate;

    public void setmDelegate(BeforeLoginDelegate delegate){
        mDelegate = delegate;
    }

    public BeforeLoginUserViewPod(Context context) {
        super(context);
    }

    public BeforeLoginUserViewPod(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BeforeLoginUserViewPod(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }

    @OnClick(R.id.btn_to_login)
    public void onTapLogin(View view){
        mDelegate.onTapLogin();


    }
    @OnClick(R.id.btn_to_register)
    public void onTapRegister(View view){
        mDelegate.onTapRegister();
    }

}
