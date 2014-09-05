/**
 * CCCheckerSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package net.webservicex.www;

public interface CCCheckerSoap extends java.rmi.Remote {

    /**
     * Please enter card type as  VISA or MASTERCARD or DINERS or
     * AMEX
     */
    public java.lang.String validateCardNumber(java.lang.String cardType, java.lang.String cardNumber) throws java.rmi.RemoteException;
}
