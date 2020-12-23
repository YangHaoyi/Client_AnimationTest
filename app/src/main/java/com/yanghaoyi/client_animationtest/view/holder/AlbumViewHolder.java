package com.yanghaoyi.client_animationtest.view.holder;

import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.yanghaoyi.client_animationtest.view.custom.VpRecyView;

/**
 * @author : YangHaoYi on 2020/12/22.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/22.
 * Version : V 1.0
 */
public class AlbumViewHolder {
    private ImageView ivAlbum;
    private FrameLayout ivMenu;
    private ImageView ivImgPrevious;
    private ImageView ivImgPause;
    private ImageView ivImgNext;
    private ViewPager viewPager;
    private VpRecyView vpRecyView;
    private RecyclerView recyclerView;

    public ImageView getIvAlbum() {
        return ivAlbum;
    }

    public void setIvAlbum(ImageView ivAlbum) {
        this.ivAlbum = ivAlbum;
    }

    public FrameLayout getIvMenu() {
        return ivMenu;
    }

    public void setIvMenu(FrameLayout ivMenu) {
        this.ivMenu = ivMenu;
    }

    public ImageView getIvImgPrevious() {
        return ivImgPrevious;
    }

    public void setIvImgPrevious(ImageView ivImgPrevious) {
        this.ivImgPrevious = ivImgPrevious;
    }

    public ImageView getIvImgPause() {
        return ivImgPause;
    }

    public void setIvImgPause(ImageView ivImgPause) {
        this.ivImgPause = ivImgPause;
    }

    public ImageView getIvImgNext() {
        return ivImgNext;
    }

    public void setIvImgNext(ImageView ivImgNext) {
        this.ivImgNext = ivImgNext;
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public VpRecyView getVpRecyView() {
        return vpRecyView;
    }

    public void setVpRecyView(VpRecyView vpRecyView) {
        this.vpRecyView = vpRecyView;
    }

    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }
}
