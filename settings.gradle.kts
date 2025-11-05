pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/supabase-kt/maven")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/supabase/maven")
        maven("https://maven.pkg.jetbrains.space/public/p/supabase-kt/maven")

        maven("https://jitpack.io")

    }
}


rootProject.name = "ocdworld"
include(":app")
