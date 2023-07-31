CREATE TABLE cart (
  id INT AUTO_INCREMENT NOT NULL,
   total_value DECIMAL NULL,
   payment_method VARCHAR(255) NULL,
   CONSTRAINT pk_cart PRIMARY KEY (id)
);