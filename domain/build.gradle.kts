plugins {
    id("kotlin")
}

dependencies {

    val kotlinVersion: String by rootProject.extra
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    //Coroutines
    val coroutinesVersion = "1.5.0"
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
}