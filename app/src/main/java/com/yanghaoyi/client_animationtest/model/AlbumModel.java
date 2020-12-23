package com.yanghaoyi.client_animationtest.model;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : YangHaoYi on 2020/12/16.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/16.
 * Version : V 1.0
 */
public class AlbumModel {

    public List<AlbumInfo> getAlbumList(){
        List<AlbumInfo> albumList = new ArrayList<>();
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
        return albumList;
    }
}
