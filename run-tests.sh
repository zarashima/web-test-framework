#!/usr/bin/env bash
echo "Package project"
mvn clean package -DskipTests=true

echo "Build docker image"
docker build -t=vinh/frameworkdocker .

echo "Run tests"
docker-compose up -d --force-recreate

echo "Execution logs"
docker-compose logs > output.log
while [[ !($(cat output.log | grep "Total tests run")) ]]
do
	docker-compose logs > output.log
	docker-compose logs --tail=100
    sleep 1
done

echo "End test"
docker-compose down
