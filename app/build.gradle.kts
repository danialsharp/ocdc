import java.util.Properties





plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
//    id("com.android.application")
    kotlin("plugin.serialization") version "1.9.0"
}

val localProperties = Properties()

val localPropertiesFile = rootProject.file("local.properties")
if (localPropertiesFile.exists()) {
    localProperties.load(localPropertiesFile.inputStream())
}

android {
    namespace = "com.example.ocdworld"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.ocdworld"
        minSdk = 33
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"



        buildConfigField(
            "String",
            "SUPABASE_URL",
            "\"${localProperties["SUPABASE_URL"]}\""
        )
        buildConfigField(
            "String",
            "SUPABASE_ANON_KEY",
            "\"${localProperties["SUPABASE_ANON_KEY"]}\""
        )


    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}




dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation("com.google.code.gson:gson:2.10.1")
   // implementation ("com.google.android.material:material:1.9.0")
    implementation ("androidx.compose.material3:material3:1.1.2")
    implementation ("com.google.android.material:material:1.11.0")
    implementation("com.github.PhilJay:MPAndroidChart:v3.1.0")
    implementation("androidx.compose.ui:ui:1.6.1")
    implementation("androidx.compose.material:material:1.6.1")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.1")
    implementation("io.github.jan-tennert.supabase:gotrue-kt:1.4.5")






    implementation("androidx.core:core-splashscreen:1.0.1")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("androidx.compose.foundation:foundation:1.4.3") // Or your version
    // bring in the BOM for version management

    val ktorVersion = "2.3.3"

    implementation("io.ktor:ktor-client-core:$ktorVersion")
     // or ktor-client-okhttp if you prefer
    implementation("io.ktor:ktor-client-content-negotiation:$ktorVersion")
    implementation("io.ktor:ktor-serialization-kotlinx-json:$ktorVersion")
    implementation("io.ktor:ktor-client-plugins:2.3.5")
    implementation("io.ktor:ktor-client-android:2.3.5")

    implementation("io.ktor:ktor-client-core:2.3.5")
    implementation("io.ktor:ktor-client-okhttp:2.3.5")

    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.5")
    implementation("io.ktor:ktor-client-logging:2.3.5")
    // ✅ Add this line











    // implementation("io.ktor:ktor-client-android:3.1.3")
  //  implementation("io.ktor:ktor-client-core:3.1.3")
    implementation("io.ktor:ktor-client-okhttp:3.1.3")
    //implementation("io.ktor:ktor-client-content-negotiation:3.1.3")
    //implementation("io.ktor:ktor-serialization-kotlinx-json:3.1.3")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")







    //implementation("io.ktor:ktor-client-cio:2.3.3")
    //implementation("io.ktor:ktor-client-plugins:2.3.3")



    implementation("io.ktor:ktor-client-content-negotiation:3.1.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:3.1.3")
    implementation("io.ktor:ktor-client-okhttp:2.3.4")
    implementation(platform("io.github.jan-tennert.supabase:bom:3.1.4"))
    implementation("io.github.jan-tennert.supabase:supabase-kt:3.1.4") // Main client
   // implementation("io.github.jan-tennert.supabase:gotrue-kt:3.1.4")    // Auth module (✅ REQUIRED)


    // In your dependencies block:

    implementation("io.github.jan-tennert.supabase:auth-kt")
    implementation("io.github.jan-tennert.supabase:postgrest-kt")
    implementation("io.github.jan-tennert.supabase:realtime-kt")












}

kotlin {
    sourceSets.all {
        languageSettings.optIn("kotlinx.serialization.ExperimentalSerializationApi")
    }
}













