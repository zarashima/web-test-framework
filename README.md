[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ea4a81e6a3cd4bf8a4a51b6f1f16145a)](https://www.codacy.com/manual/npvinh140589/selenium-test-framework?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=zarashima/selenium-test-framework&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.com/zarashima/selenium-test-framework.svg?branch=master)](https://travis-ci.com/zarashima/selenium-test-framework)
![Build Status](https://github.com/zarashima/selenium-test-framework/workflows/Build%20Status/badge.svg)

### Framework Architechture
![Framework Architechture](https://github.com/zarashima/java-test-framework/blob/master/Framework-Architecture.png)


### Roadmap
* Dependencies injection by Guice (Done)
* Store executed browser information in the report (Done)
* Ensure mechanism (Done)

### Introduction
A simple automated testing framework for Web platform. Support Chrome, Firefox and IE

### Technologies
* Maven
* TestNG
* ExtentReport

### Features
* Dependencies injection using Guice
* Ensure mechanism
* Thread-safe driver instances
* Auto download webdrivers (using WebDriverManager)

### Usage
Execute maven command and pass in the browser's name. Example:
```bash
# Chrome
mvn clean test -DbrowserName=chrome -Dkibana.integration=false

# Firefox
mvn clean test -DbrowserName=firefox -Dkibana.integration=false

### Extension
## [Ensure](https://github.com/zarashima/java-test-framework/blob/master/src/main/java/ensure/Ensure.java)
Execute designated functions before a specific event. The current one will scroll to element before element interactions. To add other ensure actions, refer to [Wait](https://github.com/zarashima/java-test-framework/blob/master/src/main/java/ensure/Wait.java) class as an example

## Drivers
Driver instances are created using Factory design pattern, refer to [webdrivers](https://github.com/zarashima/java-test-framework/tree/master/src/main/java/webdriver) package. To reduce boilerplate code, I use Guice and manage them through [DriverModule](https://github.com/zarashima/java-test-framework/blob/master/src/main/java/modules/DriverModule.java)
