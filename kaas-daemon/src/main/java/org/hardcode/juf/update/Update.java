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
 * Class Update.
 * 
 * @version $Revision$ $Date$
 */
public class Update implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _componentName
     */
    private java.lang.String _componentName;

    /**
     * Field _version
     */
    private Long _version;

    /**
     * keeps track of state for field: _version
     */
    private boolean _has_version;

    /**
     * Field _installer
     */
    private org.hardcode.juf.update.Installer _installer;

    /**
     * Field _featureList
     */
    private java.util.Vector _featureList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Update() {
        super();
        _featureList = new Vector();
    } //-- org.hardcode.juf.update.Update()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addFeature
     * 
     * @param vFeature
     */
    public void addFeature(org.hardcode.juf.update.Feature vFeature)
        throws java.lang.IndexOutOfBoundsException
    {
        _featureList.addElement(vFeature);
    } //-- void addFeature(org.hardcode.juf.update.Feature) 

    /**
     * Method addFeature
     * 
     * @param index
     * @param vFeature
     */
    public void addFeature(int index, org.hardcode.juf.update.Feature vFeature)
        throws java.lang.IndexOutOfBoundsException
    {
        _featureList.insertElementAt(vFeature, index);
    } //-- void addFeature(int, org.hardcode.juf.update.Feature) 

    /**
     * Method deleteVersion
     */
    public void deleteVersion()
    {
        this._has_version= false;
    } //-- void deleteVersion() 

    /**
     * Method enumerateFeature
     */
    public java.util.Enumeration enumerateFeature()
    {
        return _featureList.elements();
    } //-- java.util.Enumeration enumerateFeature() 

    /**
     * Returns the value of field 'componentName'.
     * 
     * @return the value of field 'componentName'.
     */
    public java.lang.String getComponentName()
    {
        return this._componentName;
    } //-- java.lang.String getComponentName() 

    /**
     * Method getFeature
     * 
     * @param index
     */
    public org.hardcode.juf.update.Feature getFeature(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _featureList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (org.hardcode.juf.update.Feature) _featureList.elementAt(index);
    } //-- org.hardcode.juf.update.Feature getFeature(int) 

    /**
     * Method getFeature
     */
    public org.hardcode.juf.update.Feature[] getFeature()
    {
        int size = _featureList.size();
        org.hardcode.juf.update.Feature[] mArray = new org.hardcode.juf.update.Feature[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (org.hardcode.juf.update.Feature) _featureList.elementAt(index);
        }
        return mArray;
    } //-- org.hardcode.juf.update.Feature[] getFeature() 

    /**
     * Method getFeatureCount
     */
    public int getFeatureCount()
    {
        return _featureList.size();
    } //-- int getFeatureCount() 

    /**
     * Returns the value of field 'installer'.
     * 
     * @return the value of field 'installer'.
     */
    public org.hardcode.juf.update.Installer getInstaller()
    {
        return this._installer;
    } //-- org.hardcode.juf.update.Installer getInstaller() 

    /**
     * Returns the value of field 'version'.
     * 
     * @return the value of field 'version'.
     */
    public Long getVersion()
    {
        return this._version;
    } //-- int getVersion() 

    /**
     * Method hasVersion
     */
    public boolean hasVersion()
    {
        return this._has_version;
    } //-- boolean hasVersion() 

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
     * Method removeAllFeature
     */
    public void removeAllFeature()
    {
        _featureList.removeAllElements();
    } //-- void removeAllFeature() 

    /**
     * Method removeFeature
     * 
     * @param index
     */
    public org.hardcode.juf.update.Feature removeFeature(int index)
    {
        java.lang.Object obj = _featureList.elementAt(index);
        _featureList.removeElementAt(index);
        return (org.hardcode.juf.update.Feature) obj;
    } //-- org.hardcode.juf.update.Feature removeFeature(int) 

    /**
     * Sets the value of field 'componentName'.
     * 
     * @param componentName the value of field 'componentName'.
     */
    public void setComponentName(java.lang.String componentName)
    {
        this._componentName = componentName;
    } //-- void setComponentName(java.lang.String) 

    /**
     * Method setFeature
     * 
     * @param index
     * @param vFeature
     */
    public void setFeature(int index, org.hardcode.juf.update.Feature vFeature)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _featureList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _featureList.setElementAt(vFeature, index);
    } //-- void setFeature(int, org.hardcode.juf.update.Feature) 

    /**
     * Method setFeature
     * 
     * @param featureArray
     */
    public void setFeature(org.hardcode.juf.update.Feature[] featureArray)
    {
        //-- copy array
        _featureList.removeAllElements();
        for (int i = 0; i < featureArray.length; i++) {
            _featureList.addElement(featureArray[i]);
        }
    } //-- void setFeature(org.hardcode.juf.update.Feature) 

    /**
     * Sets the value of field 'installer'.
     * 
     * @param installer the value of field 'installer'.
     */
    public void setInstaller(org.hardcode.juf.update.Installer installer)
    {
        this._installer = installer;
    } //-- void setInstaller(org.hardcode.juf.update.Installer) 

    /**
     * Sets the value of field 'version'.
     * 
     * @param version the value of field 'version'.
     */
    public void setVersion(Long version)
    {
        this._version = version;
        this._has_version = true;
    } //-- void setVersion(int) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static java.lang.Object unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (org.hardcode.juf.update.Update) Unmarshaller.unmarshal(org.hardcode.juf.update.Update.class, reader);
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
