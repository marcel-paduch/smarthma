package pl.wasat.smarthma.model.om;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class Platform implements Serializable {

    private static final long serialVersionUID = 1L;

    private String _prefix;
    private ShortName shortName;
    private SerialIdentifier serialIdentifier;


    public String get_prefix() {
        return _prefix;
    }

    public void set_prefix(String _prefix) {
        this._prefix = _prefix;
    }

    public Platform with_prefix(String _prefix) {
        this._prefix = _prefix;
        return this;
    }

    public ShortName getShortName() {
        return shortName;
    }

    public void setShortName(ShortName shortName) {
        this.shortName = shortName;
    }

    public Platform withShortName(ShortName shortName) {
        this.shortName = shortName;
        return this;
    }

    public SerialIdentifier getSerialIdentifier() {
        return serialIdentifier;
    }

    public void setSerialIdentifier(SerialIdentifier serialIdentifier) {
        this.serialIdentifier = serialIdentifier;
    }

    public Platform withSerialIdentifier(SerialIdentifier serialIdentifier) {
        this.serialIdentifier = serialIdentifier;
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
