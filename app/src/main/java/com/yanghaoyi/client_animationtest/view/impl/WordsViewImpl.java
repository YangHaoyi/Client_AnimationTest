package com.yanghaoyi.client_animationtest.view.impl;

import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.view.IWordsView;

import static com.yanghaoyi.client_animationtest.presenter.util.AnimationConstants.TOAST_DURATION;

/**
 * @author : YangHaoYi on 2020/12/24.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/24.
 * Version : V 1.0
 */
public class WordsViewImpl implements IWordsView {

    private FragmentActivity context;
    private ImageView ivAlbum;

    public WordsViewImpl(FragmentActivity context, ImageView ivAlbum) {
        this.context = context;
        this.ivAlbum = ivAlbum;
    }

    @Override
    public void showAlbum(AlbumInfo albumInfo) {
        ivAlbum.setImageDrawable(context.getResources().getDrawable(albumInfo.getPicture()));
    }

    @Override
    public void showToastAlreadyFirst() {
        showMessage(context.getResources().getString(R.string.words_already_first));
    }

    @Override
    public void showToastAlreadyLast() {
        showMessage(context.getResources().getString(R.string.words_already_last));
    }

    private void showMessage(String message){
        Toast.makeText(context, message,Toast.LENGTH_LONG ).show();
    }
}
