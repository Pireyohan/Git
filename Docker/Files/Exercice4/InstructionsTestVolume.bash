#  LEs Volumes #

#Création d'un volume
docker volume create <nomDuVolume>
docker volume create vtest

#Lister les volumes
docker volume ls

##Inspecter un volume 
docker volume inspect vtest => <nomDuVolume> 

##Supprimer un volume 
docker volume rm <nomDuVolume>

##Création d'un conteneur (DockerFile)
FROM ubuntu:latest
RUN  mkdir/data
WORKDIR /data

docker images
##Instanciaation de notre image
docker run --name=my_volume_test_container -it -v vtest:/data img_test

## Créer un fichier dans le dossier surveillé par le volume
echo "ceci est un test, yo" > test.txt 

#Affichage du contenu du fichier test.txt
cat test.txt

