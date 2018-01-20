package xyz.arkarhein.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.arkarhein.news.R;
import xyz.arkarhein.news.viewholders.ItemSportsNewsViewHolder;

/**
 * Created by Acer on 1/11/2018.
 */

public class SportsNewsAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.items_sports_news,parent,false);
        ItemSportsNewsViewHolder itemSportsNewsViewHolder = new ItemSportsNewsViewHolder(view);
        return itemSportsNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
