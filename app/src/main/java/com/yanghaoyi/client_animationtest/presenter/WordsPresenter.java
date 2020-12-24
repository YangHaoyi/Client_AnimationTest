package com.yanghaoyi.client_animationtest.presenter;

import com.yanghaoyi.client_animationtest.model.bean.AlbumInfo;
import com.yanghaoyi.client_animationtest.presenter.evnet.ImageChangeEvent;
import com.yanghaoyi.client_animationtest.view.IWordsView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import static com.yanghaoyi.client_animationtest.presenter.util.AnimationConstants.SELECT_NONE;

/**
 * @author : YangHaoYi on 2020/12/24.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/24.
 * Version : V 1.0
 */
public class WordsPresenter {

    private List<AlbumInfo> albumInfoList;
    private IWordsView wordsView;
    private int currentSelect = SELECT_NONE;

    public WordsPresenter(IWordsView wordsView,List<AlbumInfo> albumInfoList,int currentSelect) {
        this.wordsView = wordsView;
        this.albumInfoList = albumInfoList;
        this.currentSelect = currentSelect;
    }

    public void toPrevious(){
        if (currentSelect > 0) {
            wordsView.showAlbum(albumInfoList.get(currentSelect - 1));
            currentSelect = currentSelect - 1;
            sendEvent();
        }else {
            wordsView.showToastAlreadyFirst();
        }
    }

    public void toNext(){
        if (currentSelect >= albumInfoList.size() - 1) {
            wordsView.showToastAlreadyLast();
        }else {
            wordsView.showAlbum(albumInfoList.get(currentSelect +1));
            currentSelect = currentSelect + 1;
            sendEvent();
        }
    }

    private void sendEvent(){
        ImageChangeEvent imageChangeEvent = new ImageChangeEvent();
        imageChangeEvent.setPosition(currentSelect);
        EventBus.getDefault().post(imageChangeEvent);
    }
}
