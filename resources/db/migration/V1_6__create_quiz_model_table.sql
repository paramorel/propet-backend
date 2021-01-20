CREATE TABLE "Quiz Model" (
    "quiz_id" integer NOT NULL,
    "activity" VARCHAR(30) NOT NULL,
    "mood" VARCHAR(30) NOT NULL,
    "wool" VARCHAR(30) NOT NULL,
    CONSTRAINT "Quiz Model_pk" PRIMARY KEY ("quiz_id")
) WITH (
    OIDS=FALSE
);
