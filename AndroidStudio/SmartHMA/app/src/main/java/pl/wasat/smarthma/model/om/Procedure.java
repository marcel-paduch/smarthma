package pl.wasat.smarthma.model.om;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class Procedure implements Serializable {

    private static final long serialVersionUID = 1L;

    private String _prefix;
    private EarthObservationEquipment earthObservationEquipment;
    private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String get_prefix() {
        return _prefix;
    }

    public void set_prefix(String _prefix) {
        this._prefix = _prefix;
    }

    public Procedure with_prefix(String _prefix) {
        this._prefix = _prefix;
        return this;
    }

    public EarthObservationEquipment getEarthObservationEquipment() {
        return earthObservationEquipment;
    }

    public void setEarthObservationEquipment(
            EarthObservationEquipment earthObservationEquipment) {
        this.earthObservationEquipment = earthObservationEquipment;
    }

    public Procedure withEarthObservationEquipment(
            EarthObservationEquipment earthObservationEquipment) {
        this.earthObservationEquipment = earthObservationEquipment;
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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}