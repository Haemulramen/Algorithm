select
    sum(g.score) as score,
    e.emp_no,
    e.emp_name,
    e.position,
    e.email
from
    hr_employees as e
join
    hr_grade as g on g.emp_no = e.emp_no
group by
    e.emp_no
having
    sum(score) = (
        select sum(score) as sc
        from hr_grade
        group by emp_no
        order by sc desc
        limit 1
    )