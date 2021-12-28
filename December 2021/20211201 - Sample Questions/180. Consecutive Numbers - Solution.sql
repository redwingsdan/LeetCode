/* Write your T-SQL query statement below */
select distinct num as ConsecutiveNums
from (
select Logs.*,
    row_number() over (order by id) - row_number() over (partition by num order by id) as consecutive_count
    from Logs
) grouped_logs
GROUP BY consecutive_count, num
HAVING COUNT(*) >= 3
