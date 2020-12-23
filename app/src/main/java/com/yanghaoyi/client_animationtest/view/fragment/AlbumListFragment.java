package com.yanghaoyi.client_animationtest.view.fragment;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.view.adapter.AlbumAdapter;
import com.yanghaoyi.client_animationtest.view.custom.ILayoutAnimationController;
import com.yanghaoyi.client_animationtest.view.custom.VpRecyView;
import com.yanghaoyi.client_animationtest.view.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : YangHaoYi on 2020/12/22.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/22.
 * Version : V 1.0
 */
public class AlbumListFragment extends BaseFragment {

    private List<AlbumInfo> albumList;
    private AlbumAdapter albumAdapter;
    private VpRecyView rvAlbum;

    @Override
    public int getContentLayout() {
        return R.layout.fragment_album_list;
    }

    @Override
    protected void initView() {
        initViewPager();
    }

    private void initViewPager(){
        rvAlbum = view.findViewById(R.id.rvAlbum);
        initAlbumInfoList();
        albumAdapter = new AlbumAdapter(albumList);
        rvAlbum.setAdapter(albumAdapter);
        rvAlbum.setOnPagerChageListener(new VpRecyView.onPagerChageListener() {
            @Override
            public void onPagerChage(int position) {

            }
        });
        rvAlbum.setOnPagerPosition(2);
        ILayoutAnimationController.setLayoutAnimation(rvAlbum,R.anim.push_down_in,0.8f,ILayoutAnimationController.IndexAlgorithm.MIDDLETOEDGE);
    }


    private void initAlbumInfoList(){
        albumList = new ArrayList<>();
        AlbumInfo albumInfo = new AlbumInfo();
        albumInfo.setPicture(R.mipmap.album_01);
        AlbumInfo albumInfo1 = new AlbumInfo();
        albumInfo1.setPicture(R.mipmap.album_02);
        AlbumInfo albumInfo2 = new AlbumInfo();
        albumInfo2.setPicture(R.mipmap.album_03);
        AlbumInfo albumInfo3 = new AlbumInfo();
        albumInfo3.setPicture(R.mipmap.album_04);
        AlbumInfo albumInfo4 = new AlbumInfo();
        albumInfo4.setPicture(R.mipmap.album_05);
        albumList.add(albumInfo);
        albumList.add(albumInfo1);
        albumList.add(albumInfo2);
        albumList.add(albumInfo3);
        albumList.add(albumInfo4);
    }



}
