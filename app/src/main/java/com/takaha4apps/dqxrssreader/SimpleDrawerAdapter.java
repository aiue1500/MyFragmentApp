package com.takaha4apps.dqxrssreader;

import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SimpleDrawerAdapter extends RecyclerView.Adapter<SimpleDrawerAdapter.ViewHolder> {

    private static SimpleDrawerAdapter.OnItemClickListener listener;
    public void setOnItemClickListener(SimpleDrawerAdapter.OnItemClickListener listener){
        SimpleDrawerAdapter.listener = listener;
    }
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }
     
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView mTextView;
        public ViewHolder(View itemView, int viewType) {
            super(itemView);
 
            //各アイテムのViewを取得
            mTextView = (TextView) itemView.findViewById(android.R.id.text1);

            mTextView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v){
            if(listener != null){
                listener.onItemClick(v,getLayoutPosition());
            }
        }
    }
 
    // MainActivityから渡されるデータ
    private String[] mDrawerMenuArr;
 
    public SimpleDrawerAdapter(String[] arrayList){
        mDrawerMenuArr = arrayList;
    }
 
    @Override
    public SimpleDrawerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
 
        // レイアウトはsimple_list_item_1を利用
        View itemView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
 
        // アイテム選択可能にする
        itemView.setClickable(true);
 
        // アイテム選択時の Ripple Drawable を有効にする
        // Android 4 系端末で確認すると、Ripple効果は付かないが、選択色のみ適用される
        TypedValue outValue = new TypedValue();
        parent.getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
        itemView.setBackgroundResource(outValue.resourceId);
 
        // ViewHolderインスタンス生成
        ViewHolder vh = new ViewHolder(itemView, viewType);
        return vh;
    }
 
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
 
        // 各アイテムのViewに、データをバインドする
        String menu = mDrawerMenuArr[position];
        holder.mTextView.setText(menu);
    }
 
    @Override
    public int getItemCount() {
        return mDrawerMenuArr.length;
    }
}