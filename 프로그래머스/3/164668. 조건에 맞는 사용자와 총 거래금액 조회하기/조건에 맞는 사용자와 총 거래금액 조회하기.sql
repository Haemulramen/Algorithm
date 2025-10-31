select
    u.user_id,
    u.nickname,
    b.total_sales
from
    used_goods_user as u
join
    (
        select writer_id, sum(price) as total_sales
        from used_goods_board 
        where status = 'DONE'
        group by writer_id
        having sum(price) >= 700000
    ) as b on u.user_id = b.writer_id
order by
    b.total_sales asc