CREATE TABLE "Animal Type" (
    "type_id" serial NOT NULL,
    "type_name" VARCHAR(30) NOT NULL,
    CONSTRAINT "Animal Type_pk" PRIMARY KEY ("type_id")
) WITH (
    OIDS=FALSE
);