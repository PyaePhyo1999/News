package xyz.arkarhein.news.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.arkarhein.news.MMNewsApp;
import xyz.arkarhein.news.R;
import xyz.arkarhein.news.adapters.NewsAdapter;
import xyz.arkarhein.news.data.model.NewsModel;
import xyz.arkarhein.news.data.vo.NewsVO;
import xyz.arkarhein.news.delegates.BeforeLoginDelegate;
import xyz.arkarhein.news.delegates.NewsActionDelegate;
import xyz.arkarhein.news.events.LoadedNewsEvent;
import xyz.arkarhein.news.viewpods.BeforeLoginUserViewPod;

public class MainActivity extends AppCompatActivity implements NewsActionDelegate,BeforeLoginDelegate {
    @BindView(R.id.navigation_view)
    NavigationView navigationView;

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.rv_news)
    RecyclerView rvNews;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    private NewsAdapter mNewsAdapter = new NewsAdapter(this);
    private BeforeLoginUserViewPod beforeLoginUserViewPod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvNews.setLayoutManager(linearLayoutManager);
        /*GridLayoutManager gridLayoutManager=new GridLayoutManager(getApplicationContext(),2);
        rvNews.setLayoutManager(gridLayoutManager);*/
        rvNews.setAdapter(mNewsAdapter);
        NewsModel.getsObjInstance().loadNews();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.menu_news_by_category){

                    Intent intent = NewsByCategoryActivity.newIntent(getApplicationContext());
                    startActivity(intent);
                    drawerLayout.closeDrawer(GravityCompat.START);

                }

                return false;


            }

        });
        beforeLoginUserViewPod  = (BeforeLoginUserViewPod) navigationView.getHeaderView(0);
        beforeLoginUserViewPod.setmDelegate(this);



        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.all_news);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void onTapFab(View view) {
        Snackbar.make(view, "Replace with your own action - ButterKnife", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onTapNewsItem(NewsVO tappedNews) {
        Intent intent = new Intent(getApplicationContext(), NewsDetailsActivity.class);
        intent.putExtra("news_id", tappedNews.getNewsId());
        startActivity(intent);
    }

    @Override
    public void onTapCommentButton() {

    }

    @Override
    public void onTapSendButton() {

    }

    @Override
    public void onTapFavoriteButton() {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsLoaded(LoadedNewsEvent event) {
        Log.d(MMNewsApp.LOG_TAG, "onNewsLoaded" + event.getNewsList().size());
        mNewsAdapter.setNews(event.getNewsList());
    }

    @Override
    public void onTapLogin() {
        Intent intent = new AccountControlActivity().newIntentLogin(getApplicationContext());
        startActivity(intent);
    }

    @Override
    public void onTapRegister() {
             Intent intent = new AccountControlActivity().newIntentRegister(getApplicationContext());
             startActivity(intent);
    }
}
