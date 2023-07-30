CREATE TABLE product (
  id BIGINT AUTO_INCREMENT NOT NULL,
   product_name VARCHAR(255) NOT NULL,
   measure_unit VARCHAR(255) NOT NULL,
   category_id BIGINT NOT NULL,
   price DECIMAL NOT NULL,
   CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE product ADD CONSTRAINT uc_product_measureunit UNIQUE (measure_unit);

ALTER TABLE product ADD CONSTRAINT uc_product_price UNIQUE (price);

ALTER TABLE product ADD CONSTRAINT uc_product_productname UNIQUE (product_name);

ALTER TABLE product ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES category (id);