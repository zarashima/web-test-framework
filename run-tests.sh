#!/usr/bin/env bash
echo "Package project"
mvn clean package -DskipTests=true

echo "Build docker image"
docker build -t=vinh/frameworkdocker .

echo "Cleanup previous docker compose"
docker-compose down --rmi local

echo "Run tests"
SUITE=$1 docker-compose up -d --force-recreate

echo "Execution logs"
docker-compose logs > output.log
while [[ !($(cat output.log | grep "Total tests run")) ]]
do
	docker-compose logs --tail=1000
	docker-compose logs --tail=1000 > output.log
    sleep 1
done
