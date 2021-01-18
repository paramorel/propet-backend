CREATE TABLE "Owners" (
    "user_id" integer NOT NULL,
    "pet_id" integer NOT NULL
) WITH (
    OIDS=FALSE
);

ALTER TABLE "Owners" ADD CONSTRAINT "Owners_fk0" FOREIGN KEY ("user_id") REFERENCES "Users"("user_id");
ALTER TABLE "Owners" ADD CONSTRAINT "Owners_fk1" FOREIGN KEY ("pet_id") REFERENCES "Pet"("pet_id");