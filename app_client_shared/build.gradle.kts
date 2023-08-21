plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "17"
            }
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "summary:app_client_shared"
        homepage = "https://www.githib.com/tezov"
        version = "0.0.1"
        ios.deploymentTarget = "13.0"
        podfile = project.file("../Podfile")
        framework {
            baseName = "app_client_shared"
        }
    }
}

android {
    namespace = "com.tezov.rouedelice.client"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}