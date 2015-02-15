package pl.wasat.smarthma.model.om;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class MultiCurve implements Serializable {

    private static final long serialVersionUID = 1L;

    private String _prefix;
    private List<CurveMember> curveMember = new ArrayList<>();
    private String _gml_id;


    public String get_prefix() {
        return _prefix;
    }

    public void set_prefix(String _prefix) {
        this._prefix = _prefix;
    }

    public MultiCurve with_prefix(String _prefix) {
        this._prefix = _prefix;
        return this;
    }

    public List<CurveMember> getCurveMember() {
        return curveMember;
    }

    public void setCurveMember(List<CurveMember> curveMember) {
        this.curveMember = curveMember;
    }

    public MultiCurve withCurveMember(List<CurveMember> curveMember) {
        this.curveMember = curveMember;
        return this;
    }

    public String get_gml_id() {
        return _gml_id;
    }

    public void set_gml_id(String _gml_id) {
        this._gml_id = _gml_id;
    }

    public MultiCurve with_gml_id(String _gml_id) {
        this._gml_id = _gml_id;
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
