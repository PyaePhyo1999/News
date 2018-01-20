package xyz.arkarhein.news.viewholders;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.arkarhein.news.R;
import xyz.arkarhein.news.adapters.NewsFromPublicAdapter;

/**
 * Created by Acer on 1/12/2018.
 */

public class ItemInternationalNewsViewHolder extends RecyclerView.ViewHolder {
    Context context;

    @BindView(R.id.rv_news_from_public)
    RecyclerView rvNewsFromPublic;

    public NewsFromPublicAdapter mNewsFromPublicAdapter;

    public ItemInternationalNewsViewHolder(View itemView)
    {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mNewsFromPublicAdapter = new NewsFromPublicAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext(),LinearLayoutManager.HORIZONTAL,false);
        rvNewsFromPublic.setLayoutManager(linearLayoutManager);
        rvNewsFromPublic.setAdapter(mNewsFromPublicAdapter);
    }




}
