#!/bin/bash

mvn clean package

if [ $? -eq 0 ]; then
    echo "Success"
else
    echo "Failed"
    exit 1
fi

docker build -t docker-example .