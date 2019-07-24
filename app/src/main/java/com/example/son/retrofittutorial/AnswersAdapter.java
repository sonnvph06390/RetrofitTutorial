package com.example.son.retrofittutorial;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.son.retrofittutorial.model.Item;

import java.util.List;

public class AnswersAdapter extends RecyclerView.Adapter<AnswersAdapter.ViewHolder> {
    private List<Item>mItems;
    private Context context;
    private PostItemListener mItemListener;

    public AnswersAdapter( Context context,List<Item> mItems, PostItemListener postItemListener) {
        this.mItems = mItems;
        this.context = context;
        this.mItemListener = postItemListener;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context=viewGroup.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View postView=inflater.inflate(android.R.layout.simple_list_item_1, viewGroup,false);
        ViewHolder viewHolder=new ViewHolder(postView,this.mItemListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Item item=mItems.get(i);
        TextView textView=viewHolder.titleTv;
        textView.setText(item.getOwner().getDisplayName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView titleTv;
        PostItemListener  mItemListener;

        public ViewHolder(@NonNull View itemView,PostItemListener postItemListener) {
            super(itemView);
            titleTv=itemView.findViewById(android.R.id.text1);
            this.mItemListener=postItemListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Item item=getItem(getAdapterPosition());
            this.mItemListener.onPostClick(item.getAnswerId());
            notifyDataSetChanged();
        }
    }



    public interface PostItemListener{
        void onPostClick(long id);
    }
    public void updateAnswers(List<Item> items) {
        mItems = items;
        notifyDataSetChanged();
    }

    private Item getItem(int adapterPosition) {
        return mItems.get(adapterPosition);
    }
}
