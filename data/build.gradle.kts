plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = 30
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdk = 26
        targetSdk = 30

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        forEach {
            it.buildConfigField("String", "BASE_URL", "\"https://api.github.com\"")
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

    implementation(project(":domain"))

    val kotlinVersion: String by rootProject.extra
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    //Koin
    val koinVersion = "3.0.2"
    implementation("io.insert-koin:koin-android:$koinVersion")

    //API Client
    val retrofit2Version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit2Version")
    implementation("com.squareup.retrofit2:converter-gson:$retrofit2Version")

    implementation("com.squareup.retrofit2:converter-moshi:$retrofit2Version")

    val okHttpLoggingInterceptorVersion = "4.9.1"
    implementation("com.squareup.okhttp3:logging-interceptor:$okHttpLoggingInterceptorVersion")

    val moshiVersion = "1.12.0"
    implementation("com.squareup.moshi:moshi:$moshiVersion")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:$moshiVersion")
}