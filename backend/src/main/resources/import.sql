INSERT INTO tb_unit (name) VALUES ('PowerGym Porto Alegre')
INSERT INTO tb_unit (name) VALUES ('PowerGym São Paulo')
INSERT INTO tb_unit (name) VALUES ('PowerGym Canoas')

INSERT INTO tb_user (email, name, password, phone, birth_date, unit_id) VALUES ('joao@gmail.com', 'João Bastos', '$2a$10$OSNfdVo/GAF2A5BPYPW85OnVeTag.iZOyHBBIErdBvvT9hWKv9Y56', '(51)99182-4370', '2003-02-14', 1)
INSERT INTO tb_user (email, name, password, phone, birth_date, unit_id) VALUES ('maria@gmail.com', 'Maria Silva', '$2a$10$OSNfdVo/GAF2A5BPYPW85OnVeTag.iZOyHBBIErdBvvT9hWKv9Y56', '(47)98876-5432', '1995-07-21', 1)
INSERT INTO tb_user (email, name, password, phone, birth_date, unit_id) VALUES ('pedro@hotmail.com', 'Pedro Santos', '$2a$10$OSNfdVo/GAF2A5BPYPW85OnVeTag.iZOyHBBIErdBvvT9hWKv9Y56', '(55)98765-4321', '1988-12-02', 1)
INSERT INTO tb_user (email, name, password, phone, birth_date, unit_id) VALUES ('ana@yahoo.com', 'Ana Ferreira', '$2a$10$OSNfdVo/GAF2A5BPYPW85OnVeTag.iZOyHBBIErdBvvT9hWKv9Y56', '(61)91234-5678', '2000-04-10', 1)
INSERT INTO tb_user (email, name, password, phone, birth_date, unit_id) VALUES ('carlos@outlook.com', 'Carlos Mendes', '$2a$10$OSNfdVo/GAF2A5BPYPW85OnVeTag.iZOyHBBIErdBvvT9hWKv9Y56', '(48)98888-8888', '1992-09-15', 1)
INSERT INTO tb_user (email, name, password, phone, birth_date, unit_id) VALUES ('laura@gmail.com', 'Laura Costa', '$2a$10$OSNfdVo/GAF2A5BPYPW85OnVeTag.iZOyHBBIErdBvvT9hWKv9Y56', '(41)97777-7777', '1997-11-30', 1)
INSERT INTO tb_user (email, name, password, phone, birth_date, unit_id) VALUES ('rodrigo@yahoo.com', 'Rodrigo Almeida', '$2a$10$OSNfdVo/GAF2A5BPYPW85OnVeTag.iZOyHBBIErdBvvT9hWKv9Y56', '(31)96666-6666', '1985-03-18', 2)
INSERT INTO tb_user (email, name, password, phone, birth_date, unit_id) VALUES ('patricia@hotmail.com', 'Patricia Gomes', '$2a$10$OSNfdVo/GAF2A5BPYPW85OnVeTag.iZOyHBBIErdBvvT9hWKv9Y56', '(81)95555-5555', '1990-08-24', 2)
INSERT INTO tb_user (email, name, password, phone, birth_date, unit_id) VALUES ('rafael@gmail.com', 'Rafael Barbosa', '$2a$10$OSNfdVo/GAF2A5BPYPW85OnVeTag.iZOyHBBIErdBvvT9hWKv9Y56', '(53)94444-4444', '1987-06-09', 2)
INSERT INTO tb_user (email, name, password, phone, birth_date, unit_id) VALUES ('julia@yahoo.com', 'Julia Lima', '$2a$10$OSNfdVo/GAF2A5BPYPW85OnVeTag.iZOyHBBIErdBvvT9hWKv9Y56', '(21)93333-3333', '1999-01-07', 2)
INSERT INTO tb_user (email, name, password, phone, birth_date, unit_id) VALUES ('fernando@outlook.com', 'Fernando Oliveira', '$2a$10$OSNfdVo/GAF2A5BPYPW85OnVeTag.iZOyHBBIErdBvvT9hWKv9Y56', '(84)92222-2222', '1983-05-26', 2)

INSERT INTO tb_workout (name, user_id) VALUES ('Treino A', 1)
INSERT INTO tb_workout (name, user_id) VALUES ('Treino B', 1)
INSERT INTO tb_workout (name, user_id) VALUES ('Treino C', 1)
INSERT INTO tb_workout (name, user_id) VALUES ('Treino A', 2)
INSERT INTO tb_workout (name, user_id) VALUES ('Treino B', 2)
INSERT INTO tb_workout (name, user_id) VALUES ('Treino C', 2)

INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Supino Reto', 3, 12, 20, 1)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Tríceps Corda', 3, 12, 5, 1)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Desenvolvimento', 3, 12, 8, 1)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Rosca Direta', 3, 12, 8, 2)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Puxada Supinada', 3, 12, 20, 2)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Remada Neutra', 3, 12, 20, 2)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Agachamento Livre', 3, 12, 30, 3)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Leg Press 45', 3, 12, 50, 3)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Cadeira Extensora', 3, 12, 20, 3)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Supino Reto', 3, 12, 30, 4)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Tríceps Corda', 3, 12, 7, 4)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Desenvolvimento', 3, 12, 12, 4)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Rosca Direta', 3, 12, 14, 5)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Puxada Supinada', 3, 12, 35, 5)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Remada Neutra', 3, 12, 40, 5)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Agachamento Livre', 3, 12, 80, 6)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Leg Press 45', 3, 12, 120, 6)
INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Cadeira Extensora', 3, 12, 45, 6)

INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT')
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN')

INSERT INTO tb_user_role (user_id, role_id) VALUES (1,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (2,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (3,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (4,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (5,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (6,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (7,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (8,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (9,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (10,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (11,1)
INSERT INTO tb_user_role (user_id, role_id) VALUES (11,2)

INSERT INTO tb_client_address (state, city, zip, street, number, client_id) VALUES ('RS', 'Canoas', '92200-580', 'Rua Diretor Augusto Pestana', 328, 1)
INSERT INTO tb_client_address (state, city, zip, street, number, client_id) VALUES ('RS', 'Porto Alegre', '90010-000', 'Avenida Borges de Medeiros', 123, 2)
INSERT INTO tb_client_address (state, city, zip, street, number, client_id) VALUES ('RS', 'Porto Alegre', '90420-060', 'Rua Mostardeiro', 456, 3)
INSERT INTO tb_client_address (state, city, zip, street, number, client_id) VALUES ('RS', 'Porto Alegre', '91330-002', 'Avenida Ipiranga', 789, 4)
INSERT INTO tb_client_address (state, city, zip, street, number, client_id) VALUES ('RS', 'Porto Alegre', '90570-010', 'Rua Ramiro Barcelos', 1011, 5)
INSERT INTO tb_client_address (state, city, zip, street, number, client_id) VALUES ('RS', 'Porto Alegre', '90619-900', 'Avenida Protásio Alves', 1213, 6)
INSERT INTO tb_client_address (state, city, zip, street, number, client_id) VALUES ('SP', 'São Paulo', '01001-000', 'Rua Direita', 14, 7)
INSERT INTO tb_client_address (state, city, zip, street, number, client_id) VALUES ('SP', 'São Paulo', '01310-100', 'Avenida Paulista', 987, 8)
INSERT INTO tb_client_address (state, city, zip, street, number, client_id) VALUES ('SP', 'São Paulo', '04578-900', 'Rua Oscar Freire', 654, 9)
INSERT INTO tb_client_address (state, city, zip, street, number, client_id) VALUES ('SP', 'São Paulo', '05007-000', 'Rua Turiassu', 321, 10)
INSERT INTO tb_client_address (state, city, zip, street, number, client_id) VALUES ('SP', 'São Paulo', '01012-001', 'Viaduto do Chá', 543, 11)

INSERT INTO tb_unit_address (state, city, zip, street, number, unit_id) VALUES ('RS', 'Porto Alegre', '90020-025', 'Rua Borges de Medeiros', 200, 1)
INSERT INTO tb_unit_address (state, city, zip, street, number, unit_id) VALUES ('SP', 'São Paulo', '02031-000', 'Avenida Cruzeiro do Sul', 1890, 2)
INSERT INTO tb_unit_address (state, city, zip, street, number, unit_id) VALUES ('RS', 'Canoas', '92310-190', 'Rua Domingos Martins', 1023, 3)

INSERT INTO tb_plan (name, price, description) VALUES ('Bronze', 50.00, 'Plano Básico')
INSERT INTO tb_plan (name, price, description) VALUES ('Silver', 100.00, 'Plano Silver')
INSERT INTO tb_plan (name, price, description) VALUES ('Gold', 200.00, 'Melhor plano')

INSERT INTO tb_contract (start_date, end_date, installment_price, client_id, plan_id, unit_id) VALUES ('2024-01-01', '2024-01-31', 50.00, 1, 1, 1)
INSERT INTO tb_contract (start_date, end_date, installment_price, client_id, plan_id, unit_id) VALUES ('2024-01-01', '2024-12-31', 200.00, 2, 3, 1)

INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (50.00, 0, '2024-01-31', null, 1, 1)

INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (200.00, 1, '2024-01-31', '2024-01-15T15:34:22Z', 2, 1)
INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (200.00, 0, '2024-02-29', null, 2, 1)
INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (200.00, 0, '2024-03-31', null, 2, 1)
INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (200.00, 0, '2024-04-30', null, 2, 1)
INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (200.00, 0, '2024-05-31', null, 2, 1)
INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (200.00, 0, '2024-06-30', null, 2, 1)
INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (200.00, 0, '2024-07-31', null, 2, 1)
INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (200.00, 0, '2024-08-31', null, 2, 1)
INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (200.00, 0, '2024-09-30', null, 2, 1)
INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (200.00, 0, '2024-10-31', null, 2, 1)
INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (200.00, 0, '2024-11-30', null, 2, 1)
INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (200.00, 0, '2024-12-31', null, 2, 1)




