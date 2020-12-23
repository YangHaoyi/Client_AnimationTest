package com.yanghaoyi.client_animationtest.presenter.factory;

import com.yanghaoyi.client_animationtest.presenter.factory.enu.EnterTransitionType;

/**
 * @author : YangHaoYi on 2020/12/21.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/21.
 * Version : V 1.0
 */
public class EnterTransitionFactory implements IEnterTransitionFactory{

    @Override
    public IEnterTransition createTransition(EnterTransitionType enterTransitionType) {
        try {
            return EnterTransitionType.get(enterTransitionType.getCode());
        } catch (Exception e) {
            return null;
        }
    }
}
