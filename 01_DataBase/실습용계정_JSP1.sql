    SELECT *
        FROM(SELECT ROWNUM RNUM, A.*
            FROM(SELECT BOARD_NO,
				      		 CATEGORY_NAME,
				      		 BOARD_TITLE,
				      		 USER_ID,
				      		 COUNT,
				      		 TO_CHAR(CREATE_DATE, 'YYYY.MM.DD') AS "CREATE_DATE"
				      FROM BOARD B
				      JOIN CATEGORY USING(CATEGORY_NO)
				      JOIN MEMBER M ON(BOARD_WRITER = USER_NO)
				      WHERE B.STATUS = 'Y'
				      AND BOARD_TYPE = 1
				      ORDER BY BOARD_NO DESC) A)
                      WHERE RNUM BETWEEN 5 AND 10;