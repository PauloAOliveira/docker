# docker
Exemplify docker usage using java spring based project

## Example of docker commands
```
docker ps - list all active containers
	-a list all containers
	-qa - list only container's ids
docker rm container_id - removes the container from the stack
	-f - stops and remove the container
docker rm $(docker ps -qa) - remove all inactive containers

docker logs container_id - show ALL logs from the container

docker rmi image - delete a container image from local repo(it will only be able if there are no pending containers from this image)

docker run image - execute an image
	--publish/-p port1:port2 - link port1 from machine to port2 from container
	--detach/-d - run the container on background
	--name - name the container, it is necessary be an unique id, even on inactive containers
	--it - initiate the container on interactive mode
	--network - specify a network, two containers must be on the same network to connect to each other directly
	
docker run --publish 8080:80 --detach --name my_n nginx

docker exec -it container_id command - execute a command in a runnning container on interactive mode
docker stop container_id - stops a container

docker network commands - interface to manage network between containers
			   create - creates a network using the default driver(bridge)
```
##
To build de image just execute the build.sh  

To execute the application there are two ways:  

1º  
docker network create net-example  
docker run -d --name mongo-db -p 27017:27017 -v {your_directory}:/data/db --network net-example mongo  
docker run -d --name docker-example -v {your_directory}:/tmp -p 8080:8080 --network net-example docker-example  

2º  
(Change the directories name on the docker-compose.yml)  
docker-compose up

OBS:  
To run the application outside a container, use the application-local.properties  
  
From java project directory just run:  
java -jar target/docker-example.jar --spring.config.location=src/main/resources/application-local.properties
