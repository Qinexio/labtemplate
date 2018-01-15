"use strict";

const photo = require('../models').photo;

exports.list = function (req, res) {
  photo.findAll().then(photo => {
    res.jsonp(photo);
  }).catch((error) => res.status(400).send(error));
};

exports.create = function (req, res) {
    res.jsonp(photo.create(req.body, { fields: ['title', 'description', 'extensionId'] }));
};

exports.findById = function (req, res) {
  let id = req.params.id;
  photo.findById(id).then(photo => {
    if (!photo) {
      return res.status(400).send({
        message: 'photo Not Found',
      });
    }
    res.jsonp(photo);
  });
};

exports.findByTitle = function (req, res) {
  let toFindTitle = req.params.title;
  let limitNum = req.params.limit;
  let offsetNum = (req.params.offset-1)*limitNum;
	photo.findAll({where: {title:{[Op.like]:toFindTitle},pending:{[Op.not]:false}},limit:limitNum,offset:offsetNum}).then(photo => {
    if (!photo) {
      return res.status(400).send({
        message: 'photo Not Found',
      });
    }
    res.jsonp(photo);
  });
};

exports.findByPending = function (req, res) {
  photo.findAll({where: {pending : false}}).then(photo => {
    if (!photo) {
      return res.status(400).send({
        message: 'photo Not Found',
      });
    }
    res.jsonp(photo);
  });
};

exports.findTop = function (req, res) {
	let limitNum = req.params.limit;
	let offsetNum = req.params.offset*limitNum;
  photo.findAll({where:{pending:{[Op.not]:false},order: 'rating DESC'},limit:limitNum,offset:offsetNum}).then(photo => {
    if (!photo) {
      return res.status(400).send({
        message: 'photo Not Found',
      });
    }
    res.jsonp(photo);
  });
};

exports.updateBool = function (req, res) {
    let id = req.params.id;
  photo.findById(req.params.id)
    .then(photo => {
      if (!photo) {
        return res.status(400).send({
          message: 'photo Not Found',
        });
      }
      return photo
          .update({ pending: true })
        .then(() => res.status(204).send())
        .catch(error => res.status(400).send(error));
    })
    .catch(error => res.status(400).send(error));
};

exports.delete = function (req, res) {
  let id = req.params.id;
  photo.findById(req.params.id)
    .then(photo => {
      if (!photo) {
        return res.status(400).send({
          message: 'photo Not Found',
        });
      }
      return photo
        .destroy()
        .then(() => res.status(204).send())
        .catch(error => res.status(400).send(error));
    })
    .catch(error => res.status(400).send(error));
};