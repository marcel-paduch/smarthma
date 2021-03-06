package pl.wasat.smarthma.model.iso;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    private pl.wasat.smarthma.model.iso.CITelephone CITelephone;
    private String Prefix;


    /**
     * @return The CITelephone
     */
    public pl.wasat.smarthma.model.iso.CITelephone getCITelephone() {
        return CITelephone;
    }

    /**
     * @param CITelephone The CI_Telephone
     */
    public void setCITelephone(
            pl.wasat.smarthma.model.iso.CITelephone CITelephone) {
        this.CITelephone = CITelephone;
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
        return new HashCodeBuilder().append(CITelephone).append(Prefix)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Phone)) {
            return false;
        }
        Phone rhs = ((Phone) other);
        return new EqualsBuilder().append(CITelephone, rhs.CITelephone)
                .append(Prefix, rhs.Prefix)

                .isEquals();
    }

}
