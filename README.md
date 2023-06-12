# ott
Three modules
- back-end          : mam           : Quarkus
- micro gateway     : gateway       : Qurkus
- front-end         : mam-ftonend   : node/ts/Angular 

# backend 
## Postgresql
- Dev service from Quarkus : postgresql

## Keycloak
- KeyCloak : run on docker with default admin account admin/admin and listening over port 9090

docker run --name keycloak_dev -p 9090:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:latest start-dev

once started, you can open admin console on 
http://localhost:9090
then click on "Administration Console"
Login using admin/admin

Add Hadif releam
Create Realm/upload Resource file
realm file under /mam-fronend/src/config/keycloak-mam-realm.json

## run mam project 
$mvn quarkus:dev

## run gateway project 
$mvn quarkus:dev

## run mam-frontend
1 - first time install depdendencies
$npm install --force
2- run
$ng serve




## once caching is enabled, you need to run infinspan

start infnispan
docker run -p 11222:11222 -e USER="admin" -e PASS="password" infinispan/server