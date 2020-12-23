# 基于共享元素与Transition过渡动画实现的音乐播放器动效

##共享元素

Andriod 5.0及之后，开始支持共享元素动画，该动画主要用于两个页面之间，两个页面可以共享某些控件。
核心代码，在要共享的控件中加上transitionName属性。
```
  android:transitionName="@string/square_blue_name"
```

##Transition动画

| 序号        | 系统Transition          | 内存占用峰值  |
| :-------: |:-------------:| :-----:| 
| 1    | ChangeBounds | 检测View的位置边界创建移动和缩放动画(关注布局边界的变化) |
| 2    | ChangeTransform| 检测View的scale和rotation创建缩放和旋转动画(关注scale和ratation的变化) |  
| 3 | ChangeClipBounds|    检测View的剪切区域的位置边界，针对的是view的剪切区域|
| 4 | ChangeImageTransform|    检测ImageView的ScaleType，并创建相应动画(关注的是ImageView的scaleType)|
| 5 | Fade|    根据View的visibility状态的的不同创建淡入淡动画,调整的是透明度(关注的是View的visibility的状态)|
| 6 | Slide|    根据View的visibility状态的的不同创建滑动动画(关注的是View的visibility的状态)|
| 7 | Explode|    根据View的visibility状态的的不同创建分解动画(关注的是View的visibility的状态)|
| 8 | AutoTransition|    默认动画，ChangeBounds、Fade动画的集合|

##实现效果

专辑列表

![image](https://github.com/YangHaoyi/Client_AnimationTest/blob/main/app/gif/%E4%B8%93%E8%BE%91%E5%88%97%E8%A1%A8.gif)

专辑放大

![image](https://github.com/YangHaoyi/Client_AnimationTest/blob/main/app/gif/%E4%B8%93%E8%BE%91%E6%94%BE%E5%A4%A7.gif)

按钮缩放

![image](https://github.com/YangHaoyi/Client_AnimationTest/blob/main/app/gif/%E6%8C%89%E9%92%AE%E7%BC%A9%E6%94%BE.gif)

歌曲列表

![image](https://github.com/YangHaoyi/Client_AnimationTest/blob/main/app/gif/%E6%AD%8C%E6%9B%B2%E5%88%97%E8%A1%A8.gif)