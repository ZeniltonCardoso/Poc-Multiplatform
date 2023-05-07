plugins {
    alias(deps.plugins.android.application)
    kotlin("android")
}

android {
    namespace = "br.com.pocmultiplatform.android"
    compileSdk = deps.versions.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "br.com.pocmultiplatform.android"
        minSdk = deps.versions.minSdk.get().toInt()
        targetSdk = deps.versions.targetSdk.get().toInt()
        versionCode = deps.versions.versionCode.get().toInt()
        versionName = deps.versions.versionName.get()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(deps.bundles.compose.tooling)
    implementation(deps.activity.compose)
}