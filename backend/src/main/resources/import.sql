INSERT INTO tb_unit (name) VALUES ('Power Canoas')

INSERT INTO tb_user (email, name, password, phone, birth_date, unit_id) VALUES ('joao@gmail.com', 'João', 'wqd6sa876d', '(51)99999-9999', '2003-02-14', 1)

INSERT INTO tb_workout (name, user_id) VALUES ('Treino A', 1)

INSERT INTO tb_exercise (name, sets, reps, weight, workout_id) VALUES ('Supino Reto', 3, 12, 20, 1)

INSERT INTO tb_client_address (state, city, zip, street, number, client_id) VALUES ('RS', 'Canoas', '92310-190', 'Rua Diretor Augusto Pestana', 328, 1)

INSERT INTO tb_unit_address (state, city, zip, street, number, unit_id) VALUES ('RS', 'Canoas', '92310-190', 'Rua Guilherme Schell', 200, 1)

INSERT INTO tb_plan (name, price, description) VALUES ('Bronze', 50.00, 'Plano Básico')

INSERT INTO tb_contract (start_date, end_date, installment_price, client_id, plan_id, unit_id) VALUES ('2024-01-01', '2024-01-31', 50.00, 1, 1, 1)

INSERT INTO tb_payment (price, status, due_date, payment_date, client_id, unit_id) VALUES (50.00, 0, '2024-01-31', null, 1, 1)




