package xyz.arkarhein.news.activities;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.news.MMNewsApp;
import xyz.arkarhein.news.R;
import xyz.arkarhein.news.adapters.ImagesInNewsDetailsAdapter;
import xyz.arkarhein.news.data.model.NewsModel;
import xyz.arkarhein.news.data.vo.NewsVO;
import xyz.arkarhein.news.events.LoadedNewsEvent;

/**
 * Created by Arkar Hein on 12/9/2017.
 */

public class NewsDetailsActivity extends AppCompatActivity {




    @BindView(R.id.tv_news_black_panther)
    TextView tvNewsDetailInfo;

    @BindView(R.id.iv_eleven_logo)
    ImageView ivNewsLogo;

    @BindView(R.id.tv_eleven_name)
    TextView tvLogoName;

    @BindView(R.id.tv_eleven_date)
    TextView tvPostedDate;

    @BindView(R.id.news_details_toolbar)
    Toolbar toolbar;

    @BindView(R.id.vp_news_details_images)
    ViewPager vpNewsDetailsImages;

    private ImagesInNewsDetailsAdapter mImagesInNewsDetailsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this, this);

        /*setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);*/

        mImagesInNewsDetailsAdapter = new ImagesInNewsDetailsAdapter();
        vpNewsDetailsImages.setAdapter(mImagesInNewsDetailsAdapter);
        String newsId= getIntent().getStringExtra("news_id");
        NewsVO news = NewsModel.getsObjInstance().getNewsById(newsId);
        bindData(news);
    }

    private void bindData(NewsVO news){
        tvNewsDetailInfo.setText(news.getDetails());
        Glide.with(ivNewsLogo.getContext())
                .load(news.getPublication().getLogo())
                .into(ivNewsLogo);
        tvLogoName.setText(news.getPublication().getTitle());
        tvPostedDate.setText(news.getPostedDate());
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onLoadImage(LoadedNewsEvent event){
        Log.d(MMNewsApp.LOG_TAG,"onImageLoaded"+event.getNewsList().size());
        mImagesInNewsDetailsAdapter.setImage(event.getNewsList());
    }




}
