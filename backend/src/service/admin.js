"use strict";

const admin = require('../models').admin;

exports.list = function (req, res) {
  admin.findAll().then(admin => {
    res.jsonp(admin);
  }).catch((error) => res.status(400).send(error));
};

exports.create = function (req, res) {
  res.jsonp(admin.create(req.body));
};

exports.findById = function (req, res) {
  let id = req.params.id;
  admin.findById(id).then(admin => {
    if (!admin) {
      return res.status(400).send({
        message: 'admin Not Found',
      });
    }
    res.jsonp(admin);
  });
};

exports.findByNameAndPass = function (req, res) {
  let toFindName = req.params.name;
  let toFindPass = req.params.pass;
  admin.findOne(where: {username : toFindName, password: toFindPass}).then(admin => {
    if (!admin) {
      return res.status(400).send({
        message: 'admin Not Found',
      });
    }
    res.jsonp(admin);
  });
};

exports.delete = function (req, res) {
  let id = req.params.id;
  admin.findById(req.params.id)
    .then(admin => {
      if (!admin) {
        return res.status(400).send({
          message: 'admin Not Found',
        });
      }
      return admin
        .destroy()
        .then(() => res.status(204).send())
        .catch(error => res.status(400).send(error));
    })
    .catch(error => res.status(400).send(error));
};