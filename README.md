# My first Scala Android project

This is a Scala implementation of [the Android tutorial](http://developer.android.com/training/basics/firstapp/index.html).

What you need to do to make it work ...

* install sbt (e.g. `sudo port install sbt`)
* install ant (e.g. `sudo port install apache-ant`)
* install the Android SDK and download platform level 19 (this is the one I am using)
* clone this repo to `<dir of your choice>`
* you either need to set ANDROID_HOME or you need to run `android project update -p <dir of your choice>/scala-android-first`
* create an [avd](http://developer.android.com/tools/devices/managing-avds-cmdline.html) and start the emulator (this can take a while)
    * `android avd create --name MyFirstAvd --target "Google Inc.:Google APIs:19"`
    * `emulator -avd MyFirstAvd -gpu on`
* copy `android-support-v4.jar` from `${ANDROID_HOME}/extras/android/support/v4` into `<dir of your choice>/scala-android-first/libs`
* run `sbt compile` and `ant debug`
* run `adb install -r bin/MyFirstApp-debug.apk`
* open `My First App` on the emulator
* watch what is going on with `adb shell logcat FirstActivity:D DisplayMessageActivity:D *:S`

... and you should be in business.

## v1.1-basic

* ProGuard seems to remove a couple of Scala classes that are needed. For the time being I am just telling Proguard to notOptimize
* Added a simple navigation bar
* BTW ... instead of running compile, build and install in 3 seperate steps you can also just use the `install` or `run` task with sbt (or even better just use `sbt ~run`)

## v1.2-basic

* Fixed the README and using `s"..."` to format the debug messages (only works after fixing the ProGuard issue)
