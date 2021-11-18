// Top-level build file where you can add configuration options common to all sub-projects/modules.
import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    id("com.github.ben-manes.versions") version "0.39.0"
}

buildscript {
    extra.apply {
        set("gradleVersion", "7.0.3")
        set("kotlinVersion", "1.6.0")
        set("lifecycleVersion", "2.4.0")
        set("coreKtxVersion", "1.7.0")
        set("koinVersion", "3.1.3")
        set("appCompatVersion", "1.4.0")
        set("constraintLayoutVersion", "2.1.2")
        set("materialVersion", "1.4.0")
        set("coroutinesVersion", "1.5.2")
        set("retrofit2Version", "2.9.0")
        set("okHttpLoggingInterceptorVersion", "4.9.2")
        set("moshiVersion", "1.12.0")
    }
    repositories {
        google()
        mavenCentral()
    }

    val gradleVersion: String by rootProject.extra
    val kotlinVersion: String by rootProject.extra
    dependencies {
        classpath("com.android.tools.build:gradle:$gradleVersion")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}