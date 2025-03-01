-- 코드를 입력하세요
SELECT
    a_in.animal_id,
    a_in.animal_type,
    a_in.name
FROM 
    animal_ins a_in
JOIN 
    animal_outs a_out
    ON a_in.animal_id = a_out.animal_id
WHERE
    a_in.sex_upon_intake LIKE 'Intact%' 
    AND (
        a_out.sex_upon_outcome LIKE 'Neutered%' 
        OR a_out.sex_upon_outcome LIKE 'Spayed%'
    )
ORDER BY
    a_in.animal_id;