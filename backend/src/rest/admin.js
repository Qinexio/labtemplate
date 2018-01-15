var express = require('express');
var router = express.Router();
var admin = require('../service/').admin;

//router.get('/admin', admin.list);
router.get('/:name/:pass', admin.findByNameAndPass);
//router.get('/admin/:id', admin.findById);
//router.post('/', admin.create);
//router.delete('/admin/:id', admin.delete);

module.exports = router;
