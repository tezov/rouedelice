rootProject.name = "client"
include(
    ":app_client",
    ":app_client_shared",
    ":lib_adr_sdk_core",
    ":lib_adr_core",
    ":lib_kmm_core",
)

project(":lib_adr_sdk_core")
    .projectDir = file("../../lib_adr_sdk_core/")
project(":lib_adr_core")
    .projectDir = file("../../lib_adr_core/")
project(":lib_kmm_core")
    .projectDir = file("../../lib_kmm_core/")

pluginManagement {

    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

buildscript {

    repositories {
        mavenLocal()
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }

    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
        classpath("com.tezov:plugin_project:1.0.2")
    }

}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
}

