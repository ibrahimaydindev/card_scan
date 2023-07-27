plugins {
    `maven-publish`
}

val implementation by configurations.creating

dependencies {
    implementation("androidx.databinding:viewbinding:7.4.0")
    implementation("androidx.core:core-ktx:1.10.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.android.gms:play-services-mlkit-face-detection:17.1.0")
    implementation("androidx.camera:camera-core:1.3.0-alpha06")
    implementation("androidx.camera:camera-camera2:1.3.0-alpha06")
    implementation("androidx.camera:camera-lifecycle:1.3.0-alpha06")
    implementation("androidx.camera:camera-video:1.3.0-alpha06")
    implementation("androidx.camera:camera-view:1.3.0-alpha06")
    implementation("androidx.camera:camera-extensions:1.3.0-alpha06")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("com.google.android.gms:play-services-mlkit-text-recognition:19.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("com.google.mlkit:text-recognition:16.0.0")
    implementation("com.google.mlkit:text-recognition-korean:16.0.0")
    implementation("com.google.mlkit:face-detection:16.1.5")
    implementation("com.google.mlkit:image-labeling:17.0.7")
    implementation("com.google.android.gms:play-services-mlkit-image-labeling:16.0.8")
    implementation("com.google.android.gms:play-services-vision:20.1.3")
    implementation("com.google.guava:guava:30.1.1-jre")
    implementation("cz.adaptech.tesseract4android:tesseract4android:4.4.0")
    implementation("com.google.firebase:firebase-firestore-ktx:24.4.5")
}

publishing {
    publications {
        create<MavenPublication>("android") {
            groupId = "com.texinsight"
            artifactId = "newky_scanner-debug"
            version = "1.0"

            artifact("newky_scanner-debug.aar") {
                extension = "aar"
            }

            pom {
                packaging = "aar"

                withXml {
                    val dependenciesNode = asNode().appendNode("dependencies")

                    implementation.allDependencies.configureEach {
                        val dependencyNode = dependenciesNode.appendNode ("dependency")
                        dependencyNode.appendNode("groupId", this.group)
                        dependencyNode.appendNode("artifactId", this.name)
                        dependencyNode.appendNode("version", this.version)
                    }
                }
            }
        }
    }
}

// just dummy task for jitpack
tasks.create("assemble")
