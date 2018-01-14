'use strict';
module.exports = (sequelize, DataTypes) => {
  var extension = sequelize.define('extension', {
    name: DataTypes.STRING
  }, {
    classMethods: {
      associate: function(models) {
        // associations can be defined here
      }
    }
  });
  return extension;
};