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
import com.yanghaoyi.client_animationtest.view.adapter.SongListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : YangHaoYi on 2020/12/16.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/16.
 * Version : V 1.0
 */
public class SongListFragment extends Fragment {

    public static final String EXTRA_SAMPLE = "sample";
    private AlbumInfo albumInfo;
    private ImageView ivAlbum;
    private RecyclerView rvSongList;
    private SongListAdapter songListAdapter;
    private List<SongInfo> songInfoList;

    public static SongListFragment newInstance(AlbumInfo albumInfo) {
        SongListFragment fragment = new SongListFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_SAMPLE, albumInfo);
        fragment.setArguments(args);
        return fragment;
    }


    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_son_list, container, false);
        init();
        return view;
    }

    private void init(){
        initView();
        initData();
        initEvent();
    }

    private void initView(){
        ivAlbum = view.findViewById(R.id.ivAlbum);
        rvSongList = view.findViewById(R.id.rvSongList);
    }

    private void initData(){
        albumInfo =(AlbumInfo) getArguments().getSerializable(EXTRA_SAMPLE);
        ivAlbum.setBackground(getActivity().getResources().getDrawable(albumInfo.getPicture()));
        initSongList();
        songListAdapter = new SongListAdapter(songInfoList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvSongList.setLayoutManager(layoutManager);
        rvSongList.setAdapter(songListAdapter);
    }

    private void initEvent(){
        ivAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toAlbum(albumInfo,ivAlbum,true);
            }
        });
    }

    private void initSongList(){
        songInfoList = new ArrayList<>();
        SongInfo songInfo1 = new SongInfo();
        songInfo1.setName("111");
        SongInfo songInfo2 = new SongInfo();
        songInfo2.setName("222");
        SongInfo songInfo3 = new SongInfo();
        songInfo3.setName("333");
        SongInfo songInfo4 = new SongInfo();
        songInfo4.setName("444");
        SongInfo songInfo5 = new SongInfo();
        songInfo5.setName("555");
        SongInfo songInfo6 = new SongInfo();
        songInfo6.setName("666");
        SongInfo songInfo7 = new SongInfo();
        songInfo7.setName("777");
        SongInfo songInfo8 = new SongInfo();
        songInfo8.setName("888");
        SongInfo songInfo9 = new SongInfo();
        songInfo9.setName("999");
        SongInfo songInfo10 = new SongInfo();
        songInfo10.setName("1010");
        songInfoList.add(songInfo1);
        songInfoList.add(songInfo2);
        songInfoList.add(songInfo3);
        songInfoList.add(songInfo4);
        songInfoList.add(songInfo5);
        songInfoList.add(songInfo6);
        songInfoList.add(songInfo7);
        songInfoList.add(songInfo8);
        songInfoList.add(songInfo9);
        songInfoList.add(songInfo10);

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void toAlbum(AlbumInfo albumInfo,ImageView ivAlbum,boolean overlap) {
        AlbumFragment songListFragment =AlbumFragment.newInstance(albumInfo);
        Slide slide = new Slide(Gravity.LEFT);
        slide.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(getResources().getInteger(R.integer.anim_duration_very_long));

        songListFragment.setEnterTransition(slide);
        songListFragment.setAllowEnterTransitionOverlap(true);
        songListFragment.setAllowReturnTransitionOverlap(false);
        songListFragment.setSharedElementEnterTransition(changeBounds);

        getFragmentManager().beginTransaction()
                .replace(R.id.fmContent,songListFragment)
                .addToBackStack(null)
                .addSharedElement(ivAlbum,getString(R.string.square_blue_name))
                .commit();
    }

}
