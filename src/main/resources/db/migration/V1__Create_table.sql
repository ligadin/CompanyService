CREATE SEQUENCE IF NOT EXISTS company_id_seq
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807;

CREATE TABLE IF NOT EXISTS company (
	id int8 NOT NULL DEFAULT nextval('company_id_seq'::regclass),
	name varchar NOT NULL,
	website varchar NOT NULL,
	email varchar NULL,
	size varchar NULL,
	industry varchar NULL,
	CONSTRAINT company_pk PRIMARY KEY (id)
);