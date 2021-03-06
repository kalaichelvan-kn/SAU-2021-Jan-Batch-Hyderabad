-- View to find all the sales done in the past 7 days
CREATE VIEW LAST_WEEK_SALES AS SELECT * FROM SALE WHERE DOP BETWEEN date_sub(current_date(),interval 7 DAY) and current_date();

-- Write a query to retrieve the most sold product per day in a specific location (take any location) in last week.
SELECT RESF.DOP, RESF.TOT_UNITS, RESF.PROD_CODE, P.PROD_NAME FROM
(SELECT  DOP, PROD_CODE, SALE_ID, sum(NOU) as TOT_UNITS
		FROM( SELECT S.DOP,S.SALE_ID,SP.PROD_CODE,SP.NOU FROM LAST_WEEK_SALES S, SALE_PRODUCT SP WHERE S.SALE_ID=SP.SALE_ID AND LOC_CODE="L001") AS RES1
		GROUP BY DOP, PROD_CODE ORDER BY DOP) AS RESF
INNER JOIN
	(SELECT RES2.DOP AS DOP12, MAX(TOT_UNITS) AS TOT_UNITS12 FROM 
		(SELECT  DOP, PROD_CODE, SALE_ID, sum(NOU) as TOT_UNITS
		FROM( SELECT S.DOP,S.SALE_ID,SP.PROD_CODE,SP.NOU FROM LAST_WEEK_SALES S, SALE_PRODUCT SP WHERE S.SALE_ID=SP.SALE_ID AND LOC_CODE="L001") AS RES1
		GROUP BY DOP, PROD_CODE ORDER BY DOP) AS RES2 
	GROUP BY RES2.DOP) AS RES3
ON RES3.DOP12=RESF.DOP AND RES3.TOT_UNITS12=RESF.TOT_UNITS
,
PRODUCT P
WHERE P.PROD_CODE=RESF.PROD_CODE;

-- or call procedure with location code

call MaxProductPerDayLastWeek('L001');

-- Write a query to list all the sales persons details along with the count of products sold by them (if any) till current date.
SELECT SE.*, IFNULL(PRODUCTS_SOLD, 0) AS NO_OF_PRODUCTS_SOLD, IFNULL(NO_OF_UNITS_SOLD, 0) AS NO_OF_UNITS_SOLD 
FROM SALES_EXE SE
LEFT JOIN
(	SELECT SE_ID, COUNT(DISTINCT PROD_CODE) PRODUCTS_SOLD, SUM(NOU) AS NO_OF_UNITS_SOLD 
	FROM SALE S, SALE_PRODUCT SP 
    WHERE S.SALE_ID=SP.SALE_ID GROUP BY SE_ID ) AS SUB
ON SE.SE_ID=SUB.SE_ID;