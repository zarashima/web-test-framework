#!/usr/bin/env bash
export RUNWHERE=container
echo "Checking if hub is ready - $HUB_HOST"

while [[ "$( curl -s http://$HUB_HOST:4444/wd/hub/status | jq -r .value.ready )" != "true" ]]
do
	sleep 1
done

java -cp framework-1.0.jar:framework-1.0-tests.jar:libs/* \
    -DHUB_HOST="$HUB_HOST" \
    org.testng.TestNG "$SUITE"
