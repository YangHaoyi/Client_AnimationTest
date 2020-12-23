package com.yanghaoyi.client_animationtest.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;

import java.util.List;

/**
 * @author : YangHaoYi on 2020/12/16.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/16.
 * Version : V 1.0
 */
public class AlbumAdapter extends  RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    private List<AlbumInfo> albumList;
    private Context context;
    private ClickListener clickListener;

    public AlbumAdapter(List<AlbumInfo> albumList) {
        this.albumList = albumList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AlbumInfo album = albumList.get(position);
        holder.fruitName.setBackground(context.getResources().getDrawable(album.getPicture()));
        holder.fruitName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                clickListener.onItemClick(v,album,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView fruitName;
        FrameLayout fmItemContent;
        public ViewHolder (View view) {
            super(view);
            fruitName = (TextView) view.findViewById(R.id.tvAlbumName);
            fmItemContent = (FrameLayout) view.findViewById(R.id.fmItemContent);
        }
    }

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public interface ClickListener{
        void onItemClick(View view,AlbumInfo album,int position);
    }



}
