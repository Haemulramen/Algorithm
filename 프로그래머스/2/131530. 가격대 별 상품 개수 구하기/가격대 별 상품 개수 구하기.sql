select
    floor(price / 10000) * 10000 as price_group,
    count(*) as products
from
    product as p
group by
    price_group
order by
    price_group