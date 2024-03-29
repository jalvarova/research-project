create or replace
PACKAGE PKG_CLIENTE AS 
TYPE C_CURSOR IS REF CURSOR;

 PROCEDURE SP_LISTAR(
    P_CURSOR OUT C_CURSOR
 );
 
 PROCEDURE SP_LISTAR_X_RZ(
    P_CURSOR OUT C_CURSOR,
    P_RAZON_SOCIAL IN CLIENTE.RAZON_SOCIAL%TYPE
  );
  
  PROCEDURE SP_INSERTAR(
    P_CLIENTE_ID    OUT CLIENTE.CLIENTE_ID%TYPE,
    P_RAZON_SOCIAL  IN  CLIENTE.RAZON_SOCIAL%TYPE,
    P_RUC           IN  CLIENTE.RUC%TYPE,
    P_DIRECCION     IN  CLIENTE.DIRECCION%TYPE
  );

 PROCEDURE SP_ACTUALIZAR(
    P_CLIENTE_ID    IN CLIENTE.CLIENTE_ID%TYPE,
    P_RAZON_SOCIAL  IN  CLIENTE.RAZON_SOCIAL%TYPE,
    P_RUC           IN  CLIENTE.RUC%TYPE,
    P_DIRECCION     IN  CLIENTE.DIRECCION%TYPE
  );
  
  PROCEDURE SP_ELIMINAR(
    P_CLIENTE_ID    IN CLIENTE.CLIENTE_ID%TYPE
  );
  
   PROCEDURE SP_VALIDAR_RUC(
      P_RET           OUT INT,
      P_CLIENTE_ID    IN CLIENTE.CLIENTE_ID%TYPE,
      P_RUC           IN  CLIENTE.RUC%TYPE
  );

END PKG_CLIENTE;