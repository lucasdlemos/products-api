CREATE TABLE TAG (
  id INTEGER NOT NULL,
  name  VARCHAR(31) NOT NULL
);

ALTER TABLE TAG ADD CONSTRAINT PK_TAG PRIMARY KEY (id);
ALTER TABLE TAG ADD CONSTRAINT TAG_UNQ_NAME UNIQUE (name);