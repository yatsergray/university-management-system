alter table if exists department_lectors
    drop constraint if exists fk_department_lectors_lector_id;
alter table if exists department_lectors
    drop constraint if exists fk_department_lectors_department_id;
alter table if exists departments
    drop constraint if exists fk_departments_head_id;
alter table if exists lectors
    drop constraint if exists fk_lectors_degree_id;
