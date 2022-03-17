CREATE TABLE public.author (
	id int8 NOT NULL,
	last_name varchar(255) NULL,
	author_name varchar(255) NULL,
	CONSTRAINT author_pkey PRIMARY KEY (id)
);

CREATE TABLE public.book (
	id int8 NOT NULL,
	title varchar(255) NULL,
	CONSTRAINT book_pkey PRIMARY KEY (id)
);

CREATE TABLE public.author_book (
	author_id int8 NOT NULL,
	book_id int8 NOT NULL,
	CONSTRAINT author_book_pkey PRIMARY KEY (author_id, book_id)
);

-- public.author_book foreign keys
ALTER TABLE public.author_book ADD CONSTRAINT fkg7j6ud9d32ll232o9mgo90s57 FOREIGN KEY (author_id) REFERENCES public.author(id);
ALTER TABLE public.author_book ADD CONSTRAINT fkn8665s8lv781v4eojs8jo3jao FOREIGN KEY (book_id) REFERENCES public.book(id);

CREATE SEQUENCE public.author_seq
	START WITH 1
	INCREMENT BY 50;

CREATE SEQUENCE public.book_seq
	START WITH 1
	INCREMENT BY 50;