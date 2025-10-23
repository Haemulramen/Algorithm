select
    car_id,
    case 
        WHEN SUM(
            -- 1. 대여중이면 1, 아니면 0을 반환
            CASE 
                WHEN '2022-10-16' BETWEEN start_date AND end_date THEN 1
                ELSE 0
            END
        ) > 0 THEN '대여중'
        else '대여 가능'
    end as availability
from
    car_rental_company_rental_history
group by
    car_id
order by
    car_id desc