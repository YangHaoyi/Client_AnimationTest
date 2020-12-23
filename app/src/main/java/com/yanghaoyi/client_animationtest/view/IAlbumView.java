package com.yanghaoyi.client_animationtest.view;

import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.model.bean.TransitionInfo;

/**
 * @author : YangHaoYi on 2020/12/22.
 * Email  :  yang.haoyi@qq.com
 * Description :专辑view接口
 * Change : YangHaoYi on 2020/12/22.
 * Version : V 1.0
 */
public interface IAlbumView {

    /**
     * 跳转专辑列表页面
     * **/
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

    /**
     * 跳转按钮页面
     * **/
    void toMenuPage(TransitionInfo animation);

    /**
     * 展示中心图片
     * **/
    void showCenterImage();

    /**
     * 隐藏中心图片
     * **/
    void hideCenterImage();

    /**
     * 获取当前index
     * @return 当前index
     * **/
    int currentSelectItem();
}
