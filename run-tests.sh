#!/usr/bin/env bash
echo "Package project"
mvn clean package -DskipTests=true

echo "Build docker image"
docker build -t=vinh/frameworkdocker .

echo "Run tests"
docker-compose up -d --force-recreate

echo "Docker compose logs"
docker-compose logs -t

LINE_TO_CONTAIN="exited with code"
SLEEP_TIME=10
until [[ $(cat $(docker-compose logs -t > output.log) | grep "${LINE_TO_CONTAIN}") ]]
do
    sleep ${SLEEP_TIME}
done

docker-compose logs --tail=100
