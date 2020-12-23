package com.yanghaoyi.client_animationtest.view.fragment.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yanghaoyi.client_animationtest.presenter.util.AnimationTestUtil;

/**
 * @author : YangHaoYi on 2020/12/19.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/19.
 * Version : V 1.0
 */
public abstract class BaseFragment extends Fragment {

    protected static final String ALBUM_INFO = "albumInfo";
    protected static final String EXTRA_SAMPLE = "sample";
    protected View view;

    public abstract int getContentLayout();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AnimationTestUtil.logMessage("==========================view==========================" + view);
        if(view==null){
            view = inflater.inflate(getContentLayout(), container, false);
            init();
        }
        return view;
    }

    private void init(){
        initData();
        initView();
        initEvent();
    }

    protected abstract void initView();
    protected void initData(){};
    protected void initEvent(){};

}
