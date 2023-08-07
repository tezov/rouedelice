tezovConfig {
    configuration {
        domain = tezovCatalog.string("domain")
    }
    version {
        major = 0
        minor = 1
        patch = 0
    }
    configureAndroidPlugin()
}

android {
    tezovCatalog {
        with("projectVersion") {
            compileSdk = int("defaultCompileSdk")
            compileOptions {
                sourceCompatibility = javaVersion("javaSource")
                targetCompatibility = javaVersion("javaTarget")
            }
            kotlinOptions {
                jvmTarget = javaVersion("jvmTarget").toString()
            }
            defaultConfig {
                multiDexEnabled = true
                minSdk = int("defaultMinCompileSdk")
                targetSdk = int("defaultTargetCompileSdk")
            }
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = string("composeCompiler")
            }
        }
        packaging {
            resources {
                stringListOrNull("resourcesExcluded")?.let {
                    excludes.addAll(it)
                }
            }
        }
    }
    buildTypes {
        getByName("release") {

        }
        getByName("debug") {

        }
    }
}

dependencies {
    implementation(project(":app_client_shared"))
    implementation(project(":lib_adr_sdk_core"))
    tezovCatalog {
        with("projectPath.dependencies.adr_core") {
            implementation(string("dagger"))
            kapt(string("dagger_kapt"))
        }
        with("projectPath.dependencies_debug.adr_compose") {
            implementation(string("ui_tooling_preview"))
            debugImplementation(string("ui_tooling"))
            debugImplementation(string("ui_manifest"))
        }
    }
}