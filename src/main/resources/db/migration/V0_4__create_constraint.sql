alter table if exists department_lectors
    add constraint fk_department_lectors_lector_id foreign key (lector_id) references lectors (id);
alter table if exists department_lectors
    add constraint fk_department_lectors_department_id foreign key (department_id) references departments (id);
alter table if exists departments
    add constraint fk_departments_head_id foreign key (head_id) references lectors (id);
alter table if exists lectors
    add constraint fk_lectors_degree_id foreign key (degree_id) references degrees (id);
