package com.yanghaoyi.client_animationtest.view;

import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;

/**
 * @author : YangHaoYi on 2020/12/24.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/24.
 * Version : V 1.0
 */
public interface IWordsView {

    void showAlbum(AlbumInfo albumInfo);

    void showToastAlreadyFirst();

    void showToastAlreadyLast();
}
