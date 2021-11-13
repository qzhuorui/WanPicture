# PlayerView

## XML属性介绍
    1. app:show_buffering：Whether the buffering spinner is displayed when the player is buffering.
        Valid values are never, when_playing and always
    2. app:surface_type：The type of surface view used for video playbacks。常用surface_view
    3. app:use_controller：Sets whether the playback controls can be shown.

## 使用问题
    1. MediaItem和MediaSource区别。
        跟踪源码发现add MediaItem，和MediaSource一样的添加方式，区别在于index不同。具体表现还需要后面验证。
