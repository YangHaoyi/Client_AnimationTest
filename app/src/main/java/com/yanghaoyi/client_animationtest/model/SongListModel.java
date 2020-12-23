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
        songInfo1.setName("111");
        SongInfo songInfo2 = new SongInfo();
        songInfo2.setName("222");
        SongInfo songInfo3 = new SongInfo();
        songInfo3.setName("333");
        SongInfo songInfo4 = new SongInfo();
        songInfo4.setName("444");
        SongInfo songInfo5 = new SongInfo();
        songInfo5.setName("555");
        SongInfo songInfo6 = new SongInfo();
        songInfo6.setName("666");
        SongInfo songInfo7 = new SongInfo();
        songInfo7.setName("777");
        SongInfo songInfo8 = new SongInfo();
        songInfo8.setName("888");
        SongInfo songInfo9 = new SongInfo();
        songInfo9.setName("999");
        SongInfo songInfo10 = new SongInfo();
        songInfo10.setName("1010");
        songInfoList.add(songInfo1);
        songInfoList.add(songInfo2);
        songInfoList.add(songInfo3);
        songInfoList.add(songInfo4);
        songInfoList.add(songInfo5);
        songInfoList.add(songInfo6);
        songInfoList.add(songInfo7);
        songInfoList.add(songInfo8);
        songInfoList.add(songInfo9);
        songInfoList.add(songInfo10);
        return songInfoList;
    }
}
