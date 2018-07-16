Gradle Publish to Maven(JCenter) Demo
=====================================

There are two built-in repositories in gradle:

- `mavenCentral()`: <http://maven.org/>, and supported by sonatype.
- `jcenter()`: <http://bintray.com>

Since `jcenter` is much faster and developer friendly than `mavenCentral`, we can just publish our libs to jcenter by default.

Create a new Repository on JCenter for this project
---------------------------------------------------

View this page: <https://bintray.com/freewind>, and click on "Add New Repository", and fill some information.

Configure
---------

Update bintray information in `local.properties`, and make sure this file is ignored by git

```
bintray.user=USERNAME
bintray.apikey=API_KEY
```

And change the values in `ext` of file `build.gradle` too.

Publish
-------

Publish to local:

```
./gradlew install
```

Publish to bintray:

```
./gradlew bintrayUpload
```

Request to sync to JCenter
--------------------------

The published files are not included i JCenter by default. We have to specify the url to get it:

```
repositories {
    maven {
        url 'https://dl.bintray.com/freewind/maven/'
    }
}
```

(Good enough for me though)

We need send a request if we want it to be included in jcenter:

- open the page: <https://bintray.com/freewind/maven/gradle-publish-to-jcenter-demo>
- Click on the `Add to JCenter` button
- Comments and send request

If the request is accepted, the future updated are synchronized to jcenter automatically.

I heard if there is no JavaDoc jars, the request may be rejected, this is maybe a bad news for kotlin project, since it can't generate JavaDoc easily. (need more investigating)

Testing the publishing
----------------------

Use a standard-alone project `testing-project` for testing:

```
cd testing-project
./gradlew compileJava
```

Notice we need to modify the `version` in `testing-project/build.gradle` if we published new version of the main project to bintray.

Resources
---------

- Example code: <https://github.com/bintray/bintray-examples/blob/master/gradle-bintray-plugin-examples/configurations-example/build.gradle>
- Short version (android project): <https://medium.com/@yegor_zatsepin/simple-way-to-publish-your-android-library-to-jcenter-d1e145bacf13>
- Long version: <https://inthecheesefactory.com/blog/how-to-upload-library-to-jcenter-maven-central-as-dependency/en>
