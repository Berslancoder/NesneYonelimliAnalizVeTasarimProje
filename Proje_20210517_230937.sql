--
-- PostgreSQL database dump
--

-- Dumped from database version 13.1
-- Dumped by pg_dump version 13.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: kullanici; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.kullanici (
    kullaniciadi text NOT NULL,
    sifre text NOT NULL,
    yetki text NOT NULL,
    id text NOT NULL
);


ALTER TABLE public.kullanici OWNER TO postgres;

--
-- Data for Name: kullanici; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.kullanici VALUES
	('Mehmet', '54321', 'var', '1'),
	('Selim', '123abc', 'yok', '2'),
	('Ahmet', '12345', 'var', '3');


--
-- Name: kullanici kullanici_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanici
    ADD CONSTRAINT kullanici_pkey PRIMARY KEY (kullaniciadi);


--
-- Name: kullanici unique_kullanici_id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanici
    ADD CONSTRAINT unique_kullanici_id UNIQUE (id);


--
-- Name: kullanici unique_kullanici_kullaniciadi; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.kullanici
    ADD CONSTRAINT unique_kullanici_kullaniciadi UNIQUE (kullaniciadi);


--
-- PostgreSQL database dump complete
--

