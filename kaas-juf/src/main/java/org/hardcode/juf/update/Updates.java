/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.5.3</a>, using an XML
 * Schema.
 * $Id$
 */

package org.hardcode.juf.update;

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
 * Class Updates.
 * 
 * @version $Revision$ $Date$
 */
public class Updates implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _updateList
     */
    private java.util.Vector _updateList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Updates() {
        super();
        _updateList = new Vector();
    } //-- org.hardcode.juf.update.Updates()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addUpdate
     * 
     * @param vUpdate
     */
    public void addUpdate(org.hardcode.juf.update.Update vUpdate)
        throws java.lang.IndexOutOfBoundsException
    {
        _updateList.addElement(vUpdate);
    } //-- void addUpdate(org.hardcode.juf.update.Update) 

    /**
     * Method addUpdate
     * 
     * @param index
     * @param vUpdate
     */
    public void addUpdate(int index, org.hardcode.juf.update.Update vUpdate)
        throws java.lang.IndexOutOfBoundsException
    {
        _updateList.insertElementAt(vUpdate, index);
    } //-- void addUpdate(int, org.hardcode.juf.update.Update) 

    /**
     * Method enumerateUpdate
     */
    public java.util.Enumeration enumerateUpdate()
    {
        return _updateList.elements();
    } //-- java.util.Enumeration enumerateUpdate() 

    /**
     * Method getUpdate
     * 
     * @param index
     */
    public org.hardcode.juf.update.Update getUpdate(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _updateList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (org.hardcode.juf.update.Update) _updateList.elementAt(index);
    } //-- org.hardcode.juf.update.Update getUpdate(int) 

    /**
     * Method getUpdate
     */
    public org.hardcode.juf.update.Update[] getUpdate()
    {
        int size = _updateList.size();
        
        org.hardcode.juf.update.Update[] mArray = new org.hardcode.juf.update.Update[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (org.hardcode.juf.update.Update) _updateList.elementAt(index);
        }
        return mArray;
    } //-- org.hardcode.juf.update.Update[] getUpdate() 

    /**
     * Method getUpdateCount
     */
    public int getUpdateCount()
    {
        return _updateList.size();
    } //-- int getUpdateCount() 

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
     * Method removeAllUpdate
     */
    public void removeAllUpdate()
    {
        _updateList.removeAllElements();
    } //-- void removeAllUpdate() 

    /**
     * Method removeUpdate
     * 
     * @param index
     */
    public org.hardcode.juf.update.Update removeUpdate(int index)
    {
        java.lang.Object obj = _updateList.elementAt(index);
        _updateList.removeElementAt(index);
        return (org.hardcode.juf.update.Update) obj;
    } //-- org.hardcode.juf.update.Update removeUpdate(int) 

    /**
     * Method setUpdate
     * 
     * @param index
     * @param vUpdate
     */
    public void setUpdate(int index, org.hardcode.juf.update.Update vUpdate)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _updateList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _updateList.setElementAt(vUpdate, index);
    } //-- void setUpdate(int, org.hardcode.juf.update.Update) 

    /**
     * Method setUpdate
     * 
     * @param updateArray
     */
    public void setUpdate(org.hardcode.juf.update.Update[] updateArray)
    {
        //-- copy array
        _updateList.removeAllElements();
        for (int i = 0; i < updateArray.length; i++) {
            _updateList.addElement(updateArray[i]);
        }
    } //-- void setUpdate(org.hardcode.juf.update.Update) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static java.lang.Object unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.hardcode.juf.update.Updates) Unmarshaller.unmarshal(org.hardcode.juf.update.Updates.class, reader);
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
