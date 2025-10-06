-- 코드를 입력하세요
SELECT
    b.title, 
    b.board_id, 
    r.reply_id, 
    r.writer_id, 
    r.contents, 
    DATE_FORMAT(r.created_date, '%Y-%m-%d') AS created_date
FROM used_goods_board AS b 
JOIN used_goods_reply AS r ON r.board_id = b.board_id 
WHERE DATE_FORMAT(b.created_date, '%Y-%m') = '2022-10'
ORDER BY DATE(r.created_date) ASC, b.title ASC