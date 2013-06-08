androidDouwan
=============

豆玩android平台ANE
* 此ANE可提供aser直接用，无需涉及java端。
* 保留ANE原件 和ANE源码  AS端源码和SWC文件
* 把涉及SDK的jar 文档等去掉（已和官方沟通 官方不允许分享SDK）
*  需要在-app.xml中配置平台方给的appKey 和指定包名才能登录。

## 资源

* 官方网站 [douwan](http://www.douwan.com)
* 未开放下载地址

## 编译方法
*  A复制 SDK的JAR到`build/makeJar` ，运行`combine.bat `合并jar
*  B 复制A中得到的jar到`build/buildANE/Android-ARM`，运行`douwan.bat`得到ANE
*  C 复制B中得到的ANE到 `bulidAPK` 并修改配置 运行`douwan_apk.bat`可生成APK


## 作者

* [platformANEs](https://github.com/platformanes)由 [zrong](http://zengrong.net) 和 [rect](http://www.shadowkong.com/) 共同发起并完成。
