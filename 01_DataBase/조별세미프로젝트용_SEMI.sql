SELECT
        B.BOARD_NO,
        M.MEM_ID,
        B.BOARD_TITLE,
        B.BOARD_CONTENT,
        S.STORE_NAME,
        B.CREATE_DATE
        FROM BOARD B
        JOIN MEMBER M ON B.EMP_NO = M.EMP_NO
        JOIN STORE S ON M.STORE_ID = S.STORE_ID
        ORDER BY
        CASE
        WHEN M.MEM_ID = 'admin' THEN 0
        ELSE 1
        END,
        B.BOARD_NO ASC;
        
        
        
        SELECT
        B.BOARD_NO,
        M.MEM_ID,
        B.BOARD_TITLE,
        B.BOARD_CONTENT,
        S.STORE_NAME,
        B.CREATE_DATE
        FROM BOARD B
        JOIN MEMBER M ON B.EMP_NO = M.EMP_NO
        JOIN STORE S ON M.STORE_ID = S.STORE_ID
        WHERE M.MEM_ID = 'admin'
        ORDER BY B.BOARD_NO ASC;
        
        
        SELECT
        B.BOARD_NO,
        M.MEM_ID,
        M.POSITION,
        B.BOARD_TITLE,
        B.BOARD_CONTENT,
        S.STORE_NAME,
        B.CREATE_DATE,
        B.BOARD_TYPE
        FROM BOARD B
        JOIN MEMBER M ON B.EMP_NO = M.EMP_NO
        JOIN STORE S ON M.STORE_ID = S.STORE_ID
        ORDER BY
        CASE
        WHEN M.MEM_ID = 'admin' THEN 0
        ELSE 1
        END,
        B.BOARD_NO ASC;
    
   