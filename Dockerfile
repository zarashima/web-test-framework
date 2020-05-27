FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

WORKDIR /Users/vinh.nguyen/Desktop/docker/selenium-hub

# ADD .jar under target from host
ADD target/framework-1.0.jar 			framework-1.0.jar
ADD target/framework-1.0-tests.jar		framework-1.0-tests.jar
ADD target/libs							libs

# ADD resources folder
ADD src/test/resources				    src/test/resources

# ADD suite files
ADD suites/testng.xml					testng.xml

ADD healthcheck.sh						healthcheck.sh

ENTRYPOINT sh healthcheck.sh
