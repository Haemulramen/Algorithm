SELECT
    C.CAR_ID,
    C.CAR_TYPE,
    -- 3. 30일 대여 요금 계산 (일일 요금 * 30일 * 할인율 적용), 소수점 버림
    TRUNCATE(C.DAILY_FEE * 30 * (100 - P.DISCOUNT_RATE) / 100, 0) AS FEE
FROM
    -- 1. 자동차 정보 테이블과 할인 정책 테이블을 JOIN
    CAR_RENTAL_COMPANY_CAR AS C
JOIN
    CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS P
    ON C.CAR_TYPE = P.CAR_TYPE
WHERE
    -- 1-1. 자동차 종류는 '세단' 또는 'SUV'
    C.CAR_TYPE IN ('세단', 'SUV')
    -- 1-2. 할인 정책은 '30일 이상'
    AND P.DURATION_TYPE = '30일 이상'
    -- 2. 2022년 11월에 대여 기록이 있는 차는 제외 (서브쿼리 사용)
    AND C.CAR_ID NOT IN (
        SELECT CAR_ID
        FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
        WHERE END_DATE >= '2022-11-01' AND START_DATE <= '2022-11-30'
    )
-- 4. 계산된 요금이 50만원 이상, 200만원 미만인 경우만 필터링
HAVING
    FEE >= 500000 AND FEE < 2000000
-- 5. 문제의 요구사항에 맞게 정렬
ORDER BY
    FEE DESC,
    C.CAR_TYPE ASC,
    C.CAR_ID DESC;