# Blur Bitmap

算法使用的是`intel`的**[IIR](https://software.intel.com/en-us/articles/iir-gaussian-blur-filter-implementation-using-intel-advanced-vector-extensions)**

## 效率
效率还是蛮快的,一图胜千言

![效率](/image/blur.png)

## 用法
1. 使用源码库 <br/>

    `compile project(':blur-lib')`

2. 使用**源码+so**
   1. [SO库下载](/so)
   2. 直接粘贴`BitmapBlur`类使用注意包名一定要是com.mainli.blur

3. 使用**AAR**
	1. [点击下载AAR](/so/blur-1.0.aar)
	2. 建议在app的`build.gradle`的`android`下的`defaultConfig`中加入`ndk`标签标明支持的平台版本<br/>**aar中默认添加有'armeabi', 'armeabi-v7a', 'arm64-v8a', 'mips', 'mips64', 'x86', 'x86_64'**

	```
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
	```
		//blur方法默认修改bitmap中数据,调用完成功后(btm == bitmap 二者为同一对象)
		 Bitmap btm = BitmapBlur.blur(bitmap, intensity)
	```