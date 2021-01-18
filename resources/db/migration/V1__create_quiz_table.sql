CREATE TABLE "Quiz" (
    "quiz_id" serial NOT NULL,
    "pet_id" integer NOT NULL,
    "quiz_date" DATE NOT NULL,
    CONSTRAINT "Quiz_pk" PRIMARY KEY ("quiz_id")
) WITH (
    OIDS=FALSE
);

ALTER TABLE "Quiz" ADD CONSTRAINT "Quiz_fk0" FOREIGN KEY ("quiz_id") REFERENCES "Quiz Model"("quiz_id");
ALTER TABLE "Quiz" ADD CONSTRAINT "Quiz_fk1" FOREIGN KEY ("pet_id") REFERENCES "Pet"("pet_id");