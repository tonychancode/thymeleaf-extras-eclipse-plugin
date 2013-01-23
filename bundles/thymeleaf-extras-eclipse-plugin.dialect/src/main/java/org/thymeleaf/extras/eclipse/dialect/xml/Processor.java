//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.01.18 at 11:58:13 PM NZDT 
//


package org.thymeleaf.extras.eclipse.dialect.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 				Common data between the 2 Thymeleaf processor types: attribute processors
 * 				and element processors.
 * 			
 * 
 * <p>Java class for Processor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Processor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="documentation" type="{http://www.thymeleaf.org/extras/dialect}ProcessorDocumentation" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Processor", propOrder = {
    "documentation"
})
@XmlSeeAlso({
    AttributeProcessor.class,
    ElementProcessor.class
})
public abstract class Processor {

    protected ProcessorDocumentation documentation;
    @XmlAttribute(name = "name", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String name;

    /**
     * Gets the value of the documentation property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessorDocumentation }
     *     
     */
    public ProcessorDocumentation getDocumentation() {
        return documentation;
    }

    /**
     * Sets the value of the documentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessorDocumentation }
     *     
     */
    public void setDocumentation(ProcessorDocumentation value) {
        this.documentation = value;
    }

    public boolean isSetDocumentation() {
        return (this.documentation!= null);
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }
    
	@javax.xml.bind.annotation.XmlTransient
	protected Dialect dialect;

	/**
	 * Gets the dialect this processor belongs to.
	 * 
	 * @return Dialect this processor is for.
	 */
	public Dialect getDialect() {

		return dialect;
	}

	/**
	 * Set the dialect this processor belongs to.
	 * 
	 * @param dialect
	 */
	public void setDialect(Dialect dialect) {

		this.dialect = dialect;
	}
				
}