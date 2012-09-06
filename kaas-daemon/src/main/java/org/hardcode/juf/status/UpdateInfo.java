/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.5.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hardcode.juf.status;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class UpdateInfo.
 * 
 * @version $Revision$ $Date$
 */
public class UpdateInfo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _urlPrefix
     */
    private java.lang.String _urlPrefix;

    /**
     * Field _statusList
     */
    private java.util.Vector _statusList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UpdateInfo() {
        super();
        _statusList = new Vector();
    } //-- org.hardcode.juf.status.UpdateInfo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addStatus
     * 
     * @param vStatus
     */
    public void addStatus(org.hardcode.juf.status.Status vStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        _statusList.addElement(vStatus);
    } //-- void addStatus(org.hardcode.juf.status.Status) 

    /**
     * Method addStatus
     * 
     * @param index
     * @param vStatus
     */
    public void addStatus(int index, org.hardcode.juf.status.Status vStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        _statusList.insertElementAt(vStatus, index);
    } //-- void addStatus(int, org.hardcode.juf.status.Status) 

    /**
     * Method enumerateStatus
     */
    public java.util.Enumeration enumerateStatus()
    {
        return _statusList.elements();
    } //-- java.util.Enumeration enumerateStatus() 

    /**
     * Method getStatus
     * 
     * @param index
     */
    public org.hardcode.juf.status.Status getStatus(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _statusList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (org.hardcode.juf.status.Status) _statusList.elementAt(index);
    } //-- org.hardcode.juf.status.Status getStatus(int) 

    /**
     * Method getStatus
     */
    public org.hardcode.juf.status.Status[] getStatus()
    {
        int size = _statusList.size();
        org.hardcode.juf.status.Status[] mArray = new org.hardcode.juf.status.Status[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (org.hardcode.juf.status.Status) _statusList.elementAt(index);
        }
        return mArray;
    } //-- org.hardcode.juf.status.Status[] getStatus() 

    /**
     * Method getStatusCount
     */
    public int getStatusCount()
    {
        return _statusList.size();
    } //-- int getStatusCount() 

    /**
     * Returns the value of field 'urlPrefix'.
     * 
     * @return the value of field 'urlPrefix'.
     */
    public java.lang.String getUrlPrefix()
    {
        return this._urlPrefix;
    } //-- java.lang.String getUrlPrefix() 

    /**
     * Method isValid
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     * 
     * @param out
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Method removeAllStatus
     */
    public void removeAllStatus()
    {
        _statusList.removeAllElements();
    } //-- void removeAllStatus() 

    /**
     * Method removeStatus
     * 
     * @param index
     */
    public org.hardcode.juf.status.Status removeStatus(int index)
    {
        java.lang.Object obj = _statusList.elementAt(index);
        _statusList.removeElementAt(index);
        return (org.hardcode.juf.status.Status) obj;
    } //-- org.hardcode.juf.status.Status removeStatus(int) 

    /**
     * Method setStatus
     * 
     * @param index
     * @param vStatus
     */
    public void setStatus(int index, org.hardcode.juf.status.Status vStatus)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _statusList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _statusList.setElementAt(vStatus, index);
    } //-- void setStatus(int, org.hardcode.juf.status.Status) 

    /**
     * Method setStatus
     * 
     * @param statusArray
     */
    public void setStatus(org.hardcode.juf.status.Status[] statusArray)
    {
        //-- copy array
        _statusList.removeAllElements();
        for (int i = 0; i < statusArray.length; i++) {
            _statusList.addElement(statusArray[i]);
        }
    } //-- void setStatus(org.hardcode.juf.status.Status) 

    /**
     * Sets the value of field 'urlPrefix'.
     * 
     * @param urlPrefix the value of field 'urlPrefix'.
     */
    public void setUrlPrefix(java.lang.String urlPrefix)
    {
        this._urlPrefix = urlPrefix;
    } //-- void setUrlPrefix(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static java.lang.Object unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.hardcode.juf.status.UpdateInfo) Unmarshaller.unmarshal(org.hardcode.juf.status.UpdateInfo.class, reader);
    } //-- java.lang.Object unmarshal(java.io.Reader) 

    /**
     * Method validate
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
