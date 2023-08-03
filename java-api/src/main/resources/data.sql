INSERT INTO dogs (dog_id, name, age) VALUES (1, 'Einstein', 3);
INSERT INTO dogs (dog_id, name, age) VALUES (2, 'Kaya', 5);
INSERT INTO dogs (dog_id, name, age) VALUES (3, 'Lassie', 7);



/* Book (book_id, book_name */
INSERT INTO Book
(book_name)
SELECT book_name
FROM CSVREAD('C:/work/DB_Bonds_App/db-bonds-data.csv');

/* Book_users (book_id, user_id) */


/* Users (user_id, email, password) */


/* Security (security_id, isin, cusip, bond_currency, type, bond_maturity_date, bond_holder, status) */
INSERT INTO Security
(isin, cusip, bond_currency, type, bond_maturity_date, bond_holder, status)
SELECT isin, cusip, bond_currency, type, bond_maturity_date, bond_holder, status
FROM CSVREAD('C:/work/DB_Bonds_App/db-bonds-data.csv');

/* Trade (trade_id, book_id, security_id, counter_party_id, trade_type, trade_settlement_date, trade_currency, trade_status, trade_date, unit_price, quantity, coupon_percent, face_value_mn) */
INSERT INTO Trade
(trade_type, trade_settlement_date, trade_currency, trade_status, trade_date, unit_price, quantity, coupon_percent, face_value_mn)
SELECT trade_type, trade_settlement_date, trade_currency, trade_status, trade_date, unit_price, quantity, coupon_percent, face_value_mn
FROM CSVREAD('C:/work/DB_Bonds_App/db-bonds-data.csv');

/* Counter_party (counter_party_id, issuer_name) */
INSERT INTO Counter_party
(issuer_name)
SELECT issuer_name
FROM CSVREAD('C:/work/DB_Bonds_App/db-bonds-data.csv');

