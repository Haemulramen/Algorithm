with max_fish_length as (
    select
        fish_type,
        max(length) as length
    from
        fish_info
    group by
        fish_type
)

select
    fi.id,
    fni.fish_name,
    fi.length
from
    fish_info as fi
join 
    max_fish_length as mfl on fi.fish_type = mfl.fish_type
join
    fish_name_info as fni on fi.fish_type = fni.fish_type
where
    fi.length = mfl.length