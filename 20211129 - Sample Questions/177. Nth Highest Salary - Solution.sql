CREATE FUNCTION getNthHighestSalary(@N INT) RETURNS INT AS
BEGIN
    RETURN (
        /* Write your T-SQL query statement below. */
        select coalesce(
            (select distinct salary
             from Employee
             order by salary desc
             OFFSET @N-1 ROWS
            FETCH NEXT 1 ROWS ONLY
            )
            , null)
    );
END