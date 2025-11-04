select
    f.category,
    p.price as max_price,
    f.product_name
from
    food_product as f
join
    (
        select category, max(price) as price
        from food_product
        where category in ('과자', '국', '김치', '식용유')
        group by category
    ) as p on f.category=p.category and f.price=p.price
order by
    max_price desc