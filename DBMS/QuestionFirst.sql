USE Library_Database;
/*to Display all columns of member table*/
SELECT 
    *
FROM
    members;
SELECT 
    member_id, member_nm, category
FROM
    members;
    -- Query to find the member id,member name,category of table members
SELECT 
    member_id, member_nm, category
FROM
    members
WHERE
    category = 'F';
    -- Query to find the member id,member name,category of table members whose category = "f"
SELECT DISTINCT
    (category)
FROM
    members;
    -- Query to find distinct category of table members
SELECT 
    member_nm, category
FROM
    members
ORDER BY member_nm DESC ;
-- Query to find the title name,publisher name, subject id of table
SELECT 
    title_nm, publisher_id, s.subject_nm
FROM
    titles t,
    subjects s
WHERE
    t.subject_id = s.subject_id;
    -- Query to find the count of members of category
SELECT 
    category, COUNT(*)
FROM
    members
GROUP BY category;
-- Query to find name of members to which sumitra belongs
SELECT 
    m1.member_nm
FROM
    members AS m1
        JOIN
    members AS m2 ON m1.category = m2.category
WHERE
    m2.member_nm = 'sumitra';
    -- Query to find the status of return book and if returned  then place blank
SELECT 
    issue_Dt,
    member_Id,
    e.accession_No,
    IF(status = 0, return_Dt, ' ') as Book_Returned
FROM
    Books e,
    Book_Return f
WHERE
    e.accession_No = f.accession_No;
   /*Modify the SELECT command written for Question 9 to display results in 
   ascending order of issue date and within issue date in ascending order of members name.*/

SELECT 
    f.issue_Dt,
    f.member_Id,
    f.accession_No,
    IF(e.status = 0, return_Dt, ' ') as Book_Returned
from
    Books e,
    Book_Return f,
    Members m
WHERE
    ((e.accession_No = f.accession_No) && (f.member_Id = m.member_Id))
ORDER BY issue_dt asc ,member_Nm asc;
