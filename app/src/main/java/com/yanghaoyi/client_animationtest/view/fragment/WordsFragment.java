package com.yanghaoyi.client_animationtest.view.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.presenter.WordsPresenter;
import com.yanghaoyi.client_animationtest.view.IWordsView;
import com.yanghaoyi.client_animationtest.view.fragment.base.BaseFragment;
import com.yanghaoyi.client_animationtest.view.impl.WordsViewImpl;

import java.io.Serializable;
import java.util.List;

/**
 * @author : YangHaoYi on 2020/12/17.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/17.
 * Version : V 1.0
 */
public class WordsFragment extends BaseFragment implements View.OnClickListener {

    public static final String EXTRA_SAMPLE = "sample";
    public static final String INDEX = "index";
    private ImageView ivAlbum;
    private List<AlbumInfo> albumInfoList;
    private AlbumInfo albumInfo;
    private int currentIndex;
    private TextView tvPrevious;
    private TextView tvNext;
    private WordsPresenter wordsPresenter;
    private IWordsView wordsView;

    public static WordsFragment newInstance(List<AlbumInfo> albumInfo, int currentIndex) {
        WordsFragment fragment = new WordsFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_SAMPLE, (Serializable) albumInfo);
        args.putInt(INDEX, currentIndex);
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
        tvPrevious = view.findViewById(R.id.tvPrevious);
        tvNext = view.findViewById(R.id.tvNext);
        ivAlbum.setImageDrawable(getActivity().getResources().getDrawable(albumInfo.getPicture()));
        wordsView = new WordsViewImpl(getActivity(),ivAlbum);
    }

    @Override
    protected void initData(){
        albumInfoList = (List<AlbumInfo>) getArguments().getSerializable(EXTRA_SAMPLE);
        currentIndex = getArguments().getInt(INDEX);
        albumInfo = albumInfoList.get(currentIndex);
    }

    @Override
    protected void initEvent() {
        super.initEvent();
        wordsPresenter = new WordsPresenter(wordsView,albumInfoList,currentIndex);
        tvPrevious.setOnClickListener(this);
        tvNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvPrevious:
                wordsPresenter.toPrevious();
                break;
            case R.id.tvNext:
                wordsPresenter.toNext();
                break;
            default:
                break;
        }
    }
}
