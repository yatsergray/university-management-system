INSERT INTO degrees (id, name, type)
VALUES ('0be7f9f1-b5d3-4b4e-8aa7-5bde1e8d5c7e', 'Professor', 'PROFESSOR'),
       ('1f78b9e3-94c6-4d1d-8f16-bde3485f1c28', 'Associate professor', 'ASSOCIATE_PROFESSOR'),
       ('2e17f823-8f5d-4a3e-b9c1-3c4d76e5a1f0', 'Assistant', 'ASSISTANT');

INSERT INTO lectors (id, salary, degree_id, first_name, last_name)
VALUES ('ad0c03cf-7a6e-41b1-96e5-74934b2eaf20', 85000.00, '0be7f9f1-b5d3-4b4e-8aa7-5bde1e8d5c7e', 'Lucas', 'Martin'),
       ('93b7e7f8-2ef4-4c8a-879e-3285d3a4b1fc', 67000.00, '1f78b9e3-94c6-4d1d-8f16-bde3485f1c28', 'Sophie', 'Rodriguez'),
       ('d0a84db1-6c83-4b92-8710-5f3e27b0b8b4', 78000.00, '2e17f823-8f5d-4a3e-b9c1-3c4d76e5a1f0', 'Daniel', 'Perez'),
       ('0fb7e4d5-8c29-4fae-a07d-21e95a2f831b', 95000.00, '0be7f9f1-b5d3-4b4e-8aa7-5bde1e8d5c7e', 'Emma', 'Lopez'),
       ('1e4f5b23-798a-4a3f-97b5-6be19e8a72cf', 72000.00, '1f78b9e3-94c6-4d1d-8f16-bde3485f1c28', 'Oliver', 'Gonzalez'),
       ('7c8b3a5f-5a1c-438b-8296-5d38f2b74c9f', 67000.00, '2e17f823-8f5d-4a3e-b9c1-3c4d76e5a1f0', 'Ava', 'Wilson'),
       ('8f7d03ac-12e5-49b2-b9d5-739f2a8d3f74', 86000.00, '0be7f9f1-b5d3-4b4e-8aa7-5bde1e8d5c7e', 'Benjamin', 'Nguyen'),
       ('4c5f7b8a-23ef-4d83-85c7-76f2b9a74e1f', 80000.00, '1f78b9e3-94c6-4d1d-8f16-bde3485f1c28', 'Mia', 'Hernandez'),
       ('c1e2a3d4-7f8b-4a29-813d-5e9f7b6d2c31', 78000.00, '2e17f823-8f5d-4a3e-b9c1-3c4d76e5a1f0', 'Ethan', 'Martinez'),
       ('92f47d1e-6c3b-4b18-bf5d-74a21e8c5f07', 67000.00, '0be7f9f1-b5d3-4b4e-8aa7-5bde1e8d5c7e', 'Chloe', 'Anderson'),
       ('ae7b03c8-2d5f-4fa9-813b-72f9a5c1b6d3', 72000.00, '1f78b9e3-94c6-4d1d-8f16-bde3485f1c28', 'James', 'Thomas'),
       ('5a7f8b92-4c1e-4d87-b93a-7b6e1c8f3a25', 85000.00, '2e17f823-8f5d-4a3e-b9c1-3c4d76e5a1f0', 'Charlotte', 'Jackson'),
       ('c2d8a74f-9b6c-41d5-8a1b-3f7e29b05d4a', 75000.00, '0be7f9f1-b5d3-4b4e-8aa7-5bde1e8d5c7e', 'Aiden', 'White'),
       ('8c1b03d7-2a9e-4c7f-b913-5d2e6f7b4a1f', 80000.00, '1f78b9e3-94c6-4d1d-8f16-bde3485f1c28', 'Lily', 'Lee');

INSERT INTO departments (id, head_id, name)
VALUES ('f07b13d2-6c8f-4b5a-97d4-1a9c7e8b02f6', 'ad0c03cf-7a6e-41b1-96e5-74934b2eaf20', 'Physics'),
       ('4b2f91d7-8c0a-47e5-a9b1-3d4e76f2c5a8', '93b7e7f8-2ef4-4c8a-879e-3285d3a4b1fc', 'Chemistry'),
       ('2d6a73c1-8f0b-4e19-a7f5-3b9e24a58d7c', 'd0a84db1-6c83-4b92-8710-5f3e27b0b8b4', 'Mechanical Engineering'),
       ('3e7a45b2-8c5d-4a19-b72f-5e1c93f7b04d', '0fb7e4d5-8c29-4fae-a07d-21e95a2f831b', 'Civil Engineering'),
       ('1f7a92b8-0c4d-4e18-a5b3-7d4f29c1e8a5', '1e4f5b23-798a-4a3f-97b5-6be19e8a72cf', 'Economics'),
       ('3b9e21c7-4f5a-48e2-a7b1-6c0a83d2f9e4', '7c8b3a5f-5a1c-438b-8296-5d38f2b74c9f', 'Law'),
       ('8a4d92c1-5f7b-4b3e-b19d-6e3a85f29c1f', '8f7d03ac-12e5-49b2-b9d5-739f2a8d3f74', 'Business Administration'),
       ('9f3a17b5-8c2e-47f5-a7d1-6b1c8f3d4e9a', '4c5f7b8a-23ef-4d83-85c7-76f2b9a74e1f', 'Psychology'),
       ('0c7f21b5-4a9e-8f3e-b6d1-3a5e29c1d7f4', 'c1e2a3d4-7f8b-4a29-813d-5e9f7b6d2c31', 'History');

INSERT INTO department_lectors (department_id, lector_id)
VALUES ('f07b13d2-6c8f-4b5a-97d4-1a9c7e8b02f6', 'ad0c03cf-7a6e-41b1-96e5-74934b2eaf20'),
       ('4b2f91d7-8c0a-47e5-a9b1-3d4e76f2c5a8', '93b7e7f8-2ef4-4c8a-879e-3285d3a4b1fc'),
       ('2d6a73c1-8f0b-4e19-a7f5-3b9e24a58d7c', 'd0a84db1-6c83-4b92-8710-5f3e27b0b8b4'),
       ('3e7a45b2-8c5d-4a19-b72f-5e1c93f7b04d', '0fb7e4d5-8c29-4fae-a07d-21e95a2f831b'),
       ('1f7a92b8-0c4d-4e18-a5b3-7d4f29c1e8a5', '1e4f5b23-798a-4a3f-97b5-6be19e8a72cf'),
       ('3b9e21c7-4f5a-48e2-a7b1-6c0a83d2f9e4', '7c8b3a5f-5a1c-438b-8296-5d38f2b74c9f'),
       ('8a4d92c1-5f7b-4b3e-b19d-6e3a85f29c1f', '8f7d03ac-12e5-49b2-b9d5-739f2a8d3f74'),
       ('9f3a17b5-8c2e-47f5-a7d1-6b1c8f3d4e9a', '4c5f7b8a-23ef-4d83-85c7-76f2b9a74e1f'),
       ('0c7f21b5-4a9e-8f3e-b6d1-3a5e29c1d7f4', 'c1e2a3d4-7f8b-4a29-813d-5e9f7b6d2c31');
