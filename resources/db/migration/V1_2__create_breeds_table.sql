CREATE TABLE "Breeds" (
    "breed_id" serial NOT NULL,
    "breed_name" VARCHAR(100) NOT NULL,
    "type_id" integer NOT NULL,
    CONSTRAINT "Breeds_pk" PRIMARY KEY ("breed_id")
) WITH (
    OIDS=FALSE
);

ALTER TABLE "Breeds" ADD CONSTRAINT "Breeds_fk0" FOREIGN KEY ("type_id") REFERENCES "Animal Type"("type_id");
