package com.yanghaoyi.client_animationtest.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.view.fragment.AlbumFragment;

/**
 * @author : YangHaoYi on 2020/12/16.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/16.
 * Version : V 1.0
 */
public class MusicActivity extends FragmentActivity {

    private AlbumFragment albumFragment;
    private TextView tvBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        init();
    }


    private void init(){
        initView();
        initEvent();
    }

    private void initView(){
        tvBack = findViewById(R.id.tvBack);
        showAlbum();
    }

    private void initEvent(){
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void showAlbum(){
        AlbumInfo albumInfo = new AlbumInfo();
        albumFragment = AlbumFragment.newInstance(albumInfo);
        albumInfo.setPicture(R.mipmap.pic_album);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fmContent, albumFragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        albumFragment.showCenterImage();
        super.onBackPressed();
    }

    public void showBackButton(boolean show){
        tvBack.setVisibility(show?View.VISIBLE:View.GONE);
    }
}
