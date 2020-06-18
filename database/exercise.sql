DROP TABLE IF EXISTS exercise;

DROP SEQUENCE IF EXISTS exercise_id_seq;

CREATE SEQUENCE exercise_id_seq
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE exercise (
  id integer DEFAULT nextval('exercise_id_seq'::regclass) NOT NULL,
  name varchar(80) NOT NULL,          -- Name of the exercise
  CONSTRAINT pk_exercise_id PRIMARY KEY (id)
);
