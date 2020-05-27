#!/usr/bin/env bash

echo "Checking if hub is ready - $HUB_HOST"

export RUNWHERE=container

java -cp framework-1.0.jar:framework-1.0-tests.jar:libs/* \
    -DHUB_HOST=$HUB_HOST \
    -DbrowserName=$BROWSER \
    org.testng.TestNG $MODULE
