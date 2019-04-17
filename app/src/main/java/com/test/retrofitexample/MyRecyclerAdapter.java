package com.test.retrofitexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.myViewHolder> {

    List<String> titles;
    List<String> thumbImages;
    private LayoutInflater mInflater;
    Context mContext;

    public MyRecyclerAdapter(Context context, List<String> titles, List<String> thumbImages) {
        this.titles = titles;
        this.thumbImages = thumbImages;
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.row_element,
                parent, false);
        return new myViewHolder(mItemView);

    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.tv_title.setText(titles.get(position));
        Glide.with(mContext).load(thumbImages.get(position)).into(holder.iv_thumb);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView iv_thumb;
        TextView tv_title;

        public myViewHolder(View itemView) {
            super(itemView);
            iv_thumb = itemView.findViewById(R.id.iv_thumb);
            tv_title = itemView.findViewById(R.id.tv_title);
        }


        @Override
        public void onClick(View v) {

        }
    }//end inner class
}
