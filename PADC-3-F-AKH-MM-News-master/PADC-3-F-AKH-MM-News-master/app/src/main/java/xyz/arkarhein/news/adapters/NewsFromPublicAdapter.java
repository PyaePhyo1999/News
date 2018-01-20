package xyz.arkarhein.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import xyz.arkarhein.news.R;
import xyz.arkarhein.news.viewholders.ItemNewsFromPublic;

/**
 * Created by Acer on 1/19/2018.
 */

public class NewsFromPublicAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_news_from_public,parent,false);
        ItemNewsFromPublic itemNewsFromPublic = new ItemNewsFromPublic(view);
        return itemNewsFromPublic;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
