package pl.wasat.smarthma.model.om;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class ProductInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    private String _prefix;
    private ReferenceSystemIdentifier referenceSystemIdentifier;
    private FileName fileName;
    private Size size;
    private Timeliness timeliness;


    public String get_prefix() {
        return _prefix;
    }

    public void set_prefix(String _prefix) {
        this._prefix = _prefix;
    }

    public ProductInformation with_prefix(String _prefix) {
        this._prefix = _prefix;
        return this;
    }

    public ReferenceSystemIdentifier getReferenceSystemIdentifier() {
        return referenceSystemIdentifier;
    }

    public void setReferenceSystemIdentifier(
            ReferenceSystemIdentifier referenceSystemIdentifier) {
        this.referenceSystemIdentifier = referenceSystemIdentifier;
    }

    public ProductInformation withReferenceSystemIdentifier(
            ReferenceSystemIdentifier referenceSystemIdentifier) {
        this.referenceSystemIdentifier = referenceSystemIdentifier;
        return this;
    }

    public FileName getFileName() {
        return fileName;
    }

    public void setFileName(FileName fileName) {
        this.fileName = fileName;
    }

    public ProductInformation withFileName(FileName fileName) {
        this.fileName = fileName;
        return this;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public ProductInformation withSize(Size size) {
        this.size = size;
        return this;
    }

    public Timeliness getTimeliness() {
        return timeliness;
    }

    public void setTimeliness(Timeliness timeliness) {
        this.timeliness = timeliness;
    }

    public ProductInformation withTimeliness(Timeliness timeliness) {
        this.timeliness = timeliness;
        return this;
    }

    @Override
    public String toString() {
        ToStringStyle style = new SmartHMAStringStyle();
        ToStringBuilder.setDefaultStyle(style);
        return ToStringBuilder.reflectionToString(this, style);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }


}
