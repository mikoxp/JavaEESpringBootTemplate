CREATE TABLE groups
(
  id SERIAL,
  name character varying(30),
  CONSTRAINT groups_pkey PRIMARY KEY (id)
);
CREATE TABLE account
(
  id SERIAL PRIMARY KEY,
  login character varying(40) UNIQUE,
  password character varying(40),
  user_name character varying(30),
  id_group integer,
  password_restarted boolean,
  enabled boolean,
  CONSTRAINT account_id_group_fkey FOREIGN KEY (id_group) REFERENCES public.groups (id)
);
CREATE TABLE roles
(
  id SERIAL,
  name character varying(50) NOT NULL,
  CONSTRAINT roles_pkey PRIMARY KEY (id)
);
CREATE TABLE groups_roles
(
  groups_id integer NOT NULL,
  roles_id integer NOT NULL,
  CONSTRAINT pkey PRIMARY KEY (groups_id, roles_id),
  CONSTRAINT fk1 FOREIGN KEY (groups_id) REFERENCES groups (id),
  CONSTRAINT fk2 FOREIGN KEY (roles_id) REFERENCES roles (id)
);
