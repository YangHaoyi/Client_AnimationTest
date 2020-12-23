package com.yanghaoyi.client_animationtest.presenter;

import androidx.annotation.NonNull;
import androidx.transition.Transition;

import com.yanghaoyi.client_animationtest.model.AlbumModel;
import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.model.bean.TransitionInfo;
import com.yanghaoyi.client_animationtest.presenter.factory.EnterTransitionFactory;
import com.yanghaoyi.client_animationtest.presenter.factory.enu.EnterTransitionType;
import com.yanghaoyi.client_animationtest.presenter.util.AnimationTestUtil;
import com.yanghaoyi.client_animationtest.view.IAlbumView;

import java.util.List;

/**
 * @author : YangHaoYi on 2020/12/21.
 * Email  :  yang.haoyi@qq.com
 * Description : 专辑页面逻辑控制中心
 * Change : YangHaoYi on 2020/12/21.
 * Version : V 1.0
 */
public class AlbumPresenter {

    /** 动画工厂 **/
    private EnterTransitionFactory enterTransitionFactory;
    /** 专辑数据中心 **/
    private AlbumModel albumModel;
    /** 专辑实现View **/
    private IAlbumView albumView;

    public AlbumPresenter(IAlbumView albumView) {
        this.albumView = albumView;
        albumModel = new AlbumModel();
        enterTransitionFactory = new EnterTransitionFactory();
    }

    /** 跳转专辑列表展示页 **/
    public void toAlbumListPage(){
        albumView.toAlbumListPage();
    }

    /** 跳转歌曲列表页面 **/
    public void toSongListPage(){
        AlbumInfo albumInfo = albumModel.getAlbumList().get(albumView.currentSelectItem());
        TransitionInfo transitionInfo = enterTransitionFactory.createTransition(EnterTransitionType.SONG_LIST).produceAnimation();
        addTransitionListener(transitionInfo);
        albumView.toSongListPage(transitionInfo,albumInfo);
    }

    /** 跳转歌词页面 **/
    public void toWordsPage(){
        AlbumInfo albumInfo = albumModel.getAlbumList().get(albumView.currentSelectItem());
        albumView.toWordsPage(enterTransitionFactory.createTransition(EnterTransitionType.WORDS).produceAnimation(),albumInfo);
    }

    /** 跳转菜单页面 **/
    public void toMenuPage(){
        albumView.toMenuPage(enterTransitionFactory.createTransition(EnterTransitionType.MENU).produceAnimation());
    }

    private void addTransitionListener(TransitionInfo transitionInfo){
        transitionInfo.getSharedElementEnterTransition().addListener(new Transition.TransitionListener() {
            @Override
            public void onTransitionStart(@NonNull Transition transition) {
                //no used
            }

            @Override
            public void onTransitionEnd(@NonNull Transition transition) {
                albumView.hideCenterImage();
            }

            @Override
            public void onTransitionCancel(@NonNull Transition transition) {
                //no used
            }

            @Override
            public void onTransitionPause(@NonNull Transition transition) {
                //no used
            }

            @Override
            public void onTransitionResume(@NonNull Transition transition) {
                //no used
            }
        });
    }

}
