USE RecipeBook;

DROP TABLE IF EXISTS recipes;
CREATE TABLE IF NOT EXISTS recipes (
  id     INTEGER (18) NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name    VARCHAR (50) NOT NULL,
  cooking VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS foodstuff;
CREATE TABLE IF NOT EXISTS foodstuff (
  id    INTEGER (18) NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name  VARCHAR (50) NOT NULL UNIQUE,
  unit 	VARCHAR (20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

DROP TABLE IF EXISTS ingredients;
CREATE TABLE IF NOT EXISTS ingredients (
  id            INTEGER (18) AUTO_INCREMENT PRIMARY KEY ,
  recipe_id     INTEGER (18) NOT NULL,
  foodstuff_id INTEGER (18) NOT NULL,
  quantity      DECIMAL (65) NOT NULL,
  CONSTRAINT recipe_ingredient FOREIGN KEY (recipe_id) REFERENCES recipes (id),
  CONSTRAINT foodstuff_ingredient FOREIGN KEY (foodstuff_id) REFERENCES foodstuff (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;


DROP TABLE IF EXISTS role;
CREATE TABLE IF NOT EXISTS role (
  id INTEGER (18) NOT NUIF NOT EXISTSLL AUTO_INCREMENT PRIMARY KEY ,
  role VARCHAR(255) default NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS user;
CREATE TABLE IF NOT EXISTS user (
  id INTEGER (18) AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(255) NOT NULL,
  lastname VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  active INTEGER (18) default NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS user_role;
CREATE TABLE IF NOT EXISTS user_role (
  user_id INTEGER (18) NOT NULL,
  role_id INTEGER (18) NOT NULL,
  PRIMARY KEY  (user_id, role_id),
  KEY user_role_key (role_id),
  CONSTRAINT user_userrole FOREIGN KEY (user_id) REFERENCES user (id),
  CONSTRAINT role_userrole FOREIGN KEY (role_id) REFERENCES role (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS persistent_logins;
CREATE TABLE IF NOT EXISTS persistent_logins (
  username varchar(64) NOT NULL,
  series varchar(64) NOT NULL,
  token varchar(64) NOT NULL,
  last_used timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP,
  PRIMARY KEY  (series)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
