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


