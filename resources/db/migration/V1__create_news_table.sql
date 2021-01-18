CREATE TABLE "News" (
    "user_id" integer NOT NULL,
    "news_id" serial NOT NULL,
    "title" TEXT NOT NULL,
    "content" TEXT NOT NULL,
    "pub_date" DATE NOT NULL,
    CONSTRAINT "News_pk" PRIMARY KEY ("news_id")
) WITH (
    OIDS=FALSE
);

ALTER TABLE "News" ADD CONSTRAINT "News_fk0" FOREIGN KEY ("user_id") REFERENCES "Users"("user_id");
