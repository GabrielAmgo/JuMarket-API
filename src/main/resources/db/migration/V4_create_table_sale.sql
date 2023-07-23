CREATE TABLE sale (
  id BIGINT AUTO_INCREMENT NOT NULL,
   payment_method VARCHAR(255) NOT NULL,
   total_value DECIMAL NOT NULL,
   CONSTRAINT pk_sale PRIMARY KEY (id)
);

CREATE TABLE sale_carts (
  sale_id BIGINT NOT NULL,
   carts_id BIGINT NOT NULL
);

ALTER TABLE sale ADD CONSTRAINT uc_sale_paymentmethod UNIQUE (payment_method);

ALTER TABLE sale ADD CONSTRAINT uc_sale_totalvalue UNIQUE (total_value);

ALTER TABLE sale_carts ADD CONSTRAINT fk_salcar_on_cart FOREIGN KEY (carts_id) REFERENCES cart (id);

ALTER TABLE sale_carts ADD CONSTRAINT fk_salcar_on_sale FOREIGN KEY (sale_id) REFERENCES sale (id);