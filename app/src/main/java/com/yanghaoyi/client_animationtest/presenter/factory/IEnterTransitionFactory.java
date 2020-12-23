package com.yanghaoyi.client_animationtest.presenter.factory;

import com.yanghaoyi.client_animationtest.presenter.factory.enu.EnterTransitionType;

/**
 * @author : YangHaoYi on 2020/12/21.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/21.
 * Version : V 1.0
 */
public interface IEnterTransitionFactory {

    IEnterTransition createTransition(EnterTransitionType enterTransitionType);

}
