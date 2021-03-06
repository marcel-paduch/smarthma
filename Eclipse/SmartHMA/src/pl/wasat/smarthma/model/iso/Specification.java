package pl.wasat.smarthma.model.iso;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class Specification implements Serializable {

    private static final long serialVersionUID = 1L;

    private CICitation CICitation;
    private String Prefix;


    /**
     * @return The CICitation
     */
    public CICitation getCICitation() {
        return CICitation;
    }

    /**
     * @param CICitation The CI_Citation
     */
    public void setCICitation(CICitation CICitation) {
        this.CICitation = CICitation;
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
        return new HashCodeBuilder().append(CICitation).append(Prefix)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Specification)) {
            return false;
        }
        Specification rhs = ((Specification) other);
        return new EqualsBuilder().append(CICitation, rhs.CICitation)
                .append(Prefix, rhs.Prefix)

                .isEquals();
    }

}
