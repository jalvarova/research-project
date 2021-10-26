create or replace
PACKAGE BODY PKG_CLIENTE AS

  PROCEDURE SP_LISTAR(
    P_CURSOR OUT C_CURSOR
 ) AS
  BEGIN
      OPEN 
          P_CURSOR
      FOR
          SELECT 
              CLIENTE_ID,
              RAZON_SOCIAL,
              RUC,
              DIRECCION
          FROM
              CLIENTE
          WHERE 
              ESTADO='1';
  END SP_LISTAR;
PROCEDURE SP_BUSCAR_X_RUC(
    P_CURSOR OUT C_CURSOR,
    P_RUC IN CLIENTE.RUC%TYPE
  )AS
  BEGIN
   OPEN 
          P_CURSOR
      FOR
          SELECT 
              CLIENTE_ID,
              RAZON_SOCIAL,
              RUC,
              DIRECCION
          FROM
              CLIENTE
          WHERE
                    UPPER(RUC)  = UPPER(P_RUC)
              AND   ESTADO='1';
  END SP_BUSCAR_X_RUC;
  
  
  
   PROCEDURE SP_LISTAR_X_RZ(
    P_CURSOR OUT C_CURSOR,
    P_RAZON_SOCIAL IN CLIENTE.RAZON_SOCIAL%TYPE
  )AS
  BEGIN 
  
  OPEN 
          P_CURSOR
      FOR
          SELECT 
              CLIENTE_ID,
              RAZON_SOCIAL,
              RUC,
              DIRECCION
          FROM
              CLIENTE
          WHERE
                    UPPER(RAZON_SOCIAL)  LIKE '%'||UPPER(P_RAZON_SOCIAL)||'%'
              AND   ESTADO='1';
    NULL;
    
  END SP_LISTAR_X_RZ;

 PROCEDURE SP_INSERTAR(
    P_CLIENTE_ID    OUT CLIENTE.CLIENTE_ID%TYPE,
    P_RAZON_SOCIAL  IN  CLIENTE.RAZON_SOCIAL%TYPE,
    P_RUC           IN  CLIENTE.RUC%TYPE,
    P_DIRECCION     IN  CLIENTE.DIRECCION%TYPE
  )AS
  BEGIN
    SELECT
      SEQ_CLIENTE.NEXTVAL
    INTO
      P_CLIENTE_ID
    FROM
      DUAL;
    INSERT INTO CLIENTE
    (
      CLIENTE_ID,
      RAZON_SOCIAL,
      RUC,
      DIRECCION
    )
    VALUES
    (
      P_CLIENTE_ID,
      P_RAZON_SOCIAL,
      P_RUC,
      P_DIRECCION
    );
    
  END SP_INSERTAR;

PROCEDURE SP_ACTUALIZAR(
    P_CLIENTE_ID    IN CLIENTE.CLIENTE_ID%TYPE,
    P_RAZON_SOCIAL  IN  CLIENTE.RAZON_SOCIAL%TYPE,
    P_RUC           IN  CLIENTE.RUC%TYPE,
    P_DIRECCION     IN  CLIENTE.DIRECCION%TYPE
  )AS
  BEGIN
    UPDATE CLIENTE
      SET
        RAZON_SOCIAL    =   P_RAZON_SOCIAL,
        RUC             =   P_RUC,
        DIRECCION       =   P_DIRECCION
      WHERE
        CLIENTE_ID      =   P_CLIENTE_ID;
  END SP_ACTUALIZAR;
  
  PROCEDURE SP_ELIMINAR(
        P_CLIENTE_ID    IN CLIENTE.CLIENTE_ID%TYPE
  )AS
  BEGIN
    UPDATE CLIENTE
      SET
        ESTADO    =   '0'
      WHERE
        CLIENTE_ID      =   P_CLIENTE_ID;
  END SP_ELIMINAR;
  
  PROCEDURE SP_VALIDAR_RUC(
      P_RET           OUT INT,
      P_CLIENTE_ID    IN CLIENTE.CLIENTE_ID%TYPE,
      P_RUC           IN  CLIENTE.RUC%TYPE
  )AS
  BEGIN
    IF P_CLIENTE_ID>0 THEN
        SELECT 
            COUNT(*)
        INTO
            P_RET
        FROM 
            CLIENTE
        WHERE 
                RUC           =   P_RUC
            AND CLIENTE_ID    <>  P_CLIENTE_ID;
    ELSE
       SELECT 
              COUNT(*)
          INTO
              P_RET
          FROM 
              CLIENTE
          WHERE 
               RUC           =   P_RUC;
    END IF;
  END SP_VALIDAR_RUC;

END PKG_CLIENTE;