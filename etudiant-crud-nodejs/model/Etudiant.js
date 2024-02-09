const { Sequelize, DataTypes } = require('sequelize');
const dbConfig = require('../config/config');

const sequelize = new Sequelize(dbConfig.DB, dbConfig.USER, dbConfig.PASSWORD, {
  host: dbConfig.HOST,
  dialect: dbConfig.dialect,
});

const Etudiant = sequelize.define('etudiant', {
  nom: {
    type: DataTypes.STRING
  },
  prenom: {
    type: DataTypes.STRING
  },
  telephone: {
    type: DataTypes.STRING
  }
});

module.exports = Etudiant;
