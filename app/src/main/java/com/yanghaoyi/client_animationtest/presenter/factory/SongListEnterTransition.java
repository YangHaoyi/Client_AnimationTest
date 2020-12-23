package com.yanghaoyi.client_animationtest.presenter.factory;

import android.view.Gravity;

import androidx.annotation.NonNull;
import androidx.transition.ChangeBounds;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;

import com.yanghaoyi.client_animationtest.model.bean.TransitionInfo;

import static androidx.transition.TransitionSet.ORDERING_TOGETHER;

/**
 * @author : YangHaoYi on 2020/12/21.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/21.
 * Version : V 1.0
 */
public class SongListEnterTransition implements IEnterTransition{

    private static final int DURATION = 1500;

    @Override
    public TransitionInfo produceAnimation() {
        TransitionInfo transitionInfo = new TransitionInfo();
        Slide slide = new Slide(Gravity.RIGHT);
        slide.setDuration(DURATION);
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(DURATION);
        transitionInfo.setEnterTransition(slide);
        transitionInfo.setSharedElementEnterTransition(changeBounds);
        return transitionInfo;
    }
}
