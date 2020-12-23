package com.yanghaoyi.client_animationtest.presenter;

import com.yanghaoyi.client_animationtest.model.SongListModel;
import com.yanghaoyi.client_animationtest.model.bean.SongInfo;

import java.util.List;

/**
 * @author : YangHaoYi on 2020/12/23.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/23.
 * Version : V 1.0
 */
public class SongListPresenter {

    private SongListModel songListModel;

    public SongListPresenter() {
        songListModel = new SongListModel();
    }

    public List<SongInfo> getSongList(){
        return songListModel.getSongList();
    }
}
