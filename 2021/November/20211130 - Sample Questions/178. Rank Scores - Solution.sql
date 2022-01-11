/* Write your T-SQL query statement below */

select ranked_scores.score, rank 
from Scores
join (
select score as score,
row_number() over(order by score desc) as rank
from (select distinct score from Scores) distinct_scores
) ranked_scores on ranked_scores.score = Scores.score
order by ranked_scores.score desc
