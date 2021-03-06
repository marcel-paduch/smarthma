package pl.wasat.smarthma.model.iso;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class Pass implements Serializable {

    private static final long serialVersionUID = 1L;

    private pl.wasat.smarthma.model.iso.Boolean Boolean;
    private String Prefix;


    /**
     * @return The Boolean
     */
    public pl.wasat.smarthma.model.iso.Boolean getBoolean() {
        return Boolean;
    }

    /**
     * @param Boolean The Boolean
     */
    public void setBoolean(pl.wasat.smarthma.model.iso.Boolean Boolean) {
        this.Boolean = Boolean;
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
        return new HashCodeBuilder().append(Boolean).append(Prefix)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Pass)) {
            return false;
        }
        Pass rhs = ((Pass) other);
        return new EqualsBuilder().append(Boolean, rhs.Boolean)
                .append(Prefix, rhs.Prefix)

                .isEquals();
    }

}
