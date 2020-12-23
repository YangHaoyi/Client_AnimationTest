package com.yanghaoyi.client_animationtest.presenter.factory;

import androidx.transition.ChangeBounds;
import androidx.transition.ChangeImageTransform;
import androidx.transition.ChangeTransform;
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
public class WordsEnterTransition implements IEnterTransition{
    @Override
    public TransitionInfo produceAnimation() {
        TransitionInfo transitionInfo = new TransitionInfo();
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(new ChangeBounds());
        transitionSet.addTransition(new ChangeTransform());
        transitionSet.addTransition(new ChangeImageTransform());
        transitionSet.setOrdering(ORDERING_TOGETHER);
        transitionInfo.setSharedElementEnterTransition(transitionSet);
        return transitionInfo;
    }
}
