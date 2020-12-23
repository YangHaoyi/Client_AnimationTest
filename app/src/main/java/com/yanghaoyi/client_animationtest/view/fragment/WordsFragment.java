package com.yanghaoyi.client_animationtest.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.presenter.util.AnimationTestUtil;
import com.yanghaoyi.client_animationtest.view.adapter.SongListAdapter;

/**
 * @author : YangHaoYi on 2020/12/17.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/17.
 * Version : V 1.0
 */
public class WordsFragment extends Fragment {

    public static final String EXTRA_SAMPLE = "sample";
    private ImageView ivAlbum;
    private AlbumInfo albumInfo;

    public static WordsFragment newInstance(AlbumInfo albumInfo) {
        WordsFragment fragment = new WordsFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_SAMPLE, albumInfo);
        fragment.setArguments(args);
        return fragment;
    }


    private View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AnimationTestUtil.logMessage("==========================onCreateView==========================");
        view = inflater.inflate(R.layout.fragment_words, container, false);
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
    }

    private void initData(){
        albumInfo =(AlbumInfo) getArguments().getSerializable(EXTRA_SAMPLE);
        ivAlbum.setImageDrawable(getActivity().getResources().getDrawable(albumInfo.getPicture()));
    }

    private void initEvent(){

    }


}
