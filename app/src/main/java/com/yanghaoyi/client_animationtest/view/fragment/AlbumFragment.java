package com.yanghaoyi.client_animationtest.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.AlbumModel;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.presenter.AlbumPresenter;
import com.yanghaoyi.client_animationtest.view.IAlbumView;
import com.yanghaoyi.client_animationtest.view.adapter.AlbumAdapter;
import com.yanghaoyi.client_animationtest.view.fragment.base.BaseFragment;
import com.yanghaoyi.client_animationtest.view.holder.AlbumViewHolder;
import com.yanghaoyi.client_animationtest.view.impl.AlbumViewImpl;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

/**
 * @author : YangHaoYi on 2020/12/16.
 * Email  :  yang.haoyi@qq.com
 * Description : 专辑展示Fragement页面
 * Change : YangHaoYi on 2020/12/16.
 * Version : V 1.0
 */
public class AlbumFragment extends BaseFragment implements View.OnClickListener {

    /** 跳转歌曲列表按钮 **/
    private TextView tvToSongList;
    /** 跳转专辑列表按钮 **/
    private TextView tvToAlbumList;
    /** 跳转歌词页面按钮 **/
    private TextView tvToWords;
    /** 专辑图片 共享元素 **/
    private ImageView ivAlbum;
    /** 按钮布局 共享元素 **/
    private FrameLayout fmMenu;
    /** 上一首 共享元素 **/
    private ImageView ivImgPrevious;
    /** 暂停 共享元素 **/
    private ImageView ivImgPause;
    /** 下一首 共享元素 **/
    private ImageView ivImgNext;
    /** 专辑列表 **/
    private DiscreteScrollView scrollView;
    /** 专辑RecyclerView 适配器 **/
    private AlbumAdapter albumAdapter;
    /** 专辑逻辑中心 **/
    private AlbumPresenter albumPresenter;
    /** 专辑View接口 **/
    private IAlbumView albumView;
    /** 专辑视图View控制器 **/
    private AlbumViewHolder viewHolder;

    private static AlbumFragment albumFragment;

    public static AlbumFragment newInstance(AlbumInfo albumInfo) {
        if(albumFragment == null){
            albumFragment = new AlbumFragment();
        }
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_SAMPLE, albumInfo);
        albumFragment.setArguments(args);
        return albumFragment;
    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_album;
    }

    @Override
    protected void initView(){
        ivAlbum = view.findViewById(R.id.ivAlbum);
        tvToSongList = view.findViewById(R.id.tvToSongList);
        tvToAlbumList = view.findViewById(R.id.tvToAlbumList);
        tvToWords = view.findViewById(R.id.tvToWords);
        fmMenu = view.findViewById(R.id.fmMenu);
        ivImgPrevious = view.findViewById(R.id.ivImgPrevious);
        ivImgPause = view.findViewById(R.id.ivImgPause);
        ivImgNext = view.findViewById(R.id.ivImgNext);
        viewHolder = new AlbumViewHolder();
        viewHolder.setIvAlbum(ivAlbum);
        viewHolder.setIvMenu(fmMenu);
        viewHolder.setIvImgPrevious(ivImgPrevious);
        viewHolder.setIvImgPause(ivImgPause);
        viewHolder.setIvImgNext(ivImgNext);
        albumView = new AlbumViewImpl(getActivity(),viewHolder);
        scrollView = view.findViewById(R.id.rvAlbumList);
    }

    @Override
    protected void initEvent(){
        albumPresenter = new AlbumPresenter(albumView);
        tvToAlbumList.setOnClickListener(this);
        tvToSongList.setOnClickListener(this);
        fmMenu.setOnClickListener(this);
        tvToWords.setOnClickListener(this);
        albumAdapter = new AlbumAdapter(albumPresenter.getAlbumList());
        scrollView.setAdapter(albumAdapter);
        scrollView.setOffscreenItems(5);
        scrollView.scrollToPosition(2);
        viewHolder.setRecyclerView(scrollView);
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                albumView.hideCenterImage();
                return false;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tvToAlbumList:
                albumPresenter.toAlbumListPage();
                break;
            case R.id.tvToSongList:
                albumPresenter.toSongListPage();
                break;
            case R.id.fmMenu:
                albumPresenter.toMenuPage();
                break;
            case R.id.tvToWords:
                albumPresenter.toWordsPage();
                break;
            default:
                break;
        }
    }

    /** 展示中心图片 **/
    public void showCenterImage(){
        albumView.showCenterImage();
    }
}
