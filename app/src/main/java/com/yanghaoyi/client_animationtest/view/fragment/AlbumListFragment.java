package com.yanghaoyi.client_animationtest.view.fragment;

import com.yanghaoyi.client_animationtest.R;
import com.yanghaoyi.client_animationtest.presenter.AlbumPresenter;
import com.yanghaoyi.client_animationtest.view.adapter.AlbumAdapter;
import com.yanghaoyi.client_animationtest.view.custom.ILayoutAnimationController;
import com.yanghaoyi.client_animationtest.view.fragment.base.BaseFragment;
import com.yarolegovich.discretescrollview.DiscreteScrollView;

/**
 * @author : YangHaoYi on 2020/12/22.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/22.
 * Version : V 1.0
 */
public class AlbumListFragment extends BaseFragment {

    private AlbumAdapter albumAdapter;
    private AlbumPresenter albumPresenter;
    /** 专辑列表 **/
    private DiscreteScrollView scrollView;

    @Override
    public int getContentLayout() {
        return R.layout.fragment_album_list;
    }

    @Override
    protected void initView() {
        scrollView = view.findViewById(R.id.rvAlbumList);
    }

    @Override
    protected void initEvent() {
        albumPresenter = new AlbumPresenter(null);
        albumAdapter = new AlbumAdapter(albumPresenter.getAlbumList());
        scrollView.setAdapter(albumAdapter);
        scrollView.setOffscreenItems(5);
        scrollView.scrollToPosition(2);
        ILayoutAnimationController.setLayoutAnimation(scrollView,R.anim.push_down_in,0.8f,ILayoutAnimationController.IndexAlgorithm.MIDDLETOEDGE);
    }

}
