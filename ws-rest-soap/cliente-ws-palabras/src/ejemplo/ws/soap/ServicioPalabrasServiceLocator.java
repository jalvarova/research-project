/**
 * ServicioPalabrasServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ejemplo.ws.soap;

public class ServicioPalabrasServiceLocator extends org.apache.axis.client.Service implements ejemplo.ws.soap.ServicioPalabrasService {

    public ServicioPalabrasServiceLocator() {
    }


    public ServicioPalabrasServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioPalabrasServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioPalabras
    private java.lang.String ServicioPalabras_address = "http://localhost:8079/ejemplo-ws-soap/services/ServicioPalabras";

    public java.lang.String getServicioPalabrasAddress() {
        return ServicioPalabras_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioPalabrasWSDDServiceName = "ServicioPalabras";

    public java.lang.String getServicioPalabrasWSDDServiceName() {
        return ServicioPalabrasWSDDServiceName;
    }

    public void setServicioPalabrasWSDDServiceName(java.lang.String name) {
        ServicioPalabrasWSDDServiceName = name;
    }

    public ejemplo.ws.soap.ServicioPalabras getServicioPalabras() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioPalabras_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioPalabras(endpoint);
    }

    public ejemplo.ws.soap.ServicioPalabras getServicioPalabras(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            ejemplo.ws.soap.ServicioPalabrasSoapBindingStub _stub = new ejemplo.ws.soap.ServicioPalabrasSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioPalabrasWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioPalabrasEndpointAddress(java.lang.String address) {
        ServicioPalabras_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (ejemplo.ws.soap.ServicioPalabras.class.isAssignableFrom(serviceEndpointInterface)) {
                ejemplo.ws.soap.ServicioPalabrasSoapBindingStub _stub = new ejemplo.ws.soap.ServicioPalabrasSoapBindingStub(new java.net.URL(ServicioPalabras_address), this);
                _stub.setPortName(getServicioPalabrasWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicioPalabras".equals(inputPortName)) {
            return getServicioPalabras();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://soap.ws.ejemplo", "ServicioPalabrasService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://soap.ws.ejemplo", "ServicioPalabras"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioPalabras".equals(portName)) {
            setServicioPalabrasEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
