package com.yanghaoyi.client_animationtest.view.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.view.activity.MusicActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : YangHaoYi on 2020/12/22.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/22.
 * Version : V 1.0
 */
public class AlbumListAdapter extends PagerAdapter {

    private Context context;
    private List<AlbumInfo> albumList;


    public AlbumListAdapter(Context context,List<AlbumInfo> albumList) {
        this.context = context;
        this.albumList = albumList;
    }

    @Override
    public int getCount() {
        //return viewList==null?0:viewList.size();
        return albumList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    TextView img;

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.item_album, null);
        TextView img = view.findViewById(R.id.tvAlbumName);
        img.setTag(R.id.tvAlbumName, position);
        if(albumList.get(position).getPicture()!=0){
            img.setBackground(context.getResources().getDrawable(albumList.get(position).getPicture()));
        }
        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((FrameLayout)object);
    }

    public void setAlbumListHide() {
        List<AlbumInfo> albumList = new ArrayList<>();
        AlbumInfo albumInfo = new AlbumInfo();
        albumInfo.setPicture(R.mipmap.album_01);
        AlbumInfo albumInfo1 = new AlbumInfo();
        albumInfo1.setPicture(R.mipmap.album_02);
        AlbumInfo albumInfo2 = new AlbumInfo();
        albumInfo2.setPicture(0);
        AlbumInfo albumInfo3 = new AlbumInfo();
        albumInfo3.setPicture(R.mipmap.album_04);
        AlbumInfo albumInfo4 = new AlbumInfo();
        albumInfo4.setPicture(R.mipmap.album_05);
        albumList.add(albumInfo);
        albumList.add(albumInfo1);
        albumList.add(albumInfo2);
        albumList.add(albumInfo3);
        albumList.add(albumInfo4);
        this.albumList = albumList;
        notifyDataSetChanged();
    }

    public void setAlbumListVisiable() {
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
        this.albumList = albumList;
        notifyDataSetChanged();
    }



//    public int getItemPosition(Object object) {
//
//        View view = (View) object;
//        int currentPagerIdx = ((MusicActivity) context).getCurrentPagerIdx();
//
//        if (currentPagerIdx == (Integer) view.getTag(R.id.tvAlbumName)) {
//            return POSITION_NONE;
//        } else {
//            return POSITION_UNCHANGED;
//        }
//    }

}
