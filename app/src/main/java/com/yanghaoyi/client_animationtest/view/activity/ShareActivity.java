package com.yanghaoyi.client_animationtest.view.activity;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.yanghaoyi.client_animationtest.R;

/**
 * @author : YangHaoYi on 2020/12/23.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/23.
 * Version : V 1.0
 */
public class ShareActivity extends FragmentActivity {

    private ImageView ivAlbum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Slide slide = new Slide(Gravity.RIGHT);
        slide.setDuration(1500);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(1500);
        getWindow().setEnterTransition(slide);
        getWindow().setSharedElementEnterTransition(changeBounds);
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawableResource(R.color.transparent);
        setContentView(R.layout.fragment_son_list);
        ivAlbum = findViewById(R.id.ivAlbum);
        ivAlbum.setImageDrawable(getResources().getDrawable(R.mipmap.album_03));
    }




}
