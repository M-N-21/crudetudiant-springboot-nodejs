# Projet CRUD Etudiant avec Node.js

Ce projet est une application de gestion des étudiants avec des opérations CRUD (Create, Read, Update, Delete) développée avec Node.js.

## Prérequis

Avant de commencer, assurez-vous d'avoir installé les outils suivants :

- Node.js
- npm
- MySQL

## Configuration de la base de données

Ce projet utilise une base de données MySQL. Assurez-vous de configurer les paramètres de connexion dans un fichier `config.js` situé dans un dossier `config` qui se trouve à la racine du projet. Vous pouvez y définir l'URL de la base de données, le nom d'utilisateur et le mot de passe.

Exemple de contenu pour le fichier :

```
module.exports = {
    HOST: "localhost",
    USER: "root",
    PASSWORD: "",
    DB: "etudiant-nodejs",
    dialect: "mysql",
};
```


## Installation des dépendances

Avant de lancer l'application, vous devez installer les dépendances du projet. Pour ce faire, exécutez la commande suivante dans le répertoire racine du projet :
`npm install`

## Lancement de l'application

Une fois les dépendances installées, vous pouvez démarrer l'application en exécutant la commande suivante :
`npm start`


Cela démarrera l'application Node.js.

## Accès à l'API

Une fois l'application lancée, vous pouvez accéder à l'API à l'adresse suivante :
`http://localhost:2121/api/etudiants`. La configuration du port d'ecoute a été effectué dans le fichier principal qui se trouve dans la racine du projet. pour notre part c'est le `app.js`
```
const express = require('express');
const bodyParser = require('body-parser');
const routes = require('./routes/routes');
const db = require('./model/Etudiant');

const app = express();

app.use(bodyParser.json());
app.use('/api', routes);

const PORT = 2121;

db.sequelize.sync().then(() => {
  console.log('Base de données synchronisée. Serveur en cours d\'exécution sur le port ' + PORT);
  app.listen(PORT);
});
```
C'est ici aussi qu'on défini que toute les routes seront précédés de `/api`

L'API expose les endpoints suivants pour les opérations CRUD :

- GET /api/etudiants : récupérer tous les étudiants
- GET /api/etudiants/{id} : récupérer un étudiant par son identifiant
- POST /api/etudiants : créer un nouvel étudiant
- PUT /api/etudiants/{id} : mettre à jour un étudiant existant
- DELETE /api/etudiants/{id} : supprimer un étudiant existant

## Contributions

Les contributions sont les bienvenues ! Si vous souhaitez contribuer à ce projet, veuillez ouvrir une issue pour discuter des changements que vous souhaitez apporter, ou soumettre une pull request directement.

## Auteur
### M.N.21


