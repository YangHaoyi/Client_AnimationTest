package com.yanghaoyi.client_animationtest.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.SongInfo;

import java.util.List;

/**
 * @author : YangHaoYi on 2020/12/16.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/16.
 * Version : V 1.0
 */
public class SongListAdapter extends  RecyclerView.Adapter<SongListAdapter.ViewHolder> {

    private List<SongInfo> songInfoList;
    private Context context;

    public SongListAdapter(List<SongInfo> songInfoList) {
        this.songInfoList = songInfoList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SongInfo songInfo = songInfoList.get(position);
        holder.tvSongName.setText(songInfo.getName());
    }

    @Override
    public int getItemCount() {
        return songInfoList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvSongName;
        public ViewHolder (View view) {
            super(view);
            tvSongName = (TextView) view.findViewById(R.id.tvSongName);
        }
    }

}
