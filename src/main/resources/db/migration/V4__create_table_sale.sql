CREATE TABLE sale (
  id BIGINT AUTO_INCREMENT NOT NULL,
   payment_method VARCHAR(255) NOT NULL,
   total_value DECIMAL NOT NULL,
   CONSTRAINT pk_sale PRIMARY KEY (id)
);

ALTER TABLE sale ADD CONSTRAINT uc_sale_paymentmethod UNIQUE (payment_method);

ALTER TABLE sale ADD CONSTRAINT uc_sale_totalvalue UNIQUE (total_value);