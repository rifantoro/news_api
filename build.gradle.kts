// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    //ext.kotlin_version = "1.9.0" // Use the version of Kotlin you want
    dependencies {
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
        classpath ("com.android.tools.build:gradle:8.1.2")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
    }
}

plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}