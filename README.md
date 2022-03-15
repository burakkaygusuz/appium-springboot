# Appium Spring Boot Test Architecture

## Prerequisites

Make sure you have installed all the following prerequisites on your development machine:

| OS      | JDK                           | Maven                 | Node.js                    | Android Studio                       |
|---------|-------------------------------|-----------------------|----------------------------|--------------------------------------|
| Windows | `choco install temurin17`     | `choco install maven` | `choco install nodejs-lts` | `choco install androidstudio`        |
| macOS   | `brew install --cask temurin` | `brew install maven`  | `brew install node@16`     | `brew install --cask android-studio` |

**NOTE:** macOS and [XCode](https://apps.apple.com/us/app/xcode/id497799835?mt=12) are mandatory for testing the IOS
Simulator using [XCUITest](https://github.com/appium/appium-xcuitest-driver/releases/latest).

- Install the appium server via npm:

```shell
npm install appium@next -g
```

- Install the UIAutomator2 driver.

```shell
appium driver install uiautomator2
```

- Install the XCUITest driver.

```shell
appium driver install xcuitest
```

- Install the appium doctor to verify node, Android, IOS configuration via npm:

```shell
npm install appium-doctor -g
```

- Diagnose the common configs using this below command:

```shell
appium-doctor --dev
```
