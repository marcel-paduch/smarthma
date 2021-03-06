package pl.wasat.smarthma.model.iso;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class DateType implements Serializable {

    private static final long serialVersionUID = 1L;

    private CIDateTypeCode CIDateTypeCode;
    private String Prefix;


    /**
     * @return The CIDateTypeCode
     */
    public CIDateTypeCode getCIDateTypeCode() {
        return CIDateTypeCode;
    }

    /**
     * @param CIDateTypeCode The CI_DateTypeCode
     */
    public void setCIDateTypeCode(CIDateTypeCode CIDateTypeCode) {
        this.CIDateTypeCode = CIDateTypeCode;
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
        return new HashCodeBuilder().append(CIDateTypeCode).append(Prefix)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof DateType)) {
            return false;
        }
        DateType rhs = ((DateType) other);
        return new EqualsBuilder().append(CIDateTypeCode, rhs.CIDateTypeCode)
                .append(Prefix, rhs.Prefix)

                .isEquals();
    }

}
