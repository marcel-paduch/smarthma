package pl.wasat.smarthma.model.eo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class EarthObservation implements Serializable {

	private static final long serialVersionUID = 1L;

	private String __prefix;
	private PhenomenonTime phenomenonTime;
	private ResultTime resultTime;
	private Procedure procedure;
	private ObservedProperty observedProperty;
	private FeatureOfInterest featureOfInterest;
	private Result result;
	private MetaDataProperty metaDataProperty;
	private String _xmlns_xsi;
	private String _xmlns_xlink;
	private String _xmlns_gml;
	private String _xmlns_eop;
	private String _xmlns_opt;
	private String _xmlns_atm;
	private String _xmlns_ows;
	private String _xmlns_swe;
	private String _xmlns_om;
	private String _gml_id;
	private String _xsi_schemaLocation;
	private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String get__prefix() {
		return __prefix;
	}

	public void set__prefix(String __prefix) {
		this.__prefix = __prefix;
	}

	public EarthObservation with__prefix(String __prefix) {
		this.__prefix = __prefix;
		return this;
	}

	public PhenomenonTime getPhenomenonTime() {
		return phenomenonTime;
	}

	public void setPhenomenonTime(PhenomenonTime phenomenonTime) {
		this.phenomenonTime = phenomenonTime;
	}

	public EarthObservation withPhenomenonTime(PhenomenonTime phenomenonTime) {
		this.phenomenonTime = phenomenonTime;
		return this;
	}

	public ResultTime getResultTime() {
		return resultTime;
	}

	public void setResultTime(ResultTime resultTime) {
		this.resultTime = resultTime;
	}

	public EarthObservation withResultTime(ResultTime resultTime) {
		this.resultTime = resultTime;
		return this;
	}

	public Procedure getProcedure() {
		return procedure;
	}

	public void setProcedure(Procedure procedure) {
		this.procedure = procedure;
	}

	public EarthObservation withProcedure(Procedure procedure) {
		this.procedure = procedure;
		return this;
	}

	public ObservedProperty getObservedProperty() {
		return observedProperty;
	}

	public void setObservedProperty(ObservedProperty observedProperty) {
		this.observedProperty = observedProperty;
	}

	public EarthObservation withObservedProperty(
			ObservedProperty observedProperty) {
		this.observedProperty = observedProperty;
		return this;
	}

	public FeatureOfInterest getFeatureOfInterest() {
		return featureOfInterest;
	}

	public void setFeatureOfInterest(FeatureOfInterest featureOfInterest) {
		this.featureOfInterest = featureOfInterest;
	}

	public EarthObservation withFeatureOfInterest(
			FeatureOfInterest featureOfInterest) {
		this.featureOfInterest = featureOfInterest;
		return this;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public EarthObservation withResult(Result result) {
		this.result = result;
		return this;
	}

	public MetaDataProperty getMetaDataProperty() {
		return metaDataProperty;
	}

	public void setMetaDataProperty(MetaDataProperty metaDataProperty) {
		this.metaDataProperty = metaDataProperty;
	}

	public EarthObservation withMetaDataProperty(
			MetaDataProperty metaDataProperty) {
		this.metaDataProperty = metaDataProperty;
		return this;
	}

	public String get_xmlns_xsi() {
		return _xmlns_xsi;
	}

	public void set_xmlns_xsi(String _xmlns_xsi) {
		this._xmlns_xsi = _xmlns_xsi;
	}

	public EarthObservation with_xmlns_xsi(String _xmlns_xsi) {
		this._xmlns_xsi = _xmlns_xsi;
		return this;
	}

	public String get_xmlns_xlink() {
		return _xmlns_xlink;
	}

	public void set_xmlns_xlink(String _xmlns_xlink) {
		this._xmlns_xlink = _xmlns_xlink;
	}

	public EarthObservation with_xmlns_xlink(String _xmlns_xlink) {
		this._xmlns_xlink = _xmlns_xlink;
		return this;
	}

	public String get_xmlns_gml() {
		return _xmlns_gml;
	}

	public void set_xmlns_gml(String _xmlns_gml) {
		this._xmlns_gml = _xmlns_gml;
	}

	public EarthObservation with_xmlns_gml(String _xmlns_gml) {
		this._xmlns_gml = _xmlns_gml;
		return this;
	}

	public String get_xmlns_eop() {
		return _xmlns_eop;
	}

	public void set_xmlns_eop(String _xmlns_eop) {
		this._xmlns_eop = _xmlns_eop;
	}

	public EarthObservation with_xmlns_eop(String _xmlns_eop) {
		this._xmlns_eop = _xmlns_eop;
		return this;
	}

	public String get_xmlns_opt() {
		return _xmlns_opt;
	}

	public void set_xmlns_opt(String _xmlns_opt) {
		this._xmlns_opt = _xmlns_opt;
	}

	public EarthObservation with_xmlns_opt(String _xmlns_opt) {
		this._xmlns_opt = _xmlns_opt;
		return this;
	}

	public String get_xmlns_atm() {
		return _xmlns_atm;
	}

	public void set_xmlns_atm(String _xmlns_atm) {
		this._xmlns_atm = _xmlns_atm;
	}

	public EarthObservation with_xmlns_atm(String _xmlns_atm) {
		this._xmlns_atm = _xmlns_atm;
		return this;
	}

	public String get_xmlns_ows() {
		return _xmlns_ows;
	}

	public void set_xmlns_ows(String _xmlns_ows) {
		this._xmlns_ows = _xmlns_ows;
	}

	public EarthObservation with_xmlns_ows(String _xmlns_ows) {
		this._xmlns_ows = _xmlns_ows;
		return this;
	}

	public String get_xmlns_swe() {
		return _xmlns_swe;
	}

	public void set_xmlns_swe(String _xmlns_swe) {
		this._xmlns_swe = _xmlns_swe;
	}

	public EarthObservation with_xmlns_swe(String _xmlns_swe) {
		this._xmlns_swe = _xmlns_swe;
		return this;
	}

	public String get_xmlns_om() {
		return _xmlns_om;
	}

	public void set_xmlns_om(String _xmlns_om) {
		this._xmlns_om = _xmlns_om;
	}

	public EarthObservation with_xmlns_om(String _xmlns_om) {
		this._xmlns_om = _xmlns_om;
		return this;
	}

	public String get_gml_id() {
		return _gml_id;
	}

	public void set_gml_id(String _gml_id) {
		this._gml_id = _gml_id;
	}

	public EarthObservation with_gml_id(String _gml_id) {
		this._gml_id = _gml_id;
		return this;
	}

	public String get_xsi_schemaLocation() {
		return _xsi_schemaLocation;
	}

	public void set_xsi_schemaLocation(String _xsi_schemaLocation) {
		this._xsi_schemaLocation = _xsi_schemaLocation;
	}

	public EarthObservation with_xsi_schemaLocation(String _xsi_schemaLocation) {
		this._xsi_schemaLocation = _xsi_schemaLocation;
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
