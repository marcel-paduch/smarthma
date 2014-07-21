
package pl.wasat.smarthma.model.eo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;


public class MaximumIncidenceAngle {

    private String __prefix;
    private String _uom;
    private String __text;
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String get__prefix() {
        return __prefix;
    }

    public void set__prefix(String __prefix) {
        this.__prefix = __prefix;
    }

    public MaximumIncidenceAngle with__prefix(String __prefix) {
        this.__prefix = __prefix;
        return this;
    }

    public String get_uom() {
        return _uom;
    }

    public void set_uom(String _uom) {
        this._uom = _uom;
    }

    public MaximumIncidenceAngle with_uom(String _uom) {
        this._uom = _uom;
        return this;
    }

    public String get__text() {
        return __text;
    }

    public void set__text(String __text) {
        this.__text = __text;
    }

    public MaximumIncidenceAngle with__text(String __text) {
        this.__text = __text;
        return this;
    }

    @Override
    public String toString() {
            	 ToStringStyle style = new SmartHMAStringStyle(); ToStringBuilder.setDefaultStyle(style); return ToStringBuilder.reflectionToString(this);
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
