# 基于共享元素与Transition过渡动画实现的音乐播放器动效
简书文章地址：https://www.jianshu.com/p/66bbc46934c7
#SharedElement共享元素
Andriod 5.0开始支持共享元素动画，该动画主要应用于多个页面之间共享控制某些控件。比如某个控件在Page_A中在位置1，在Page_B中在位置2，当页面A与页面B发生页面跳转当时候，控件可以在共享元素的支持下自动从A页面的位置1，移动到页面B的位置2。
####实现步骤
1.在xml布局中给控件元素设置共享属性
```
android:transitionName="@string/iv_album"
```
2.设置共享动画类型
```
songListFragment.setSharedElementEnterTransition(transitionInfo.getSharedElementEnterTransition());
```
3.添加共享元素
```
addSharedElement(viewHolder.getIvAlbum(),shareAlbum)
```
#Transition过渡动画
Transition 是指不同 UI 状态转换时的动画。其中有两个关键概念：场景（scenes）和转换（transitions）。场景定义了一个确定的 UI 状态，而转换定义了两个场景切换时的动画。

当发生场景转换时，会有如下两个行为：

（1）确定开始场景和结束场景中 view 的状态（位置、大小、旋转等）。

（2）根据状态差异创建 Animator，用以场景切换时 view 的动画。
####动画类型

| 序号        | 系统Transition          | 简介  |
| :-------: |:-------------------:| :-----:| 
| 1    | ChangeBounds | 检测View的位置边界创建移动和缩放动画(关注布局边界的变化) ，捕获共享元素的layout bound，然后播放layout bound变化动画。|
| 2    | ChangeTransform| 检测View的scale和rotation创建缩放和旋转动画(关注scale和ratation的变化)，捕获共享元素的缩放（scale）与旋转（rotation）属性 ，然后播放缩放（scale）与旋转（rotation）属性变化动画。 |  
| 3 | ChangeClipBounds|    检测View的剪切区域的位置边界，针对的是view的剪切区域，捕获共享元素clip bounds，然后播放clip bounds变化动画|
| 4 | ChangeImageTransform|    检测ImageView的ScaleType，并创建相应动画(关注的是ImageView的scaleType)，捕获共享元素（ImageView）的transform matrices 属性，然后播放ImageViewtransform matrices 属性变化动画。与ChangeBounds相结合，这个变换可以让ImageView在动画中高效实现大小，形状或者ImageView.ScaleType属性平滑过度。|
| 5 | Fade|    根据View的visibility状态的的不同创建淡入淡动画,调整的是透明度(关注的是View的visibility的状态)|
| 6 | Slide|    根据View的visibility状态的的不同创建滑动动画(关注的是View的visibility的状态)|
| 7 | Explode|    根据View的visibility状态的的不同创建分解动画(关注的是View的visibility的状态)|
| 8 | AutoTransition|    默认动画，ChangeBounds、Fade动画的集合|


#开发实例
简单了解了共享元素与过渡动画的基础使用方法后，我们用几个简单的小例子来加深一下对共享元素结合过渡动画对具体使用。
####专辑平移转场
页面A是专辑列表页面，歌曲专辑通过RecyclerView实现，通过点击按钮，实现中心专辑图片平移到页面B，其他专辑以纵向文字列表展示。

