#Code docker file 
FROM php:7-apache

LABEL version="1.0" 

# Activation des modules php
RUN docker-php-ext-install pdo pdo_mysql

WORKDIR  /var/www/html


#Build de l'image de notre application
docker build -t docker_demophp_image .

###### Creation du container ###########
docker run --name=docker_demo_dc_container -dp 8080:80 --rm docker_demophp_image

#Vérification du fonctionnement de l'app
localhost:8080


version: "3.7"

services:
  app:
    image: php:7-apache
    command: sh -c "yarn install && yarn run dev"
    ports:
      - 8000:80
    working_dir: /app
    volumes:
      - ./:/app
    environment:
      MYSQL_HOST: mysql
      MYSQL_USER: root
      MYSQL_PASSWORD: secret
      MYSQL_DB: todos

  mysql:
    image: mysql:5.7
    volumes:
      - todo-mysql-data:/var/lib/mysql
    environment:
      MYSQL_ROOT_PASSWORD: secret
      MYSQL_DATABASE: todos

volumes:
  todo-mysql-data:

