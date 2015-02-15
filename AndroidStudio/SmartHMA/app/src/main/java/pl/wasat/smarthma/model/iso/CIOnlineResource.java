package pl.wasat.smarthma.model.iso;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class CIOnlineResource implements Serializable {

    private static final long serialVersionUID = 1L;

    private Linkage linkage;
    private String Prefix;


    /**
     * @return The linkage
     */
    public Linkage getLinkage() {
        return linkage;
    }

    /**
     * @param linkage The linkage
     */
    public void setLinkage(Linkage linkage) {
        this.linkage = linkage;
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
        return new HashCodeBuilder().append(linkage).append(Prefix)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof CIOnlineResource)) {
            return false;
        }
        CIOnlineResource rhs = ((CIOnlineResource) other);
        return new EqualsBuilder().append(linkage, rhs.linkage)
                .append(Prefix, rhs.Prefix)

                .isEquals();
    }

}
