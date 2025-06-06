# 高斯模糊Bitmap

[![](https://jitpack.io/v/mainlxl/blur.svg)](https://jitpack.io/#mainlxl/blur)

![动画](/image/donghua.gif)

算法使用的是`intel`的**[IIR](https://software.intel.com/en-us/articles/iir-gaussian-blur-filter-implementation-using-intel-advanced-vector-extensions)**

## 效率
效率还是蛮快的(release版so库)
1. 测试设备选用Nexus 6P(CPU:骁龙810 , RAM:3G)
2. 测试图片选用800x991分辨率

| 强度 | 用间(ms) |
|:---:|:---:|
| 5  |   101 |
| 10 |   103 |
| 15 |   105 |
| 20 |   96  |
| 25 |   101 |

1. 测试设备选用Mi 10s(CPU:骁龙870 , RAM:8+3G)
3. 测试图片选用800x991分辨率

| 强度 | 用间(ms) |
|:---:|:---:|
| 5  |   76 |
| 10 |   60 |
| 15 |   60 |
| 20 |   42  |
| 25 |   43 |

debug包中模糊效率稍慢,请使用release包测试 [apk](/app.apk)

so库文件很小
lib
├── arm64-v8a
│   └── [ 14K]  libblur-lib.so
├── armeabi-v7a
│   └── [ 17K]  libblur-lib.so
├── x86
│   └── [ 13K]  libblur-lib.so
└── x86_64
    └── [ 14K]  libblur-lib.so

## 用法
1. 依赖<br/>

    ```
    //在项目根目录中添加maven地址
    allprojects {
        repositories {
            maven { url 'https://jitpack.io' }
        }
    }
    //在项目module中添加依赖
    implementation 'com.github.mainlxl:blur:version'
    ```

2. 减少依赖so库数量，默认aar中添加有'armeabi', 'armeabi-v7a', 'arm64-v8a', 'mips', 'mips64', 'x86', 'x86_64'.

  在app的`build.gradle`的`android`下的`defaultConfig`中加入`ndk`标签标明支持的平台版本，以减少依赖的so数量<br/>
  

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

3. code中使用

  ```java
  	//blur方法默认修改bitmap中数据,调用完成功后(btm == bitmap 二者为同一对象)
  	 Bitmap btm = BitmapBlur.blur(bitmap, intensity)
  ```
