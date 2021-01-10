SELECT * FROM SALE;
SELECT * FROM SALES_EXE;
SELECT * FROM CUSTOMER;
SELECT * FROM PRODUCT;
SELECT * FROM SALES_EXE;

CREATE VIEW LAST_WEEK_SALES AS SELECT * FROM SALE WHERE DOP BETWEEN date_sub(current_date(),interval 7 DAY) and current_date();

SELECT * FROM SALE_PRODUCT;
SELECT * FROM SALE;

call MaxProductPerDayLastWeek('L001');
INSERT INTO SALE_PRODUCT VALUES('S004','P003',2);

SELECT SE.*, IFNULL(PRODUCTS_SOLD, 0) AS NO_OF_PRODUCTS_SOLD, IFNULL(NO_OF_UNITS_SOLD, 0) AS NO_OF_UNITS_SOLD 
FROM SALES_EXE SE
LEFT JOIN
(	SELECT SE_ID, COUNT(DISTINCT PROD_CODE) PRODUCTS_SOLD, SUM(NOU) AS NO_OF_UNITS_SOLD 
	FROM SALE S, SALE_PRODUCT SP 
    WHERE S.SALE_ID=SP.SALE_ID GROUP BY SE_ID ) AS SUB
ON SE.SE_ID=SUB.SE_ID;

