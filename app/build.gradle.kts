plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        applicationId = "com.ferraz.felipe.kotlinRepositoriesGithub"
        minSdk = 26
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    buildFeatures {
        viewBinding = true
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

    /*region Modules*/
    implementation(project(":domain"))
    implementation(project(":data"))
    /*endregion*/

    /*region Build Dependencies*/
    //Kotlin
    val kotlinVersion: String by rootProject.extra
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")
    //AndroidX
    implementation("androidx.core:core-ktx:1.6.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    val lifecycleVersion = "2.3.1"
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    //Koin
    val koinVersion = "3.0.2"
    implementation("io.insert-koin:koin-android:$koinVersion")
    //Material
    implementation("com.google.android.material:material:1.4.0")
    /*endregion*/

    /*region Test Dependencies*/
    //Junit
    testImplementation("junit:junit:4.13.2")
    //Android Junit
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    //Espresso
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    /*endregion*/
}