package pl.wasat.smarthma.model.iso;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    private pl.wasat.smarthma.model.iso.DQConformanceResult DQConformanceResult;
    private String Prefix;


    /**
     * @return The DQConformanceResult
     */
    public pl.wasat.smarthma.model.iso.DQConformanceResult getDQConformanceResult() {
        return DQConformanceResult;
    }

    /**
     * @param DQConformanceResult The DQ_ConformanceResult
     */
    public void setDQConformanceResult(
            pl.wasat.smarthma.model.iso.DQConformanceResult DQConformanceResult) {
        this.DQConformanceResult = DQConformanceResult;
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
        return new HashCodeBuilder().append(DQConformanceResult).append(Prefix)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Result)) {
            return false;
        }
        Result rhs = ((Result) other);
        return new EqualsBuilder()
                .append(DQConformanceResult, rhs.DQConformanceResult)
                .append(Prefix, rhs.Prefix)

                .isEquals();
    }

}
