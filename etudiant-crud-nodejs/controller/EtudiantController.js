const Etudiant = require('../model/Etudiant');

exports.create = (req, res) => {
  const { nom, prenom, telephone } = req.body;

  Etudiant.create({
    nom,
    prenom,
    telephone
  })
    .then(etudiant => {
      res.status(201).json(etudiant);
    })
    .catch(err => {
      res.status(500).json({ message: err.message });
    });
};

exports.findAll = (req, res) => {
  Etudiant.findAll()
    .then(etudiants => {
      res.status(200).json(etudiants);
    })
    .catch(err => {
      res.status(500).json({ message: err.message });
    });
};

exports.findOne = (req, res) => {
  const id = req.params.id;

  Etudiant.findByPk(id)
    .then(etudiant => {
      if (!etudiant) {
        res.status(404).json({ message: 'Étudiant non trouvé.' });
        return;
      }
      res.status(200).json(etudiant);
    })
    .catch(err => {
      res.status(500).json({ message: err.message });
    });
};

exports.update = (req, res) => {
  const id = req.params.id;
  const { nom, prenom, telephone } = req.body;

  Etudiant.update({ nom, prenom, telephone }, {
    where: { id }
  })
    .then(() => {
      res.status(200).json({ message: 'Étudiant mis à jour avec succès.' });
    })
    .catch(err => {
      res.status(500).json({ message: err.message });
    });
};

exports.delete = (req, res) => {
  const id = req.params.id;

  Etudiant.destroy({
    where: { id }
  })
    .then(() => {
      res.status(200).json({ message: 'Étudiant supprimé avec succès.' });
    })
    .catch(err => {
      res.status(500).json({ message: err.message });
    });
};
