# Blur Bitmap

算法使用的是`IIR`,咱们用的是修改自[落羽の殇博客](https://www.cnblogs.com/tntmonks/p/5291660.html)中的源码

## 效率
效率还是蛮快的,一图胜千言

![效率](/image/blur.png)

## 用法
1. 使用源码库 <br/>

    `compile project(':blur-lib')`

2. 使用jcenter

    `还没上传,有时间再上传`

3. 使用so(暂时只提供armeabi和armeabi-v7a)

   1. [SO库](../so)
   2. 直接粘贴`BitmapBlur`类使用注意包名一定要是com.mainli.blur