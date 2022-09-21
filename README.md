# testSpring MongoDB
- test Connect to Mongodb
- Create Service for insert and find in MongoDB




# Ref install mongodb in docker 
- https://www.youtube.com/watch?v=uklyCSKQ1Po
- docker pull mongo:latest
- docker images (For check images)
- mkdir mongo-docker (create for docker)
- cd mongo-docker
- docker run -d -p (setport) 2717(local port):27017(inner port docker) -v /mongo-docker:/data/db --name(set name) mongo(name of container) mongo:latest(image docker)
- docker ps (for check container run)
- docker exec(call script in container) -it(option for hold remote script) mongo(container name) mongosh(command in container) or bash(command open bash container)
- mongosh localhost:2717(open mongo on localport remote in mongo docker>in container 27017 public is 2717)
