[![Codacy Badge](https://api.codacy.com/project/badge/Grade/ea4a81e6a3cd4bf8a4a51b6f1f16145a)](https://www.codacy.com/manual/npvinh140589/selenium-test-framework?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=zarashima/selenium-test-framework&amp;utm_campaign=Badge_Grade)
[![Build Status](https://travis-ci.com/zarashima/selenium-test-framework.svg?branch=master)](https://travis-ci.com/zarashima/selenium-test-framework)
![Build Status](https://github.com/zarashima/selenium-test-framework/workflows/Build%20Status/badge.svg)

## Framework Architecture
![Framework Architecture](https://github.com/zarashima/java-test-framework/blob/master/Framework-Architecture.png)

## Introduction
A web automation testing framework written in Java. Support Chrome, Firefox

## Technologies
* Maven
* TestNG
* ExtentReport
* Docker
* Guice
* ReportPortal

## Features
* Dependencies injection using Guice
* Ensure mechanism
* Thread-safe driver instances
* Auto download webdrivers (using WebDriverManager)

## Usage
The framework export RUNWHERE environment variable for use in different cases. Different RUNWHERE used will change desired capabilities accordingly

| RUNWHERE | Description |
| --- | --- |
| LOCAL | Desired capabilities for execution on local machine |
| PIPELINE | Desired capabilities for execution on a automation pipeline |
| CONTAINER | Desired capabilities for execution on Docker |

### Enable ReportPortal integration
By default, ReportPortal(RP) integration is disabled. Setup your RP properly first and then change RP settings in `src/test/resources/reportproperties.properties` file

### Execution
As told, RUNWHERE will determine the desired capabilities against the browser under test. Example below expose RUNWHERE environment variable as LOCAL
Execute maven command and pass in the browser's name.

If RP is enabled, it will send results to the server

```bash
export RUNWHERE=LOCAL
# Chrome
mvn clean test -DbrowserName=chrome

# Firefox
mvn clean test -DbrowserName=firefox
```
