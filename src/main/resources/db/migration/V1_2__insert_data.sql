insert into role (name) values ('ADMIN');
insert into role (name) values ('EMPLOYEE');

INSERT INTO users(first_name, last_name, email, password,
role_id, active) VALUES ('Margeta', 'Edi', 'edimargeta@gmail.com',
'$2y$12$Q7gj1w4sKfXNhjmbeIA7bOl3kTZh/RfAa1XcevvX07yZZQkk496B6', 1, true);