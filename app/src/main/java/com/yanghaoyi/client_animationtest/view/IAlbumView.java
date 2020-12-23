package com.yanghaoyi.client_animationtest.view;

import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.model.bean.TransitionInfo;

import java.util.List;

/**
 * @author : YangHaoYi on 2020/12/22.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/22.
 * Version : V 1.0
 */
public interface IAlbumView {

    void toAlbumListPage();

    /**
     * 跳转歌曲列表页
     * @param animation 动画列表
     * @param albumInfo 共享专辑信息
     * **/
    void toSongListPage(TransitionInfo animation, AlbumInfo albumInfo);

    /**
     * 跳转歌词页面
     * @param animation 动画列表
     * @param albumInfo 共享专辑信息
     * **/
    void toWordsPage(TransitionInfo animation, AlbumInfo albumInfo);

    void toMenuPage(TransitionInfo animation);

    void showCenterImage();

    void hideCenterImage();

    int currentSelectItem();
}
