package pl.wasat.smarthma.model.iso;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class ResourceConstraint implements Serializable {

    private static final long serialVersionUID = 1L;

    private MDConstraints MDConstraints;
    private String Prefix;
    private MDLegalConstraints MDLegalConstraints;


    /**
     * @return The MDConstraints
     */
    public MDConstraints getMDConstraints() {
        return MDConstraints;
    }

    /**
     * @param MDConstraints The MD_Constraints
     */
    public void setMDConstraints(MDConstraints MDConstraints) {
        this.MDConstraints = MDConstraints;
    }

    /**
     * @return The Prefix
     */
    public String getPrefix() {
        return Prefix;
    }

    /**
     * @param Prefix The _prefix
     */
    public void setPrefix(String Prefix) {
        this.Prefix = Prefix;
    }

    /**
     * @return The MDLegalConstraints
     */
    public MDLegalConstraints getMDLegalConstraints() {
        return MDLegalConstraints;
    }

    /**
     * @param MDLegalConstraints The MD_LegalConstraints
     */
    public void setMDLegalConstraints(MDLegalConstraints MDLegalConstraints) {
        this.MDLegalConstraints = MDLegalConstraints;
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
