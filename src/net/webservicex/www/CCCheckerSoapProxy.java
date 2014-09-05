package net.webservicex.www;

public class CCCheckerSoapProxy implements net.webservicex.www.CCCheckerSoap {
  private String _endpoint = null;
  private net.webservicex.www.CCCheckerSoap cCCheckerSoap = null;
  
  public CCCheckerSoapProxy() {
    _initCCCheckerSoapProxy();
  }
  
  public CCCheckerSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initCCCheckerSoapProxy();
  }
  
  private void _initCCCheckerSoapProxy() {
    try {
      cCCheckerSoap = (new net.webservicex.www.CCCheckerLocator()).getCCCheckerSoap();
      if (cCCheckerSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cCCheckerSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cCCheckerSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cCCheckerSoap != null)
      ((javax.xml.rpc.Stub)cCCheckerSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public net.webservicex.www.CCCheckerSoap getCCCheckerSoap() {
    if (cCCheckerSoap == null)
      _initCCCheckerSoapProxy();
    return cCCheckerSoap;
  }
  
  public java.lang.String validateCardNumber(java.lang.String cardType, java.lang.String cardNumber) throws java.rmi.RemoteException{
    if (cCCheckerSoap == null)
      _initCCCheckerSoapProxy();
    return cCCheckerSoap.validateCardNumber(cardType, cardNumber);
  }
  
  
}