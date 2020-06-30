#!/usr/bin/env bash
echo "Package project"
mvn clean package -DskipTests=true

echo "Build docker image"
docker build -t=vinh/frameworkdocker .

echo "Run tests"
docker-compose up
