# android-reverse-engine
Android Reverse Experimental Project

需要的工具，有 [apktool](https://ibotpeaches.github.io/Apktool/)、[dex2jar](https://sourceforge.net/projects/dex2jar/)、[jd-gui](http://java-decompiler.github.io/)


##### current local version of apktool.jar is 2.4.1

1. 将apktool和apktool.jar所在的路径设置到classpath中
2. 执行将apk文件unzip
3. d2j-dex2jar xxx/classes.dex
4. 生成的classes-dex2jar.jar通过 jd-gui工具打开