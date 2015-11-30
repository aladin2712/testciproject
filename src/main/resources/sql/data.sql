-- Create bank account

insert into payment_instrument (status, creation_date_time, account_holder) values (0, {ts '2014-12-15 9:41:11.564'}, 'John Doe');
set @payment_instrument_id = identity();

insert into bank_account (id, bank_name, iban, bic) values (@payment_instrument_id, 'Test Bank', 'DE12500105170648489890', 'INGDDEFFXXX');

insert into transaction (payment_instrument_id, `date`, subject, amount) values (@payment_instrument_id, {ts '2015-01-31 12:00:00.000'}, 'Salary', 5000);
insert into transaction (payment_instrument_id, `date`, subject, amount) values (@payment_instrument_id, {ts '2015-01-31 12:15:00.000'}, 'Rent', -1000);

-- Create Credit Card

insert into payment_instrument (status, creation_date_time, account_holder) values (0, {ts '2014-11-11 11:11:11.111'}, 'Jane Doe');
set @payment_instrument_id = identity();

insert into credit_card (id, scheme, pan, expiry_month, expiry_year) values (@payment_instrument_id, 0, '4444333322221111', 11, 2031);

insert into transaction (payment_instrument_id, `date`, subject, amount) values (@payment_instrument_id, {ts '2014-11-28 19:37:11.458'}, 'Gas Station', -90);
