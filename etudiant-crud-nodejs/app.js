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
