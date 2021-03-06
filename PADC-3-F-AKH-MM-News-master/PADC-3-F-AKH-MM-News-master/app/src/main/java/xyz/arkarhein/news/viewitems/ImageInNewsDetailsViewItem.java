package xyz.arkarhein.news.viewitems;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.news.R;
import xyz.arkarhein.news.data.vo.NewsVO;

/**
 * Created by Arkar Hein on 12/10/2017.
 */

public class ImageInNewsDetailsViewItem extends FrameLayout {

    @BindView(R.id.iv_news_image_detail)
    ImageView ivNewsDetailImage;

    public ImageInNewsDetailsViewItem(@NonNull Context context) {
        super(context);
    }

    public ImageInNewsDetailsViewItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageInNewsDetailsViewItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this,this);
    }
    public void setData(NewsVO image){
        Glide.with(ivNewsDetailImage.getContext())
                .load(image.getImages())
                .into(ivNewsDetailImage);
    }

}
