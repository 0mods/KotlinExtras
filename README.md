# KotlinExtras

KotlinExtras 1.3 contains the basic libraries for Kotlin:

| Library              | Version  | Sub libraries                                                                                                                                                                                      | Specials        |
|----------------------|----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------|
| Kotlin               | 2.0.0    | `reflect`, `stdlib`, `stdlib-common`, `stdlib-jdk7`, `stdlib-jdk8`                                                                                                                                 |                 |
| Kotlin Coroutines    | 1.9.0-RC | `coroutines-core`, `coroutines-jvm`, `coroutines-jdk8`                                                                                                                                             |                 |
| Kotlin Serialization | 1.7.0    | `serialization-core`, `serialization-json-jvm`, `serialization-json`, `serialization-json-okio`, `serialization-hocon`, `serialization-protobuf`, `serialization-cbor`, `serialization-properties` | Hocon (v 1.6.3) |

## How to Install?


### Repository prepare

<details closed>
<summary>Gradle Kotlin DSL</summary>

```kotlin
repositories {
    maven("https://maven.0mods.team/releases")
}
```
</details>

<details closed>
<summary>Gradle Groovy DSL</summary>

```groovy
repositories {
    maven {
        url "https://maven.0mods.team/releases"
    }
}
```
</details>

### Dependency prepare
<details closed>
<summary>Gradle Kotlin DSL</summary>

```kotlin
dependencies {
    compileOnly("team._0mods:KotlinExtras:kotlin-$ktVersion")
}
```

</details>

<details closed>
<summary>Gradle Groovy DSL</summary>

```groovy
dependencies {
    compileOnly "team._0mods:KotlinExtras:kotlin-${kt_version}"
}
```

</details>
