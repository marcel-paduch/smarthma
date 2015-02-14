package pl.wasat.smarthma.model.feed;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import pl.wasat.smarthma.model.om.Name;
import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;
//import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;


public class Author implements Serializable {

    private static final long serialVersionUID = 1L;
    private Name name;
    private String nameStr;
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Author withName(Name name) {
        this.name = name;
        return this;
    }

    public String getNameStr() {
        return nameStr;
    }

    public void setNameStr(String nameStr) {
        this.nameStr = nameStr;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
