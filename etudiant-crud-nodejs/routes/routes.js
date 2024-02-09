const express = require('express');
const router = express.Router();
const EtudiantController = require('../controller/EtudiantController');

router.post('/etudiants', EtudiantController.create);
router.get('/etudiants', EtudiantController.findAll);
router.get('/etudiants/:id', EtudiantController.findOne);
router.put('/etudiants/:id', EtudiantController.update);
router.delete('/etudiants/:id', EtudiantController.delete);

module.exports = router;
