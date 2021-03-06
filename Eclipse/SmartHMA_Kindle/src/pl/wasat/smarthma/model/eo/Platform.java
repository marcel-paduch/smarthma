package pl.wasat.smarthma.model.eo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class Platform implements Serializable {

	private static final long serialVersionUID = 1L;

	private String __prefix;
	private ShortName shortName;
	private SerialIdentifier serialIdentifier;
	private final Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public String get__prefix() {
		return __prefix;
	}

	public void set__prefix(String __prefix) {
		this.__prefix = __prefix;
	}

	public Platform with__prefix(String __prefix) {
		this.__prefix = __prefix;
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

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
