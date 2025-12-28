This is a Kotlin Multiplatform project targeting Android, iOS.

* [/composeApp](./composeApp/src) is for code that will be shared across your Compose Multiplatform applications.
  It contains several subfolders:
  - [commonMain](./composeApp/src/commonMain/kotlin) is for code that’s common for all targets.
  - Other folders are for Kotlin code that will be compiled for only the platform indicated in the folder name.
    For example, if you want to use Apple’s CoreCrypto for the iOS part of your Kotlin app,
    the [iosMain](./composeApp/src/iosMain/kotlin) folder would be the right place for such calls.
    Similarly, if you want to edit the Desktop (JVM) specific part, the [jvmMain](./composeApp/src/jvmMain/kotlin)
    folder is the appropriate location.

* [/iosApp](./iosApp/iosApp) contains iOS applications. Even if you’re sharing your UI with Compose Multiplatform,
  you need this entry point for your iOS app. This is also where you should add SwiftUI code for your project.

### Build and Run Android Application

To build and run the development version of the Android app, use the run configuration from the run widget
in your IDE’s toolbar or build it directly from the terminal:
- on macOS/Linux
  ```shell
  ./gradlew :composeApp:assembleDebug
  ```
- on Windows
  ```shell
  .\gradlew.bat :composeApp:assembleDebug
  ```

### Build and Run iOS Application

To build and run the development version of the iOS app, use the run configuration from the run widget
in your IDE’s toolbar or open the [/iosApp](./iosApp) directory in Xcode and run it from there.

---

Learn more about [Kotlin Multiplatform](https://www.jetbrains.com/help/kotlin-multiplatform-dev/get-started.html)…

# App demo

[Screen_recording_20251217_153353.webm](https://github.com/user-attachments/assets/add42e0b-4995-47e0-b5ca-fcf942326108)

[Screen_recording_20251217_163804.webm](https://github.com/user-attachments/assets/8d87788c-c863-4a34-bd7f-39f87ebf2773)

[Screen_recording_20251218_130115.webm](https://github.com/user-attachments/assets/4ff64958-5c44-42d8-bb41-4043ff95ae16)

* Support large screens like tablets with ListSceneStrategy
  
<img width="2424" height="1080" alt="Screenshot_20251228_163841" src="https://github.com/user-attachments/assets/c72427ba-2487-4893-9ffe-4f21cbcb78e3" />

* Support restore data on back clicked with ResultStore
  
<img width="500" height="800" alt="Screenshot_20251228_171652" src="https://github.com/user-attachments/assets/ac3466e1-053c-4ca0-9226-8e3e90dcfaca" />
<img width="500" height="800" alt="Screenshot_20251228_171715" src="https://github.com/user-attachments/assets/2a977d93-9f2b-4ad6-87c6-4334b232e51f" />
<img width="500" height="800" alt="Screenshot_20251228_171947" src="https://github.com/user-attachments/assets/39cf4db9-81ff-41d2-be7f-fab4f443ac4e" />



