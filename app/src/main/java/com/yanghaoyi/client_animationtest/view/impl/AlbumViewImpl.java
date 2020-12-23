package com.yanghaoyi.client_animationtest.view.impl;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.transition.Transition;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.model.bean.TransitionInfo;
import com.yanghaoyi.client_animationtest.presenter.util.AnimationTestUtil;
import com.yanghaoyi.client_animationtest.view.IAlbumView;
import com.yanghaoyi.client_animationtest.view.activity.ShareActivity;
import com.yanghaoyi.client_animationtest.view.adapter.AlbumListAdapter;
import com.yanghaoyi.client_animationtest.view.fragment.AlbumListFragment;
import com.yanghaoyi.client_animationtest.view.fragment.MenuFragment;
import com.yanghaoyi.client_animationtest.view.fragment.SongListFragment;
import com.yanghaoyi.client_animationtest.view.fragment.WordsFragment;
import com.yanghaoyi.client_animationtest.view.holder.AlbumViewHolder;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

import java.util.List;

/**
 * @author : YangHaoYi on 2020/12/22.
 * Email  :  yang.haoyi@qq.com
 * Description : 专辑页面View实现
 * Change : YangHaoYi on 2020/12/22.
 * Version : V 1.0
 */
public class AlbumViewImpl implements IAlbumView {

    private FragmentActivity context;
    private AlbumViewHolder viewHolder;
    private AlbumInfo albumInfo;
    private final String shareAlbum;
    private final String shareScaleAlbum;
    private final String shareMenu;
    private final String shareMenuPrevious;
    private final String shareMenuPause;
    private final String shareMenuNext;

    public AlbumViewImpl(FragmentActivity context, AlbumViewHolder viewHolder) {
        this.context = context;
        this.viewHolder = viewHolder;
        shareAlbum = context.getResources().getString(R.string.square_blue_name);
        shareScaleAlbum = context.getResources().getString(R.string.square_blue_name);
        shareMenu = context.getResources().getString(R.string.share_iv_menu);
        shareMenuPrevious = context.getResources().getString(R.string.share_iv_menu_previous);
        shareMenuPause = context.getResources().getString(R.string.share_iv_menu_pause);
        shareMenuNext = context.getResources().getString(R.string.share_iv_menu_next);
    }

    @Override
    public void toAlbumListPage() {
        AlbumListFragment albumListFragment = new AlbumListFragment();
        context.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fmContent,albumListFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void toSongListPage(TransitionInfo transitionInfo,AlbumInfo albumInfo) {
        this.albumInfo = albumInfo;
        showCenterImage();
        SongListFragment songListFragment = SongListFragment.newInstance(albumInfo);
        songListFragment.setEnterTransition(transitionInfo.getEnterTransition());
        songListFragment.setAllowEnterTransitionOverlap(true);
        songListFragment.setAllowReturnTransitionOverlap(false);
        songListFragment.setSharedElementEnterTransition(transitionInfo.getSharedElementEnterTransition());
        context.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fmContent,songListFragment)
                .addToBackStack(null)
                .addSharedElement(viewHolder.getIvAlbum(),shareAlbum)
                .commitAllowingStateLoss();
    }

    private void toSongListByActivity(){
        Intent intent = new Intent(context, ShareActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(context, getCurrentRecyclerViewItem(),shareAlbum);
        context.startActivity(intent,options.toBundle());
    }


    @Override
    public void toWordsPage(TransitionInfo animation,AlbumInfo albumInfo) {
        this.albumInfo = albumInfo;
        showCenterImage();
        WordsFragment wordsFragment = WordsFragment.newInstance(albumInfo);
        wordsFragment.setSharedElementEnterTransition(animation.getSharedElementEnterTransition());
        wordsFragment.setSharedElementReturnTransition(animation.getSharedElementEnterTransition());
        context.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fmContent,wordsFragment)
                .addToBackStack(null)
                .addSharedElement(viewHolder.getIvAlbum(),shareScaleAlbum)
                .commit();
    }

    @Override
    public void toMenuPage(TransitionInfo animation) {
        MenuFragment menuFragment = MenuFragment.newInstance();
        menuFragment.setSharedElementEnterTransition(animation.getSharedElementEnterTransition());
        menuFragment.setSharedElementReturnTransition(animation.getSharedElementEnterTransition());
        context.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fmContent,menuFragment)
                .addToBackStack(null)
                .addSharedElement(viewHolder.getIvMenu(),shareMenu)
                .addSharedElement(viewHolder.getIvImgPrevious(),shareMenuPrevious)
                .addSharedElement(viewHolder.getIvImgPause(),shareMenuPause)
                .addSharedElement(viewHolder.getIvImgNext(),shareMenuNext)
                .commit();
    }

    @Override
    public void showCenterImage() {
        viewHolder.getIvAlbum().setVisibility(View.VISIBLE);
        if(albumInfo!=null){
            viewHolder.getIvAlbum().setBackground(context.getResources().getDrawable(albumInfo.getPicture()));
            getCurrentRecyclerViewItem().setVisibility(View.GONE);
        }
    }

    @Override
    public void hideCenterImage() {
        viewHolder.getIvAlbum().setVisibility(View.GONE);
        getCurrentRecyclerViewItem().setVisibility(View.VISIBLE);
    }

    @Override
    public int currentSelectItem() {
        return ((DiscreteScrollView)viewHolder.getRecyclerView()).getCurrentItem();
    }

    /**
     * 获取需要改变的RecyclerViewItem
     * @return recyclerView Item
     * **/
    private View getCurrentRecyclerViewItem(){
        View view = ((DiscreteScrollView)viewHolder.getRecyclerView()).getViewHolder(((DiscreteScrollView)viewHolder.getRecyclerView()).getCurrentItem()).itemView;
        return view.findViewById(R.id.tvAlbumName);
    }
}
