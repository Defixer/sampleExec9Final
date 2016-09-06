--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: postgres; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE postgres IS 'default administrative connection database';


--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: address; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE address (
    addressid bigint NOT NULL,
    addnumber character varying(255),
    addstreet character varying(255),
    addbarangay character varying(255),
    addtown character varying(255),
    addprovince character varying(255),
    addzipcode integer
);


ALTER TABLE public.address OWNER TO postgres;

--
-- Name: contact; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE contact (
    contactid bigint NOT NULL,
    mobilenumber bigint,
    landlinenumber bigint,
    emailaddress character varying(255)
);


ALTER TABLE public.contact OWNER TO postgres;

--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.hibernate_sequence OWNER TO postgres;

--
-- Name: person; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE person (
    id bigint NOT NULL,
    firstname character varying(255),
    middlename character varying(255),
    lastname character varying(255),
    suffixname character varying(255),
    titlename character varying(255),
    gender character varying(255),
    age integer,
    birthday character varying(255),
    datehired character varying(255),
    currentlyemployed boolean,
    address bigint NOT NULL,
    contact bigint NOT NULL,
    grade character varying(255)
);


ALTER TABLE public.person OWNER TO postgres;

--
-- Name: person_role; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE person_role (
    person_id bigint NOT NULL,
    role_id bigint NOT NULL
);


ALTER TABLE public.person_role OWNER TO postgres;

--
-- Name: role; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE role (
    roleid bigint NOT NULL,
    rolename character varying(255)
);


ALTER TABLE public.role OWNER TO postgres;

--
-- Name: t_person; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE t_person (
    id bigint NOT NULL,
    firstname character varying(255),
    middlename character varying(255),
    lastname character varying(255),
    suffixname character varying(255),
    titlename character varying(255),
    gender character varying(255),
    age integer,
    birthday character varying(255),
    datehired character varying(255),
    currentlyemployed boolean
);


ALTER TABLE public.t_person OWNER TO postgres;

--
-- Data for Name: address; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY address (addressid, addnumber, addstreet, addbarangay, addtown, addprovince, addzipcode) FROM stdin;
6	123	Street	Brgy	Town	Province	1234
8	21	lkj	lkj	lop	opi	12
11	87	kjh	kjh	khj	kjh	87
14	98	jkh	hj	mnb	mnb	98
17	98	lkj	lk	kj	lj	98
20	7	7	7	7	7	7
23	9	9	9	9	9	9
25	9	9	9	9	9	9
28	123	Street	Barangay	Town	Province	1234
31	123	St	Brgy	Town	Prov	0
37	111	St.	Brgy.	Albay	Bicol	333
34	045	Emerald	BNT	Imus	Cavite	340
46	9	9	9	9	9	9
49	045	Emeraldss	BNT	Imus	Cavite	340
54	9	9	9	9	9	9
57	9	9	9	9	9	9
61	0000	Terminal	Directory	Variable	Integer	1111
\.


--
-- Data for Name: contact; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY contact (contactid, mobilenumber, landlinenumber, emailaddress) FROM stdin;
7	123345	12345	e@gmail.com
9	12	12	po
12	78	98	h
15	98	98	kjh
18	7	987	jh
21	7	7	7
24	9	9	9
26	9	9	9
29	12334	12345	a@g.com
32	12345	12345	a@g.com
38	999	999	l@l.com
35	1234	12345	hhh@g.com
47	9	9	9
50	123411	12345	hhh@g.comss
55	9	9	9
58	999	999	999
62	19283949	32439	a@a.com
\.


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('hibernate_sequence', 60, true);


--
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY person (id, firstname, middlename, lastname, suffixname, titlename, gender, age, birthday, datehired, currentlyemployed, address, contact, grade) FROM stdin;
30	Ervein	Bravo	Cabanlig	I	Mr.	Male	23	1/1/1991	1/1/1999	t	28	29	\N
36	Juan	Castro	Dela Cruz	Jr.	Mr.	Male	27	2/2/1999	3/3/2000	t	34	35	1.25
51	Juanss	Castro	Dela Cruz	Jr.	Mr.	Male	27	2/2/1999	3/3/2000	t	49	50	1.25
63	Linux	Windows	Mac	Os	Ms.	Female	29	1/1/1998	1/2/2003	t	61	62	1.50
33	Fname	Mname	LName	II	Ms.	Male	24	1/1/1999	3/1/2006	f	31	32	\N
\.


--
-- Data for Name: person_role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY person_role (person_id, role_id) FROM stdin;
63	45
63	52
30	4
30	3
63	4
63	3
63	5
63	43
33	5
33	45
33	3
33	52
36	3
36	5
33	4
33	43
51	3
51	5
\.


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY role (roleid, rolename) FROM stdin;
5	Developer
45	Add Role
3	Team Leader
52	TL
4	Admin
43	QA
\.


--
-- Data for Name: t_person; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY t_person (id, firstname, middlename, lastname, suffixname, titlename, gender, age, birthday, datehired, currentlyemployed) FROM stdin;
1	Ervein	Bravo	Cabanlig	Jr		Male	24	1/1/1991	1/1/1991	t
2	sdf	ssaf	sd			sdf	23	g	arg	t
3							23			t
4							23			t
5							23			t
6							23			t
7							23			t
8	Ervein		Cabanlig				23			t
9	Allan		sdklf				24			f
\.


--
-- Name: address_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY address
    ADD CONSTRAINT address_pkey PRIMARY KEY (addressid);


--
-- Name: contact_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY contact
    ADD CONSTRAINT contact_pkey PRIMARY KEY (contactid);


--
-- Name: person_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY person
    ADD CONSTRAINT person_pkey PRIMARY KEY (id);


--
-- Name: person_role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY person_role
    ADD CONSTRAINT person_role_pkey PRIMARY KEY (person_id, role_id);


--
-- Name: role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY role
    ADD CONSTRAINT role_pkey PRIMARY KEY (roleid);


--
-- Name: t_person_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY t_person
    ADD CONSTRAINT t_person_pkey PRIMARY KEY (id);


--
-- Name: uk_o9mt7dgeowauwahhjma2y0g2u; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY person
    ADD CONSTRAINT uk_o9mt7dgeowauwahhjma2y0g2u UNIQUE (contact);


--
-- Name: uk_tdsar3o0n1qkyc2xgumd65asm; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY person
    ADD CONSTRAINT uk_tdsar3o0n1qkyc2xgumd65asm UNIQUE (address);


--
-- Name: fk_458lv06oshoclwbdra9a3kawb; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY person_role
    ADD CONSTRAINT fk_458lv06oshoclwbdra9a3kawb FOREIGN KEY (person_id) REFERENCES person(id);


--
-- Name: fk_anrucmekmrc4a8l2lqg6c6swr; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY person_role
    ADD CONSTRAINT fk_anrucmekmrc4a8l2lqg6c6swr FOREIGN KEY (role_id) REFERENCES role(roleid);


--
-- Name: fk_o9mt7dgeowauwahhjma2y0g2u; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY person
    ADD CONSTRAINT fk_o9mt7dgeowauwahhjma2y0g2u FOREIGN KEY (contact) REFERENCES contact(contactid);


--
-- Name: fk_tdsar3o0n1qkyc2xgumd65asm; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY person
    ADD CONSTRAINT fk_tdsar3o0n1qkyc2xgumd65asm FOREIGN KEY (address) REFERENCES address(addressid);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

