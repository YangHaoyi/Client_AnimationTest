package com.yanghaoyi.client_animationtest.presenter.factory;


import androidx.transition.ChangeBounds;
import androidx.transition.TransitionSet;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.model.bean.TransitionInfo;

/**
 * @author : YangHaoYi on 2020/12/21.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/21.
 * Version : V 1.0
 */
public class MenuEnterTransition implements IEnterTransition{

    private static final int DURATION = 1500;

    @Override
    public TransitionInfo produceAnimation() {
        TransitionInfo transitionInfo = new TransitionInfo();
        TransitionSet transitionSet = new TransitionSet();
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(DURATION);
        transitionSet.addTransition(changeBounds);
        transitionInfo.setSharedElementEnterTransition(transitionSet);
        return transitionInfo;
    }
}
