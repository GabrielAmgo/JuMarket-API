CREATE TABLE cart (
  id BIGINT AUTO_INCREMENT NOT NULL,
   total_value DECIMAL NULL,
   payment_method VARCHAR(255) NULL,
   CONSTRAINT pk_cart PRIMARY KEY (id)
);