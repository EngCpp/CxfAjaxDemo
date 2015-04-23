--
-- PostgreSQL database dump
--

-- Started on 2002-01-01 00:09:28 BRST

SET client_encoding = 'UTF8';
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1529 (class 0 OID 0)
-- Dependencies: 5
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'Standard public schema';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1185 (class 1259 OID 16470)
-- Dependencies: 5
-- Name: bairro; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE bairro (
    cidade_codigo integer NOT NULL,
    bairro_codigo integer NOT NULL,
    bairro_descricao character varying(72)
);


--
-- TOC entry 1186 (class 1259 OID 16472)
-- Dependencies: 5
-- Name: cidade; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE cidade (
    uf_codigo integer NOT NULL,
    cidade_codigo integer NOT NULL,
    cidade_descricao character varying(72) NOT NULL,
    cidade_cep character varying(8) NOT NULL
);


--
-- TOC entry 1187 (class 1259 OID 16474)
-- Dependencies: 5
-- Name: endereco; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE endereco (
    bairro_codigo integer NOT NULL,
    endereco_codigo integer NOT NULL,
    endereco_cep character varying(8),
    endereco_logradouro character varying(72),
    endereco_complemento character varying(72)
);


--
-- TOC entry 1188 (class 1259 OID 16476)
-- Dependencies: 5
-- Name: uf; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE uf (
    uf_codigo integer NOT NULL,
    uf_sigla character varying(2) NOT NULL,
    uf_descricao character varying(72) NOT NULL
);


--
-- TOC entry 1189 (class 1259 OID 16478)
-- Dependencies: 1255 5
-- Name: vw_enderecos; Type: VIEW; Schema: public; Owner: postgres
--

CREATE VIEW vw_enderecos AS
    SELECT a.uf_sigla, a.uf_descricao, b.cidade_codigo, b.cidade_descricao, c.bairro_codigo, c.bairro_descricao, d.endereco_logradouro, d.endereco_cep, d.endereco_complemento FROM uf a, cidade b, bairro c, endereco d WHERE (((a.uf_codigo = b.uf_codigo) AND (b.cidade_codigo = c.cidade_codigo)) AND (c.bairro_codigo = d.bairro_codigo));


--
-- TOC entry 1513 (class 2606 OID 16482)
-- Dependencies: 1185 1185
-- Name: bairropk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY bairro
    ADD CONSTRAINT bairropk PRIMARY KEY (bairro_codigo);


--
-- TOC entry 1515 (class 2606 OID 16484)
-- Dependencies: 1186 1186
-- Name: cidadepk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY cidade
    ADD CONSTRAINT cidadepk PRIMARY KEY (cidade_codigo);


--
-- TOC entry 1517 (class 2606 OID 16486)
-- Dependencies: 1187 1187
-- Name: enderecopk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT enderecopk PRIMARY KEY (endereco_codigo);


--
-- TOC entry 1520 (class 2606 OID 16488)
-- Dependencies: 1188 1188
-- Name: ufpk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY uf
    ADD CONSTRAINT ufpk PRIMARY KEY (uf_codigo);


--
-- TOC entry 1518 (class 1259 OID 16489)
-- Dependencies: 1187
-- Name: indx_cep; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX indx_cep ON endereco USING btree (endereco_cep);


--
-- TOC entry 1525 (class 2606 OID 16490)
-- Dependencies: 1187 1185 1512
-- Name: bairrofk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT bairrofk FOREIGN KEY (bairro_codigo) REFERENCES bairro(bairro_codigo) ON DELETE CASCADE;


--
-- TOC entry 1521 (class 2606 OID 16495)
-- Dependencies: 1185 1186 1514
-- Name: cidadefk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bairro
    ADD CONSTRAINT cidadefk FOREIGN KEY (cidade_codigo) REFERENCES cidade(cidade_codigo) ON DELETE CASCADE;


--
-- TOC entry 1522 (class 2606 OID 16500)
-- Dependencies: 1185 1186 1514
-- Name: fk74563de5fd1e63f8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY bairro
    ADD CONSTRAINT fk74563de5fd1e63f8 FOREIGN KEY (cidade_codigo) REFERENCES cidade(cidade_codigo);


--
-- TOC entry 1523 (class 2606 OID 16505)
-- Dependencies: 1186 1188 1519
-- Name: fk76794b246f2aff58; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cidade
    ADD CONSTRAINT fk76794b246f2aff58 FOREIGN KEY (uf_codigo) REFERENCES uf(uf_codigo);


--
-- TOC entry 1526 (class 2606 OID 16510)
-- Dependencies: 1187 1185 1512
-- Name: fk95d357c91accf8d8; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT fk95d357c91accf8d8 FOREIGN KEY (bairro_codigo) REFERENCES bairro(bairro_codigo);


--
-- TOC entry 1524 (class 2606 OID 16515)
-- Dependencies: 1186 1188 1519
-- Name: uffk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY cidade
    ADD CONSTRAINT uffk FOREIGN KEY (uf_codigo) REFERENCES uf(uf_codigo) ON DELETE CASCADE;


--
-- TOC entry 1530 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2002-01-01 00:09:29 BRST

--
-- PostgreSQL database dump complete
--

