/* Book (book_id, book_name */
INSERT INTO Book
(book_name)
SELECT DISTINCT book_name
FROM CSVREAD('C:/work/DB_Bonds_App/db-bonds-data.csv');
----
----/* Book_users (book_id, user_id) */
----
----
----/* Users (user_id, email, password) */
----
----
/* Security (security_id, isin, cusip, issuer_name, coupon_percent, bond_currency, type, face_value_mn, bond_maturity_date, bond_holder, status) */
INSERT INTO Security
(isin, cusip, issuer_name, coupon_percent, bond_currency, type, face_value_mn, bond_maturity_date, bond_holder, status)
SELECT isin, cusip, issuer_name, coupon_percent, bond_currency, type, face_value_mn, bond_maturity_date, bond_holder, status
FROM CSVREAD('C:/work/DB_Bonds_App/db-bonds-data.csv');

--/* Trade (trade_id, book_id, security_id, counter_party_id, trade_type, trade_settlement_date, trade_currency, trade_status, trade_date, unit_price, quantity, coupon_percent, face_value_mn) */
----INSERT INTO Trade
----(trade_type, trade_settlement_date, trade_currency, trade_status, trade_date, unit_price, quantity, coupon_percent, face_value_mn)
----SELECT trade_type, trade_settlement_date, trade_currency, trade_status, trade_date, unit_price, quantity, coupon_percent, face_value_mn
----FROM CSVREAD('C:/work/DB_Bonds_App/db-bonds-data.csv');
--
/* Counter_party (counter_party_id, issuer_name) */
INSERT INTO Counter_party
(issuer_name)
SELECT DISTINCT issuer_name
FROM CSVREAD('C:/work/DB_Bonds_App/db-bonds-data.csv');

