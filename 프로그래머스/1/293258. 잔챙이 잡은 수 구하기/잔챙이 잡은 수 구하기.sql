-- 코드를 작성해주세요
SELECT 
    COUNT(*) AS fish_count
FROM
    fish_info
WHERE
    length IS NULL;