package ejemplo.ws.soap;

public class ServicioPalabrasProxy implements ejemplo.ws.soap.ServicioPalabras {
  private String _endpoint = null;
  private ejemplo.ws.soap.ServicioPalabras servicioPalabras = null;
  
  public ServicioPalabrasProxy() {
    _initServicioPalabrasProxy();
  }
  
  public ServicioPalabrasProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioPalabrasProxy();
  }
  
  private void _initServicioPalabrasProxy() {
    try {
      servicioPalabras = (new ejemplo.ws.soap.ServicioPalabrasServiceLocator()).getServicioPalabras();
      if (servicioPalabras != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioPalabras)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioPalabras)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioPalabras != null)
      ((javax.xml.rpc.Stub)servicioPalabras)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public ejemplo.ws.soap.ServicioPalabras getServicioPalabras() {
    if (servicioPalabras == null)
      _initServicioPalabrasProxy();
    return servicioPalabras;
  }
  
  public java.lang.String generaCodigo(java.lang.String nombre, java.lang.String apellido, java.lang.String codigo, java.lang.String ano, java.lang.String edad, java.lang.String curso) throws java.rmi.RemoteException{
    if (servicioPalabras == null)
      _initServicioPalabrasProxy();
    return servicioPalabras.generaCodigo(nombre, apellido, codigo, ano, edad, curso);
  }
  
  public java.lang.String reportePalabra(java.lang.String texto) throws java.rmi.RemoteException{
    if (servicioPalabras == null)
      _initServicioPalabrasProxy();
    return servicioPalabras.reportePalabra(texto);
  }
  
  
}