CREATE TABLE PRODUCT_TAG (
  productid INTEGER NOT NULL,
  tagid  INTEGER NOT NULL
);

ALTER TABLE PRODUCT_TAG ADD CONSTRAINT PK_PRODUCT_TAG PRIMARY KEY (productid, tagid);
ALTER TABLE PRODUCT_TAG ADD CONSTRAINT FK_PRODUCTTAG_PROD FOREIGN KEY (PRODUCTID) REFERENCES PRODUCT (ID);
ALTER TABLE PRODUCT_TAG ADD CONSTRAINT FK_PRODUCTTAG_TAG FOREIGN KEY (TAGID) REFERENCES TAG (id);
