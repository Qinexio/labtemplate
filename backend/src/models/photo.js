'use strict';
module.exports = (sequelize, DataTypes) => {
  var photo = sequelize.define('photo', {
    title: DataTypes.STRING,
    description: DataTypes.TEXT,
    pending: 
	{
		type: DataTypes.BOOLEAN,
		defaultValue: false
	},
    rating: 
	{
		type: DataTypes.FLOAT,
		defaultValue: 0
	}
  }, {
    classMethods: {
      associate: function(models),
	  {
			photo.belongsTo(models.extension,
			{
			onDelete: "CASCADE",
			foreignKey: 
				{
					allowNull: false
				}
			}
		);
      }
    }
  });
  return photo;
};