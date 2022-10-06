######################################################################
#				Tp3 - App Java
######################################################################

## => Executer le programme java dans un container à l'aide l'image openjdk:8

# Création du Dockerfile

# build de l'image
$ docker build -t my_java_image .

# Recupération de l'id de l'image
$ docker images

# Instanciation de l'image
$ docker run -it --name=my_java_container <Container_id>