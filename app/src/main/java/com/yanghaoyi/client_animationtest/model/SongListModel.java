package com.yanghaoyi.client_animationtest.model;

import com.yanghaoyi.client_animationtest.model.bean.SongInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : YangHaoYi on 2020/12/23.
 * Email  :  yang.haoyi@qq.com
 * Description :歌曲列表数据中心
 * Change : YangHaoYi on 2020/12/23.
 * Version : V 1.0
 */
public class SongListModel {

    public List<SongInfo> getSongList(){
        List<SongInfo>  songInfoList = new ArrayList<>();
        SongInfo songInfo1 = new SongInfo();
        songInfo1.setName("范特西");
        SongInfo songInfo2 = new SongInfo();
        songInfo2.setName("夜曲");
        SongInfo songInfo3 = new SongInfo();
        songInfo3.setName("无与伦比");
        SongInfo songInfo4 = new SongInfo();
        songInfo4.setName("叶惠美");
        SongInfo songInfo5 = new SongInfo();
        songInfo5.setName("12新作");
        songInfoList.add(songInfo1);
        songInfoList.add(songInfo2);
        songInfoList.add(songInfo3);
        songInfoList.add(songInfo4);
        songInfoList.add(songInfo5);
        return songInfoList;
    }
}
