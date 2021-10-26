/**
 * ServicioPalabras.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ejemplo.ws.soap;

public interface ServicioPalabras extends java.rmi.Remote {
    public java.lang.String generaCodigo(java.lang.String nombre, java.lang.String apellido, java.lang.String codigo, java.lang.String año, java.lang.String edad, java.lang.String curso) throws java.rmi.RemoteException;
    public java.lang.String reportePalabra(java.lang.String texto) throws java.rmi.RemoteException;
}
