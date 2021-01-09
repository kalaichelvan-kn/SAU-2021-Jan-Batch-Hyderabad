-- View to find all the sales done in the past 7 days
CREATE VIEW LAST_WEEK_SALES AS SELECT * FROM SALES WHERE DOP BETWEEN date_sub(current_date(),interval 7 DAY) and current_date();

-- Write a query to retrieve the most sold product per day in a specific location (take any location) in last week.
select P.PROD_CODE, P.PROD_NAME, T.DOP AS DATE_OF_SALE, max(TOT_UNITS) AS MAX_UNITS_SOLD_PERDAY from PRODUCT P
INNER JOIN
(SELECT sum(NOU) as TOT_UNITS, PROD_CODE,DOP 
	FROM LAST_WEEK_SALES S,CUSTOMER C 
	WHERE C.LOC_CODE="L001" 
	AND C.CUST_ID=S.CUST_ID 
    GROUP BY DOP,PROD_CODE) T
ON T.PROD_CODE=P.PROD_CODE GROUP BY T.DOP;

-- Write a query to list all the sales persons details along with the count of products sold by them (if any) till current date.
SELECT SE.*, IFNULL(T.PRODUCTS_SOLD, 0) AS NO_OF_PRODUCTS_SOLD, IFNULL(T.NO_OF_UNITS_SOLD, 0) AS NO_OF_UNITS_SOLD FROM SALES_EXE SE
LEFT JOIN
(SELECT SE_ID, COUNT(DISTINCT PROD_CODE) PRODUCTS_SOLD, SUM(NOU) AS NO_OF_UNITS_SOLD FROM SALES GROUP BY SE_ID) T
ON T.SE_ID=SE.SE_ID;