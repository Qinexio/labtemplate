"use strict";

const extension = require('../models').extension;


exports.list = function (req, res) {
  extension.findAll().then(extension => {
    res.jsonp(extension);
  }).catch((error) => res.status(400).send(error));
};

exports.create = function (req, res) {
  res.jsonp(extension.create(req.body));
};

exports.findById = function (req, res) {
  let id = req.params.id;
  extension.findById(id).then(extension => {
    if (!extension) {
      return res.status(400).send({
        message: 'Extension Not Found',
      });
    }
    res.jsonp(extension);
  });
};

exports.findByExt = function (req, res) {
  let toFindName = req.params.name;
  extension.findAll({where: {name : toFindName}}).then(extension => {
    if (!extension) {
      return res.status(400).send({
        message: 'Extension Not Found',
      });
    }
    res.jsonp(extension);
  });
};

exports.delete = function (req, res) {
  let id = req.params.id;
  extension.findById(req.params.id)
    .then(extension => {
      if (!extension) {
        return res.status(400).send({
          message: 'Extension Not Found',
        });
      }
      return extension
        .destroy()
        .then(() => res.status(204).send())
        .catch(error => res.status(400).send(error));
    })
    .catch(error => res.status(400).send(error));
};