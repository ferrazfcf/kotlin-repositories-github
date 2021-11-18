plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    compileSdk = 31
    buildToolsVersion = "31.0.0"

    defaultConfig {
        applicationId = "com.ferraz.felipe.kotlinRepositoriesGithub"
        minSdk = 26
        targetSdk = 31
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
        jvmTarget = JavaVersion.VERSION_11.toString()
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
    val coreKtxVersion: String by rootProject.extra
    implementation("androidx.core:core-ktx:$coreKtxVersion")
    val appCompatVersion: String by rootProject.extra
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    val constraintLayoutVersion: String by rootProject.extra
    implementation("androidx.constraintlayout:constraintlayout:$constraintLayoutVersion")
    val lifecycleVersion: String by rootProject.extra
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycleVersion")

    //Koin
    val koinVersion: String by rootProject.extra
    implementation("io.insert-koin:koin-android:$koinVersion")

    //Material
    val materialVersion: String by rootProject.extra
    implementation("com.google.android.material:material:$materialVersion")
    /*endregion*/

    /*region Test Dependencies*/
    //Junit
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")
    //Android Junit
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    //Espresso
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    /*endregion*/
}