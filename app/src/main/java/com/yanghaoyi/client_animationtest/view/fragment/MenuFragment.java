package com.yanghaoyi.client_animationtest.view.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.presenter.util.AnimationTestUtil;
import com.yanghaoyi.client_animationtest.view.fragment.base.BaseFragment;

/**
 * @author : YangHaoYi on 2020/12/17.
 * Email  :  yang.haoyi@qq.com
 * Description :菜单按钮放大页面
 * Change : YangHaoYi on 2020/12/17.
 * Version : V 1.0
 */
public class MenuFragment extends BaseFragment {

    /** 延迟显示新背景消息 */
    private static final int DELAY_SHOW_BG_WITHOUT_LINE = 1;
    /** 页面背景 */
    private FrameLayout fmMenu;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case DELAY_SHOW_BG_WITHOUT_LINE:
                    AnimationTestUtil.logMessage("================Delay show background without line===================");
                    fmMenu.setBackground(getActivity().getResources().getDrawable(R.drawable.menu_background));
                    break;
                default:
                    //do nothing
                    break;
            }
        }
    };


    @Override
    public int getContentLayout() {
        return R.layout.fragment_menu;
    }

    @Override
    protected void initView(){
        fmMenu = view.findViewById(R.id.fmMenu);
        fmMenu.setBackground(getActivity().getResources().getDrawable(R.mipmap.c_route_bg_left_focused));
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void initData(){
        //如果Fragment退出，停止执行延迟显示新背景
        handler.sendEmptyMessageDelayed(DELAY_SHOW_BG_WITHOUT_LINE, getResources().getInteger(R.integer.anim_duration_very_long) - 500);
    }

    @Override
    public void onPause() {
        handler.removeMessages(DELAY_SHOW_BG_WITHOUT_LINE);
        AnimationTestUtil.logMessage("removeMessages DELAY_SHOW_BG_WITHOUT_LINE");
        super.onPause();
    }
}
