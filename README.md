# Onboarding #
[![](https://jitpack.io/v/mensarb/onboarding.svg)](https://jitpack.io/#mensarb/onboarding)

a customizable onboarding library for android

# Gradle Dependency

### Repository
The Gradle dependency is available via [jitpack.io](https://jitpack.io/#mensarb/onboarding).

The minimum API level supported by this library is API 16.

Step 1.Add the JitPack repository to your build file
```gradle
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
Step 2. Add the dependency
```gradle
dependencies {
	// ... other dependencies here

    compile 'com.github.mensarb.onboarding:onboarder:{version}'
}
```