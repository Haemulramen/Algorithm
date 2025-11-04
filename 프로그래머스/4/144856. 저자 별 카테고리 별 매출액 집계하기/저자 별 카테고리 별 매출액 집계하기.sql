select
    a.author_id,
    a.author_name,
    b.category,
    sum(s.sales * b.price) as total_sales
from
    book_sales as s
join
    book as b on s.book_id=b.book_id
join
    author as a on b.author_id=a.author_id
where
    year(sales_date) = 2022
    and month(sales_date) = 1
group by
    a.author_id,
    a.author_name,
    b.category
order by
    a.author_id asc,
    b.category desc