CREATE TABLE "Pet" (
    "pet_id" serial NOT NULL,
    "name" VARCHAR(100) NOT NULL,
    "birthday" DATE NOT NULL,
    "weight" integer NOT NULL,
    "specificity" TEXT NOT NULL,
    "breed" integer NOT NULL,
    "type_id" integer NOT NULL,
    CONSTRAINT "Pet_pk" PRIMARY KEY ("pet_id")
) WITH (
      OIDS=FALSE
);

ALTER TABLE "Pet" ADD CONSTRAINT "Pet_fk0" FOREIGN KEY ("breed") REFERENCES "Breeds"("breed_id");
ALTER TABLE "Pet" ADD CONSTRAINT "Pet_fk1" FOREIGN KEY ("type_id") REFERENCES "Animal Type"("type_id");