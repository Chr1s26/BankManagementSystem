create table customers 
(id SERIAL PRIMARY KEY, 
 first_name VARCHAR(200) NOT NULL,
 last_name VARCHAR(200) NOT NULL,
 email VARCHAR(100) UNIQUE NOT NULL,
 phone_number VARCHAR(100) UNIQUE NOT NULL,
 address TEXT,
 date_of_birth DATE,
 created_at TIMESTAMP DEFAULT NOW(),
 updated_at TIMESTAMP DEFAULT NOW(),
 created_by int references employees(id) on delete cascade,
 updated_by int references employees(id) on delete cascade
)

create table employees(
id SERIAL PRIMARY KEY,
first_name VARCHAR(200) NOT NULL,
last_name VARCHAR(200) NOT NULL,
email VARCHAR(100) UNIQUE NOT NULL,
phone_number VARCHAR(100) UNIQUE NOT NULL,
employee_position VARCHAR(100) NOT NULL,
salary float,
branch_id int references branches(id)
)

create table branches(
id SERIAL PRIMARY KEY,
name VARCHAR(100) UNIQUE NOT NULL,
address TEXT,
phone_number VARCHAR(100) UNIQUE NOT NULL
)

create table loan(
id SERIAL PRIMARY KEY,
loan_type int NOT NULL,
loan_amount float NOT NULL,
interest_rate float NOT NULL,
loan_start_date DATE,
loan_end_date DATE,
customer_id int references customers(id) on delete cascade
)

create table accounts(
id SERIAL PRIMARY KEY,
account_number VARCHAR(100) UNIQUE NOT NULL,
account_type int NOT NULL,
balance float NOT NULL,
created_at DATE NOT NULL,
branch_id int references branches(id) on delete cascade,
customer_id int references customers(id) on delete cascade
)

create table cards(
id SERIAL PRIMARY KEY,
card_number VARCHAR(100) NOT NULL,
card_type int NOT NULL,
expire_date DATE NOT NULL,
security_code int NOT NULL,
customer_id int references customers(id) on delete cascade,
account_id int references accounts(id) on delete cascade
)

create table account_transaction(
id serial primary key,
transaction_type int NOT NULL,
amount float NOT NULL,
transaction_date TIMESTAMP NOT NULL,
description VARCHAR(200),
transaction_id Int;
transaction_id int references transactions(id) on delete cascade
) 

create table transactions(id serial primary key,
account_id int,
foreign key (account_id) references accounts(id),
createdAt timestamp default now(),
createdBy int references employees(id) on delete cascade,
UpdatedAt timestamp default now(),
UpdatedBy int references employees(id) on delete cascade);

create table card_transaction(
id serial primary key,
amount float NOT NULL,
transaction_date TIMESTAMP NOT NULL,
description VARCHAR(200),
account_id int references accounts(id) on delete cascade,
card_id int references cards(id) on delete cascade
)

create or replace function update_timestamp()
returns trigger as $$
BEGIN
 NEW.updated_at = CURRENT_TIMESTAMP;
 RETURN NEW;
END;
$$ LANGUAGE plpgsql;


create trigger updated_customer_timestamp
before update on customers
for each row
execute function update_timestamp();