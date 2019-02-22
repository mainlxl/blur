# 高斯模糊Bitmap

![动画](/image/donghua.gif)

算法使用的是`intel`的**[IIR](https://software.intel.com/en-us/articles/iir-gaussian-blur-filter-implementation-using-intel-advanced-vector-extensions)**

## 效率
效率还是蛮快的,一图胜千言(release版so库)
1. 测试设备选用Nexus 6P(CPU:骁龙810 , RAM:3G)
2. 测试图片选用800x991分辨率

![log](/image/blur.jpg)

debug包中模糊效率稍慢,请使用release包测试

## 用法
1. 使用源码库 <br/>

    ```
    //在项目根目录中添加maven地址
    allprojects {
        repositories {
            maven { url "https://raw.githubusercontent.com/Android-Mainli/Maven/master" }
        }
    }
    //在项目module中添加依赖
    implementation 'com.mainli:blur:1.0.0'
    ```

2. 使用**源码+so**
   1. [SO库](/outLibs/jni)
   2. 直接粘贴`BitmapBlur`类使用注意包名一定要是com.mainli.blur

3. 使用**AAR**
  1. [点击下载AAR](/outLibs/blur-release.aar)
  2. 建议在app的`build.gradle`的`android`下的`defaultConfig`中加入`ndk`标签标明支持的平台版本<br/>**aar中默认添加有'armeabi', 'armeabi-v7a', 'arm64-v8a', 'mips', 'mips64', 'x86', 'x86_64'**

  ```java
  android {
    	省略...
    defaultConfig {
  	省略...
        ndk {
  		//可选 可只是用'armeabi-v7a'
            abiFilters 'armeabi','armeabi-v7a','arm64-v8a'
        }
        省略...
    }
  ```
  4.用法
  ```java
  	//blur方法默认修改bitmap中数据,调用完成功后(btm == bitmap 二者为同一对象)
  	 Bitmap btm = BitmapBlur.blur(bitmap, intensity)
  ```