CREATE DATABASE hibernate_example;

USE hibernate_example;

INSERT INTO hibernate_example.transactions (amount, type, transaction_date)
VALUES (100.00, 'C', '2024-04-25 13:02:00');
INSERT INTO hibernate_example.transactions (amount, type, transaction_date)
VALUES (200.02, 'D', '2024-04-25 13:07:00');

SELECT * FROM transactions;

SELECT * FROM accounts;

-- DROP DATABASE hibernate_example;