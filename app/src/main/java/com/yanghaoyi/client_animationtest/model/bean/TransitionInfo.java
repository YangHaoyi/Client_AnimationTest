package com.yanghaoyi.client_animationtest.model.bean;

import androidx.transition.Transition;

/**
 * @author : YangHaoYi on 2020/12/22.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/22.
 * Version : V 1.0
 */
public class TransitionInfo {

    private Transition enterTransition;
    private Transition sharedElementEnterTransition;

    public Transition getEnterTransition() {
        return enterTransition;
    }

    public void setEnterTransition(Transition enterTransition) {
        this.enterTransition = enterTransition;
    }

    public Transition getSharedElementEnterTransition() {
        return sharedElementEnterTransition;
    }

    public void setSharedElementEnterTransition(Transition sharedElementEnterTransition) {
        this.sharedElementEnterTransition = sharedElementEnterTransition;
    }
}