![歌曲列表.gif](https://upload-images.jianshu.io/upload_images/7034854-2f0e08625c375978.gif?imageMogr2/auto-orient/strip)

实现方法
1.为页面A中心图片设置共享属性
```
    <ImageView
        android:id="@+id/ivAlbum"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:layout_gravity="center"
        android:transitionName="@string/iv_album" />
```
2.在页面B同步添加共享属性（图片尺寸可以随意修改，专场过渡动画可以实现图片到自动缩放）。
```
    <ImageView
        android:layout_marginTop="80dp"
        android:id="@+id/ivAlbum"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:layout_marginLeft="30dp"
        android:transitionName="@string/iv_album" />
```
3.编写共享元素动画
因为A、B两个页面是切换仅用来简单是图片位置平移，所以ChangeBounds即可满足我们的功能。
4.设置页面切换动画
从Gif中可以看到，A页面到B页面切换工程中，除了有共享图片平移外，还有页面整体的右向左移动，使这个动画效果更连贯，这里使用到了页面切换Slide动画，可以通过Gravity调节页面进入的方向。
```
public class SongListEnterTransition implements IEnterTransition{

    /** 动画时间 **/
    private static final int DURATION = 1500;

    @Override
    public TransitionInfo produceAnimation() {
        TransitionInfo transitionInfo = new TransitionInfo();
        //设置专场动画
        Slide slide = new Slide(Gravity.RIGHT);
        slide.setDuration(DURATION);
        //设置共享元素动画
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(DURATION);
        transitionInfo.setEnterTransition(slide);
        transitionInfo.setSharedElementEnterTransition(changeBounds);
        return transitionInfo;
    }
}
```
5.Fragment添加过场动画（默认情况下Fragment没有过场动画，我们需要添加我们之前设置好的自定义专场动画与共享元素动画）
```
    /**
     * 跳转歌曲列表页
     * @param transitionInfo 动画列表
     * @param albumInfoList 共享专辑信息
     * **/
    @Override
    public void toSongListPage(TransitionInfo transitionInfo,List<AlbumInfo> albumInfoList,int currentIndex) {
        this.albumInfoList = albumInfoList;
        this.hideIndex = currentIndex;
        showCenterImage();
        SongListFragment songListFragment = SongListFragment.newInstance(albumInfoList,currentIndex);
        songListFragment.setEnterTransition(transitionInfo.getEnterTransition());
        songListFragment.setAllowEnterTransitionOverlap(true);
        songListFragment.setAllowReturnTransitionOverlap(false);
        songListFragment.setSharedElementEnterTransition(transitionInfo.getSharedElementEnterTransition());
        context.getSupportFragmentManager().beginTransaction()
                .replace(R.id.fmContent,songListFragment)
                .addToBackStack(null)
                .addSharedElement(viewHolder.getIvAlbum(),shareAlbum)
                .commitAllowingStateLoss();
    }
```
6.通过Bundle传递共享元素参数属性，在页面B进行展示（共享元素并非真正的将A页面元素共享给页面B，其共享原理会在后文介绍）。
```
albumInfoList = (List<AlbumInfo>) getArguments().getSerializable(EXTRA_SAMPLE);
currentIndex = getArguments().getInt(INDEX);
albumInfo = albumInfoList.get(currentIndex);
ivAlbum.setBackground(getActivity().getResources().getDrawable(albumInfo.getPicture()));
```
####专辑放大转场
页面A是专辑列表页面，歌曲专辑通过RecyclerView实现，通过点击按钮，实现中心专辑图片放大到全屏展示到页面B。

![专辑放大.gif](https://upload-images.jianshu.io/upload_images/7034854-8dd86db9a1173a40.gif?imageMogr2/auto-orient/strip)

除过场动画设置外，其余步骤相同，过场动画设置如下：
```
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
```
####按钮缩放转场
页面A中有一个按钮，点击后按钮放大到全屏显示并过渡到页面B，当页面B退出，按钮从全屏缩小到页面A原始按钮大小显示。

![按钮缩放.gif](https://upload-images.jianshu.io/upload_images/7034854-cefb984a397f8b67.gif?imageMogr2/auto-orient/strip)

除过场动画设置外，其余步骤相同，过场动画设置如下：
```
public class MenuEnterTransition implements IEnterTransition{

    /** 动画时间 **/
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
```
#共享元素原理
前文提及过当页面从A跳转到B后，还需要在B页面中重新设定页面的各项属性，例如image的url。所以共享元素并非是真的将A中的元素拿出去给B，而是将元素在A中的位置告诉给B，然后由B完成位置移动，造成元素从A共享过渡到B的过程。

