#Commencer par crée un projet node 
npm init

#créer notre fichier index.js
const express = require('express');

const app = express();

app.get('/', (req, res) => {
    res.send("Bonjour depuis mon serv nodeJs")
})

app.listen(80, () => {
    console.log("App is running")
})

#Création du DockerFile
#import de l'image de base
FROM debian

#Information complementaires sur la version du dockerfiler
LABEL version="1.0" maintainer="Pire Yohan <yopiro@hotmail.fr>"

#COmmande a executer dans le conteneur 
RUN apt update && apt upgrade -y && apt install nodejs -y && apt install npm -y && apt install nano -y

#SE placer dans le working directory 
WORKDIR /home/web

# copie des fichiers a linterieur de notre containeur
COPY . .

#exposition des ports
EXPOSE 80

#COmmande a executer dans le conteneur  oour installer express
RUN npm install express 

#COmmande de démarrage du container
CMD [ "node", "index.js" ]

#Build de notre image (ouvrirv un terminal pointant sur l'emplacement du dockerfile)
docker build -t my_node_serveur_image .


#Je lance mon image en la rename  avec mapping
docker run --name=My_Node_Server_Container -dp 8080:80 4c4f8e56f331


