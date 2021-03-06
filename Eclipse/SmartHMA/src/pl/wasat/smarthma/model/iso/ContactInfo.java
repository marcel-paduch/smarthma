package pl.wasat.smarthma.model.iso;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class ContactInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    private CIContact CIContact;
    private String Prefix;


    /**
     * @return The CIContact
     */
    public pl.wasat.smarthma.model.iso.CIContact getCIContact() {
        return CIContact;
    }

    /**
     * @param CIContact The CI_Contact
     */
    public void setCIContact(pl.wasat.smarthma.model.iso.CIContact CIContact) {
        this.CIContact = CIContact;
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
        return new HashCodeBuilder().append(CIContact).append(Prefix)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ContactInfo)) {
            return false;
        }
        ContactInfo rhs = ((ContactInfo) other);
        return new EqualsBuilder().append(CIContact, rhs.CIContact)
                .append(Prefix, rhs.Prefix)

                .isEquals();
    }

}
