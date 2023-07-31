CREATE TABLE category (
  id INT AUTO_INCREMENT NOT NULL,
   name VARCHAR(255) NOT NULL,
   CONSTRAINT pk_category PRIMARY KEY (id)
);

ALTER TABLE category ADD CONSTRAINT uc_category_name UNIQUE (name);

