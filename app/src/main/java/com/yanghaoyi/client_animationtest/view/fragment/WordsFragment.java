package com.yanghaoyi.client_animationtest.view.fragment;

import android.os.Bundle;
import android.widget.ImageView;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.view.fragment.base.BaseFragment;

/**
 * @author : YangHaoYi on 2020/12/17.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/17.
 * Version : V 1.0
 */
public class WordsFragment extends BaseFragment {

    public static final String EXTRA_SAMPLE = "sample";
    private ImageView ivAlbum;
    private AlbumInfo albumInfo;
    private static WordsFragment fragment;

    public static WordsFragment newInstance(AlbumInfo albumInfo) {
        if(fragment == null){
            fragment = new WordsFragment();
        }
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_SAMPLE, albumInfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_words;
    }

    @Override
    protected void initView(){
        ivAlbum = view.findViewById(R.id.ivAlbum);
        ivAlbum.setImageDrawable(getActivity().getResources().getDrawable(albumInfo.getPicture()));
    }

    @Override
    protected void initData(){
        albumInfo =(AlbumInfo) getArguments().getSerializable(EXTRA_SAMPLE);
    }

}
