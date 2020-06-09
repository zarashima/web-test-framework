#!/usr/bin/env bash

export RUNWHERE=container

java -cp framework-1.0.jar:framework-1.0-tests.jar:libs/* \
    -DHUB_HOST="$HUB_HOST" \
    org.testng.TestNG "$MODULE"
