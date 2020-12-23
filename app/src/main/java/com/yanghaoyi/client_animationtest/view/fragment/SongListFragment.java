package com.yanghaoyi.client_animationtest.view.fragment;

import android.os.Build;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.model.bean.SongInfo;
import com.yanghaoyi.client_animationtest.presenter.SongListPresenter;
import com.yanghaoyi.client_animationtest.view.adapter.SongListAdapter;
import com.yanghaoyi.client_animationtest.view.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : YangHaoYi on 2020/12/16.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/16.
 * Version : V 1.0
 */
public class SongListFragment extends BaseFragment {

    public static final String EXTRA_SAMPLE = "sample";
    private AlbumInfo albumInfo;
    private ImageView ivAlbum;
    private RecyclerView rvSongList;
    private SongListAdapter songListAdapter;
    private SongListPresenter presenter;
    private List<SongInfo> songInfoList;

    public static SongListFragment newInstance(AlbumInfo albumInfo) {
        SongListFragment fragment = new SongListFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_SAMPLE, albumInfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_son_list;
    }

    @Override
    protected void initView(){
        ivAlbum = view.findViewById(R.id.ivAlbum);
        rvSongList = view.findViewById(R.id.rvSongList);
        songListAdapter = new SongListAdapter(songInfoList);
        ivAlbum.setBackground(getActivity().getResources().getDrawable(albumInfo.getPicture()));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvSongList.setLayoutManager(layoutManager);
        rvSongList.setAdapter(songListAdapter);
    }

    @Override
    protected void initData(){
        albumInfo =(AlbumInfo) getArguments().getSerializable(EXTRA_SAMPLE);
        presenter = new SongListPresenter();
        songInfoList = presenter.getSongList();
    }
}
