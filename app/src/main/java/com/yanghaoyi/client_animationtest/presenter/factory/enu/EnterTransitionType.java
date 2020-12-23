package com.yanghaoyi.client_animationtest.presenter.factory.enu;

import com.yanghaoyi.client_animationtest.presenter.factory.IEnterTransition;
import com.yanghaoyi.client_animationtest.presenter.factory.MenuEnterTransition;
import com.yanghaoyi.client_animationtest.presenter.factory.SongListEnterTransition;
import com.yanghaoyi.client_animationtest.presenter.factory.WordsEnterTransition;

/**
 * @author : YangHaoYi on 2020/12/21.
 * Email  :  yang.haoyi@qq.com
 * Description :
 * Change : YangHaoYi on 2020/12/21.
 * Version : V 1.0
 */
public enum EnterTransitionType {
    SONG_LIST(1,"歌曲列表", SongListEnterTransition.class),
    WORDS(2,"歌词", WordsEnterTransition.class),
    MENU(4,"菜单", MenuEnterTransition.class);

    private int code;
    private Class<IEnterTransition> clazz;


    EnterTransitionType(int code, String name, Class clazz) {
        this.code = code;
        this.clazz = clazz;
    }

    public int getCode() {
        return code;
    }

    public static IEnterTransition get(int code) throws IllegalAccessException, InstantiationException {
        EnterTransitionType[] values = EnterTransitionType.values();
        for (int i = 0; i != values.length; i++) {
            if (values[i].code == code) {
                Class n = values[i].clazz;

                return (IEnterTransition) n.newInstance();
            }
        }
        return null;
    }
}
