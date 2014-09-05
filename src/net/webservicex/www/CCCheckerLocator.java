/**
 * CCCheckerLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.webservicex.www;

public class CCCheckerLocator extends org.apache.axis.client.Service implements net.webservicex.www.CCChecker {

    public CCCheckerLocator() {
    }


    public CCCheckerLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CCCheckerLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CCCheckerSoap
    private java.lang.String CCCheckerSoap_address = "http://www.webservicex.net/CreditCard.asmx";

    public java.lang.String getCCCheckerSoapAddress() {
        return CCCheckerSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CCCheckerSoapWSDDServiceName = "CCCheckerSoap";

    public java.lang.String getCCCheckerSoapWSDDServiceName() {
        return CCCheckerSoapWSDDServiceName;
    }

    public void setCCCheckerSoapWSDDServiceName(java.lang.String name) {
        CCCheckerSoapWSDDServiceName = name;
    }

    public net.webservicex.www.CCCheckerSoap getCCCheckerSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CCCheckerSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCCCheckerSoap(endpoint);
    }

    public net.webservicex.www.CCCheckerSoap getCCCheckerSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            net.webservicex.www.CCCheckerSoapStub _stub = new net.webservicex.www.CCCheckerSoapStub(portAddress, this);
            _stub.setPortName(getCCCheckerSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCCCheckerSoapEndpointAddress(java.lang.String address) {
        CCCheckerSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (net.webservicex.www.CCCheckerSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                net.webservicex.www.CCCheckerSoapStub _stub = new net.webservicex.www.CCCheckerSoapStub(new java.net.URL(CCCheckerSoap_address), this);
                _stub.setPortName(getCCCheckerSoapWSDDServiceName());
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
        if ("CCCheckerSoap".equals(inputPortName)) {
            return getCCCheckerSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.webservicex.net", "CCChecker");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.webservicex.net", "CCCheckerSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CCCheckerSoap".equals(portName)) {
            setCCCheckerSoapEndpointAddress(address);
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
