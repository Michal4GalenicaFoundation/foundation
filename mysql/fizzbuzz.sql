SET @row_num = 0;

select GROUP_CONCAT(fb order by id SEPARATOR ', ') 
from
(
	select 
		case 
			when id % (5 * 3) = 0 then "fizzbuzz"	
			when id % 5  = 0 then "buzz"
			when id % 3  = 0 then "fizz"
			else id 	  
		end as fb, 
		id, 
		'const' as c
		from (
			SELECT (@row_num := @row_num + 1) as id from 
				( VALUES      
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused'),
					ROW ('Unused')
				) AS rowz 
			) as ids 
) as fbs group by c

