## Issue_1：视图动画，ViewGroup元素入场动画
android:layoutAnimation：
android:animateLayoutChanges
效果：在一个页面启动后，叶页面中的元素挨个执行入场动画。即在ViewGroup添加一个入场动画，ViewGroup的所有子元素都会按照设计的顺序执行一遍。
上面两个配合使用
同理，也可在代码中实现，代码中动态设置动画
private fun startTitleAnimation(vararg v: View) {
    val animation = AnimationUtils.loadAnimation(this, R.anim.anim_guide_sub_item)
    v.forEach {
        it.startAnimation(animation)
    }
}

## Issue_2：Assets文件夹中文件的路径
路径为"file:///android_asset/"
但是不存在绝对路径。val file = File("file:///android_asset/news.css")。file.exists()返回false
