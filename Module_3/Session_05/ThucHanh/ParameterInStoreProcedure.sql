/*
Tham số loại IN
*/
DELIMITER //

CREATE PROCEDURE getCusById(IN cusNum INT(11))

BEGIN

  SELECT * FROM customers WHERE customerNumber = cusNum;

END //

DELIMITER ;

call getCusByID(175);

/*
Tham số loại OUT
*/
DELIMITER //

CREATE PROCEDURE GetCustomersCountByCity(IN  in_city VARCHAR(50),OUT total INT)

BEGIN

    SELECT COUNT(customerNumber)

    INTO total

    FROM customers

    WHERE city = in_city;

END//

DELIMITER ;

/*
goi Procedure
*/
call GetCustomersCountByCity('Lyon',@total);
select @total;

/*
Tham so loai INOUT
*/

delimiter $$
create procedure SetCounter(inout counter int, in inc int)
begin
set counter = counter + inc;
end $$
delimiter ;

set @counter = 1;
call SetCounter(@counter,1);
call SetCounter(@counter,1);
call SetCounter(@counter,5);
select @counter;

