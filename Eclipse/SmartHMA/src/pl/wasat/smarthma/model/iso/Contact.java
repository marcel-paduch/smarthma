package pl.wasat.smarthma.model.iso;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    private CIResponsibleParty CIResponsibleParty;
    private String Prefix;


    /**
     * @return The CIResponsibleParty
     */
    public pl.wasat.smarthma.model.iso.CIResponsibleParty getCIResponsibleParty() {
        return CIResponsibleParty;
    }

    /**
     * @param CIResponsibleParty The CI_ResponsibleParty
     */
    public void setCIResponsibleParty(
            pl.wasat.smarthma.model.iso.CIResponsibleParty CIResponsibleParty) {
        this.CIResponsibleParty = CIResponsibleParty;
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

    @Override
    public String toString() {
        ToStringStyle style = new SmartHMAStringStyle();
        ToStringBuilder.setDefaultStyle(style);
        return ToStringBuilder.reflectionToString(this, style);
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(CIResponsibleParty).append(Prefix)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Contact)) {
            return false;
        }
        Contact rhs = ((Contact) other);
        return new EqualsBuilder()
                .append(CIResponsibleParty, rhs.CIResponsibleParty)
                .append(Prefix, rhs.Prefix)

                .isEquals();
    }

}
