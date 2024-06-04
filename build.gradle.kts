plugins {
    `maven-publish`
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8+"
}

val kotlinVersion: String by project
val shadow: Configuration = configurations["shadow"]

group = "team._0mods"
version = "kotlin-$kotlinVersion"

repositories {
    mavenCentral()
}

configurations {
    implementation.get().extendsFrom(this["shadow"])
}

dependencies {
    val coroutinesVersion: String by project
    val serializationVersion: String by project

    shadow(kotlin("reflect", kotlinVersion))
    shadow(kotlin("stdlib", kotlinVersion))
    shadow(kotlin("stdlib-common", kotlinVersion))
    shadow(kotlinx("coroutines-core", coroutinesVersion))
    shadow(kotlinx("coroutines-core-jvm", coroutinesVersion))
    shadow(kotlinx("coroutines-jdk8", coroutinesVersion))
    shadow(kotlinx("serialization-core", serializationVersion))
    shadow(kotlinx("serialization-json", serializationVersion))
    shadow(kotlinx("serialization-json-jvm", serializationVersion))
    shadow(kotlinx("serialization-json-okio", serializationVersion))
    shadow(kotlinx("serialization-hocon", serializationVersion))
    shadow(kotlinx("serialization-protobuf", serializationVersion))
    shadow(kotlinx("serialization-cbor", serializationVersion))
    shadow(kotlinx("serialization-properties", serializationVersion))
}

tasks.shadowJar {
    archiveClassifier.set("")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    configurations = listOf(shadow)
    exclude(
        "LICENSE.txt", "META-INF/MANIFSET.MF", "META-INF/maven/**",
        "META-INF/*.RSA", "META-INF/*.SF", "META-INF/versions/**"
    )
}

tasks.build.get().finalizedBy("shadowJar")

publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components.getByName("java"))
            artifactId = project.base.archivesName.get()
        }
    }

    repositories {
        maven {
            url = uri("https://maven.0mods.team/releases")
            credentials {
                username = project.properties["mvn_login"].toString()
                password = project.properties["mvn_pass"].toString()
            }
        }
    }
}

fun DependencyHandler.kotlinx(module: String, version: String? = null): Any = kotlinxModule("kotlinx-$module", version)
fun DependencyHandler.kotlinxModule(module: String, version: String? = null): Any = "org.jetbrains.kotlinx:$module${version?.let { ":$version" } ?: ""}"
