##Creation du docker file pour création de l'image
FROM node:12-alpine
RUN apk add --no-cache python2 g++ make
WORKDIR /app
COPY . .
RUN yarn install --production
CMD ["node", "src/index.js"]

##Builde de l'image de notre application
docker build -t docker_demo_image .

####################
#Création container
####################

#Instanciation de l'image crée
docker run  --name=docker_demo_bp_container -dp 3000:3000 --rm docker_demo_image

##Verification du fonctionnement de l'app
localhost:3000

####################
#Update container
####################

##Arret du container
docker stop docker_demo_container le docker ps 
## Rebuild du a une modification de le static/src/app.js ligne 57
<p className="text-center">You have no items yet! Add one above!</p> // update
 to =>    <p className="text-center">You have nothing DUDE! Add one above!</p> // update

docker build -t docker_demo_image .

##RErun de l'instanciation
docker run  --name=docker_demo_bp_container -dp 3000:3000 --rm docker_demo_image
##Re localhost pour check
localhost:3000

####################
# Docker Hub #
####################

##Creation d'une image MAJ pour la push sur le hub=> Convention de nommage: NomRepoDocker/NomImage
docker commit  <container ID> 
docker commit  docker_demo_bp_container fofo59118/my_demo_docker

## Push de notre image sur le hub docker,=> avec la possibilité de lui ajouter un tag
docker push fofo59118/my_demo_docker:latest

#Stop du container en cours d'exec
docker stop  docker_demo_bp_container

#Instanciation de notre image depuis le hub ,Cette fois ci on prend de notre image  fofo59118/my_demo_docker:latest
docker run  --name=my_docker_demo_bp_container -dp 3000:3000 --rm fofo59118/my_demo_docker:latest

############
#  Volumes #
############
#Création d'un volume todo-db    #Vérifier sa créqtion
docker volume create todo-db      docker volume ls

#Instanciation depuis l'image et connection au volume
docker run  --name=my_docker_demo_bp_container -dp 3000:3000 --rm -v todo-db:/etc/todos fofo59118/my_demo_docker:latest

## Verification de la modif => Ajout de donnée
http://localhost:3000

##Observer le volume
docker volume inspect todo-db

##Arrêt du docker
docker stop 992

#RE-Instanciation depuis l'image et connection au volume
docker run  --name=my_docker_demo_bp_container -dp 3000:3000 --rm -v todo-db:/etc/todos fofo59118/my_demo_docker:latest

#REvérification de la modification de l'app => les données sont tjs présentes
http://localhost:3000

##############################
# Point de liaison(montage=) #
##############################

## Arret du container (suppresion auto)
docker stop my_docker_demo_bp_container

#Instanciation d'un contenur node:Alpine et bind de notre répertoire de travail en Volume
MSYS_NO_PATHCONV=1 docker run --name=my_demo_docker_container_dev --rm -dp 3000:3000 -w /app -v "$(pwd):/app" node:12-alpine sh -c "yarn install && yarn run dev"

# MSYS_NO_PATHCONV=1 => Resoud les problemes de chemein absolue sous windows
# -dp 3000:3000 - pareil qu'avant. Exécuter en mode détaché (arrière-plan) et créer un mappage de port
# -w /app - définit le "répertoire de travail" où le répertoire actuel à partir duquel la commande sera exécutée
# -v "$(pwd):/app" - lier monter le répertoire courant de l'hôte dans le conteneur dans le répertoire /app 
# node:12-alpine - l'image à utiliser. Notez qu'il s'agit de l'image de base de notre application à partir du Dockerfile
# sh -c "yarn install && yarn run dev" - la commande. Nous démarrons un shell en utilisant sh(alpine n'a pas bash) et en cours d'exécution yarn install 
# pour installer toutes les dépendances, puis en exécutant yarn run dev. Si nous regardons dans le package.json, nous verrons que le devscript démarre nodemon.

#Affichage des logs du serveur
docker logs -f my_demo_docker_container_dev

##############################
#    Multi-Container-App     #
##############################
#Creation d'un réseau
docker networdk create todo-db

#Instanciation d'un container mySQL
docker run --name=my_sql_container --rm -d --network todo-db --network-alias mysql -v todo-mysql-data:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=todos mysql:5.7

#Connection à la bdd                                        #Entrer le password secret
docker exec -it my_sql_container mysql -u root -p           secret

#Une fois dans le shell mysql saisir
show databases;
mysql> show databases;
+--------------------+
| Database           |
+--------------------+
| information_schema |
| mysql              |
| performance_schema |
| sys                |
| todos              |
+--------------------+
5 rows in set (0.00 sec)

#instanciation de l'application dans un containeur en mode dev avec connecion au réseau et injection
MSYS_NO_PATHCONV=1 docker run --name=todo_app_container --rm -dp 3000:3000 \
   -w /app -v "$(pwd):/app" \
   --network todo-db \
   -e MYSQL_HOST=mysql \
   -e MYSQL_USER=root \
   -e MYSQL_PASSWORD=secret \
   -e MYSQL_DB=todos \
   node:12-alpine \
   sh -c "yarn install && yarn run dev"

#RE-vérification de la modification de l'app => les données sont tjs présentes
http://localhost:3000


