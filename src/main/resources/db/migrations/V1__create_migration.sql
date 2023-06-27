create schema if not exists medical;
create table medical.consulta (
                                  id  bigserial not null,
                                  consulta_status_enum int4,
                                  data_cadastro date,
                                  description varchar(255),
                                  medico varchar(255),
                                  username varchar(255),
                                  primary key (id)
);
create table medical.medical (
                                 id  bigserial not null,
                                 data_cadastro date,
                                 evolution varchar(255),
                                 recipe varchar(255),
                                 user_id int8,
                                 primary key (id)
);
