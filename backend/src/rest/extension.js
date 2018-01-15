var express = require('express');
var router = express.Router();
var extension = require('../service/').extension;

router.get('/', extension.list);
router.get('/:id', extension.findById);
router.get('/:name', extension.findByExt);
router.post('/', extension.create);
router.delete('/:id', extension.delete);
module.exports = router;
