CREATE OR REPLACE FUNCTION verifyLogin(
        p_user_id IN USER1.user_id%TYPE,
        p_password IN USER1.password%TYPE)
RETURN USER1.USER_ID%TYPE IS
    p_status USER1.USER_ID%TYPE;
BEGIN
    IF EXIST (SELECT 1 FROM USER1 WHERE USER1.USER_ID = p_user_id AND USER1.PASSWORD = p_password) THEN
        p_status := 0;
    ELSIF EXIST (SELECT 1 FROM ADMIN1 WHERE ADMIN1.ADMIN_ID=p_user_id AND ADMIN1.PASSWORD=p_password) THEN
        p_status := 1;   
    ELSE
        p_status := 2;
    END IF;
    COMMIT;
    RETURN p_status;
END;