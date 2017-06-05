# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/huzongyao/software/android-sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
#混淆输出日志见build/outputs/mapping/release目录
#dump.txt 包内所有 class 的内部结构
#mapping.txt 混淆前后的映射
#usage.txt 列出从 apk 中删除的代码
#seeds.txt 未混淆的类和成员

-keepattributes Exceptions,InnerClasses,Signature

# system library
-dontwarn android.support.**

-keepclassmembers class **.R$* {
    public static *;
}

# 保持 native 方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}

# 保持枚举 enum 类不被混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# 保持 Parcelable 不被混淆
-keep class * implements android.os.Parcelable {
    public static final android.os.Parcelable$Creator *;
}

-keep class android.support.** {*;}
