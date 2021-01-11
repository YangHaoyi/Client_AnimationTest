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
import com.yanghaoyi.client_animationtest.presenter.evnet.ImageChangeEvent;
import com.yanghaoyi.client_animationtest.view.adapter.SongListAdapter;
import com.yanghaoyi.client_animationtest.view.fragment.base.BaseFragment;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static android.widget.NumberPicker.OnScrollListener.SCROLL_STATE_IDLE;

/**
 * @author : YangHaoYi on 2020/12/16.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/16.
 * Version : V 1.0
 */
public class SongListFragment extends BaseFragment {

    public static final String EXTRA_SAMPLE = "sample";
    public static final String INDEX = "index";
    private AlbumInfo albumInfo;
    private ImageView ivAlbum;
    private RecyclerView rvSongList;
    private SongListAdapter songListAdapter;
    private SongListPresenter presenter;
    private List<SongInfo> songInfoList;
    private List<AlbumInfo> albumInfoList;
    private int currentIndex;

    public static SongListFragment newInstance(List<AlbumInfo> albumInfo,int currentIndex) {
        SongListFragment fragment = new SongListFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_SAMPLE, (Serializable) albumInfo);
        args.putInt(INDEX, currentIndex);
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
        albumInfoList = (List<AlbumInfo>) getArguments().getSerializable(EXTRA_SAMPLE);
        currentIndex = getArguments().getInt(INDEX);
        albumInfo = albumInfoList.get(currentIndex);
        presenter = new SongListPresenter();
        songInfoList = presenter.getSongList();
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        songListAdapter.setItemClickListener(new SongListAdapter.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                ivAlbum.setBackground(getActivity().getResources().getDrawable(albumInfoList.get(position).getPicture()));
                ImageChangeEvent imageChangeEvent = new ImageChangeEvent();
                imageChangeEvent.setPosition(position);
                EventBus.getDefault().post(imageChangeEvent);
            }
        });
//        rvSongList.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if(newState == SCROLL_STATE_IDLE){
//                    recyclerView.setVerticalFadingEdgeEnabled(false);
//                } else {
//                    recyclerView.setVerticalFadingEdgeEnabled(true);
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//            }
//        });
//        rvSongList.setVerticalFadingEdgeEnabled(true);
    }
}
