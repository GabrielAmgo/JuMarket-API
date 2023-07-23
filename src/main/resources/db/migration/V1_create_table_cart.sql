CREATE TABLE cart (
  id BIGINT AUTO_INCREMENT NOT NULL,
   item_count INT NOT NULL,
   total_value DECIMAL NOT NULL,
   CONSTRAINT pk_cart PRIMARY KEY (id)
);

CREATE TABLE cart_items (
  cart_id BIGINT NOT NULL,
   items_id BIGINT NOT NULL
);

ALTER TABLE cart ADD CONSTRAINT uc_cart_itemcount UNIQUE (item_count);

ALTER TABLE cart ADD CONSTRAINT uc_cart_totalvalue UNIQUE (total_value);

ALTER TABLE cart_items ADD CONSTRAINT fk_carite_on_cart FOREIGN KEY (cart_id) REFERENCES cart (id);

ALTER TABLE cart_items ADD CONSTRAINT fk_carite_on_product FOREIGN KEY (items_id) REFERENCES product (id);