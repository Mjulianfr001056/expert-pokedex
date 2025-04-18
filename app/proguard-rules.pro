# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-keep class com.example.library.** { *; }
-keep interface com.example.library.** { *; }

##############################################
# KOTLIN STANDARD + REFLECTION
##############################################
-keep class kotlin.** { *; }
-keepclassmembers class ** {
    @kotlin.Metadata *;
}
-dontwarn kotlin.**
-dontwarn kotlinx.coroutines.**

##############################################
# KOIN (Dependency Injection)
##############################################
-keep class org.koin.** { *; }
-keep class *.Module
-keepclassmembers class * {
    public <init>(...);
}
-dontwarn org.koin.**

##############################################
# ROOM (Database ORM)
##############################################
-keep class androidx.room.** { *; }
-keepclassmembers class * {
    @androidx.room.** <methods>;
}
-dontwarn androidx.room.**

##############################################
# SQLCIPHER (Encrypted DB)
##############################################
-keep class net.sqlcipher.** { *; }
-dontwarn net.sqlcipher.**

##############################################
# KTOR (Networking)
##############################################
-keep class io.ktor.** { *; }
-dontwarn io.ktor.**

-keep class kotlinx.serialization.** { *; }
-keep @kotlinx.serialization.Serializable class ** { *; }
-dontwarn kotlinx.serialization.**

##############################################
# COIL (Image Loading) - Version 3+
##############################################

-keep class coil3.** { *; }
-keepclassmembers class coil3.** {
    public <init>(...);
}
-keepnames class coil3.** { *; }

-keep class coil3.PlatformContextKt { *; }

-dontwarn coil3.**

##############################################
# JETPACK NAVIGATION & COMPOSE
##############################################
-keep class androidx.navigation.** { *; }
-dontwarn androidx.navigation.**

-keep class androidx.compose.** { *; }
-dontwarn androidx.compose.**

-keep class androidx.ui.** { *; }
-dontwarn androidx.ui.**

##############################################
# LEAKCANARY
##############################################
-dontwarn com.squareup.leakcanary.**

##############################################
# LOGGING (org.lighthousegames)
##############################################
-keep class org.lighthousegames.logging.** { *; }
-dontwarn org.lighthousegames.logging.**
