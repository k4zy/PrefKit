PrefKit
============

[![wercker status](https://app.wercker.com/status/9211f47f64bd20cbbed355f3001c6d0e/s/master "wercker status")](https://app.wercker.com/project/byKey/9211f47f64bd20cbbed355f3001c6d0e)
[![jitpack](https://jitpack.io/v/kazy1991/PrefKit.svg)](https://jitpack.io/#kazy1991/PrefKit)
[![Coverage Status](https://coveralls.io/repos/github/kazy1991/PrefKit/badge.svg?branch=integrate_coveralls)](https://coveralls.io/github/kazy1991/PrefKit?branch=integrate_coveralls)
[![License](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat-square)](http://fand.mit-license.org/)

Typesafe key-value store for Android. Inspired by Retrofit.

Update
--------

* 0.0.2 First release.


How to
--------

##### Step 1. Add the JitPack repository to your build file.

```groovy
  repositories {
    maven {
      url "https://jitpack.io"
    }
  }
```

##### Step 2. Add the dependency.

```groovy
  dependencies {
    compile 'com.github.kazy1991:PrefKit:0.0.2'
  }
```

##### Step 3. Define get/put method with Interface.

```java
@PrefSchema("SampleSchema")
interface SampleSchema {

    String WELCOME_DIALOG = "welcome_dialog";

    @PrefKey(WELCOME_DIALOG)
    void putWelcomeDialogFlag(boolean value);

    @PrefKey(WELCOME_DIALOG)
    boolean getWelcomeDialogFlag(boolean defaultValue);
}
```

`@PrefSchema`: Define sharedPreference name.

`@PrefKey`: Define key name.

#### Step 4. Access sharedPreference via interface.

```java
  PrefKit prefKit = new PrefKit(this);
  SampleSchema sampleSchema = prefKit.create(SampleSchema.class);
  sampleSchema.setWelcomeDialogFlag(true);
  sampleSchema.getWelcomeDialogFlag(false);
```

License
-------

MIT License
