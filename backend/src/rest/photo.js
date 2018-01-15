var express = require('express');
var router = express.Router();
var photo = require('../service/').photo;

router.get('/', photo.list);
router.get('/:title/:limit/:offset', photo.findByTitle);
router.get('/', photo.findByPending);
router.get('/:limit/:offset', photo.findTop);
router.put('/:id', photo.updateBool);
router.get('/:id', photo.findById);
router.post('/', photo.create);
router.delete('/:id', photo.delete);
module.exports = router;
