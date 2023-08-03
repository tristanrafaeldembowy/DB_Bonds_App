DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Book_users;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Trade;
DROP TABLE IF EXISTS Counter_party;
DROP TABLE IF EXISTS Security;

CREATE TABLE Book (
    book_id INT NOT NULL AUTO_INCREMENT,
    book_name VARCHAR(70) NOT NULL,
    PRIMARY KEY (book_id)
);
CREATE TABLE Book_users (
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (book_id, user_id),
    FOREIGN KEY (book_id) REFERENCES Book (book_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);
CREATE TABLE Users (
    user_id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(40) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    PRIMARY KEY (user_id)
);
CREATE TABLE Trade (
    trade_id INT NOT NULL AUTO_INCREMENT,
    book_id INT NOT NULL,
    security_id INT NOT NULL,
    counter_party_id INT NOT NULL,
    trade_type VARCHAR(20) NOT NULL,
    trade_settlement_date DATE NOT NULL,
    trade_currency VARCHAR(20) NOT NULL,
    status VARCHAR(20) NOT NULL,
    trade_date DATE NOT NULL,
    unit_price DECIMAL(10,2) NOT NULL,
    quantity INT NOT NULL,
    coupon_percent DECIMAL(10,2) NOT NULL,
    face_value_mn INT NOT NULL,
    PRIMARY KEY (trade_id),
    FOREIGN KEY (book_id) REFERENCES Book (book_id),
    FOREIGN KEY (security_id) REFERENCES Security (security_id),
    FOREIGN KEY (counter_party_id) REFERENCES Counter_party (counter_party_id)
);
CREATE TABLE Counter_party (
    counter_party_id INT NOT NULL AUTO_INCREMENT,
    issuer_name VARCHAR(70) NOT NULL,
    PRIMARY KEY (counter_party_id)
);
CREATE TABLE Security (
    security_id INT NOT NULL AUTO_INCREMENT,
    isin VARCHAR(50) NOT NULL UNIQUE,
    bond_currency VARCHAR(10) NOT NULL,
    type VARCHAR(50) NOT NULL,
    bond_maturity_date DATE NOT NULL,
    bond_holder VARCHAR(70) NOT NULL,
    PRIMARY KEY (security_id)
);