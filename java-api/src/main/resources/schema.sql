DROP TABLE IF EXISTS Book;
DROP TABLE IF EXISTS Book_users;
DROP TABLE IF EXISTS Users;
DROP TABLE IF EXISTS Trade;
DROP TABLE IF EXISTS Counter_party;
DROP TABLE IF EXISTS Security;


CREATE TABLE IF NOT EXISTS Book (
    book_id INT NOT NULL AUTO_INCREMENT,
    book_name VARCHAR(70) NOT NULL,
    PRIMARY KEY (book_id)
);
CREATE TABLE IF NOT EXISTS  Book_users (
    book_id INT NOT NULL,
    user_id INT NOT NULL,
    PRIMARY KEY (book_id, user_id),
    FOREIGN KEY (book_id) REFERENCES Book (book_id),
    FOREIGN KEY (user_id) REFERENCES Users (user_id)
);
CREATE TABLE IF NOT EXISTS  Users (
    user_id INT NOT NULL AUTO_INCREMENT,
    email VARCHAR(40) NOT NULL UNIQUE,
    password VARCHAR(30) NOT NULL,
    PRIMARY KEY (user_id)
);
CREATE TABLE IF NOT EXISTS  Trade (
    trade_id INT NOT NULL AUTO_INCREMENT,
    book_id INT NOT NULL,
    security_id INT NOT NULL,
    counter_party_id INT NOT NULL,
    trade_type ENUM('BUY', 'SELL') NOT NULL,
    trade_settlement_date DATE NOT NULL,
    trade_currency ENUM('USD', 'GBP') NOT NULL,
    trade_status ENUM('open', 'closed') NOT NULL,
    trade_date DATE NOT NULL,
    unit_price FLOAT NOT NULL,
    quantity INT NOT NULL,
    coupon_percent FLOAT NOT NULL,
    face_value_mn INT NOT NULL,
    PRIMARY KEY (trade_id),
    FOREIGN KEY (book_id) REFERENCES Book (book_id),
    FOREIGN KEY (security_id) REFERENCES Security (security_id),
    FOREIGN KEY (counter_party_id) REFERENCES Counter_party (counter_party_id)
);
CREATE TABLE IF NOT EXISTS  Counter_party (
    counter_party_id INT NOT NULL AUTO_INCREMENT,
    issuer_name VARCHAR(70) NOT NULL,
    PRIMARY KEY (counter_party_id)
);
CREATE TABLE IF NOT EXISTS  Security (
    security_id INT NOT NULL AUTO_INCREMENT,
    isin VARCHAR(50),
    cusip VARCHAR(50),
    bond_currency ENUM('USD', 'GBP') NOT NULL,
    type ENUM('CORP', 'GOVN', 'SOVN') NOT NULL,
    bond_maturity_date DATE NOT NULL,
    bond_holder VARCHAR(70) NOT NULL,
    status ENUM('active', 'inactive') NOT NULL,
    PRIMARY KEY (security_id)
);