rootProject.name = "client"
include(
    ":app_client_ios",
    ":app_client_android",
    ":app_client_shared",
    ":lib_adr_app_core",
    ":lib_adr_ui_cpt",
    ":lib_adr_ui_core",
    ":lib_adr_core",
    ":lib_kmm_core",
//    ":lib_test_common",
//    ":lib_test_common_unit",
//    ":lib_test_common_integration",
)

project(":lib_adr_app_core")
    .projectDir = file("../../lib_adr_app_core/")
project(":lib_adr_ui_cpt")
    .projectDir = file("../../lib_adr_ui_cpt/")
project(":lib_adr_ui_core")
    .projectDir = file("../../lib_adr_ui_core/")
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
        classpath("com.tezov:plugin_project:1.0.5")
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

