package pl.wasat.smarthma.model.om;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class AlongTrackIncidenceAngle implements Serializable {

    private static final long serialVersionUID = 1L;

    private String _prefix;
    private String uom;
    private String _text;


    public String get_prefix() {
        return _prefix;
    }

    public void set_prefix(String _prefix) {
        this._prefix = _prefix;
    }

    public AlongTrackIncidenceAngle with_prefix(String _prefix) {
        this._prefix = _prefix;
        return this;
    }

    public String getuom() {
        return uom;
    }

    public void setUom(String uom) {
        this.uom = uom;
    }

    public AlongTrackIncidenceAngle withuom(String uom) {
        this.uom = uom;
        return this;
    }

    public String get_text() {
        return _text;
    }

    public void set_text(String _text) {
        this._text = _text;
    }

    public AlongTrackIncidenceAngle with_text(String _text) {
        this._text = _text;
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
