package pl.wasat.smarthma.model.iso;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class DQDataQuality implements Serializable {

    private static final long serialVersionUID = 1L;

    private Scope scope;
    private Report report;
    private Lineage lineage;
    private String Prefix;


    /**
     * @return The scope
     */
    public Scope getScope() {
        return scope;
    }

    /**
     * @param scope The scope
     */
    public void setScope(Scope scope) {
        this.scope = scope;
    }

    /**
     * @return The report
     */
    public Report getReport() {
        return report;
    }

    /**
     * @param report The report
     */
    public void setReport(Report report) {
        this.report = report;
    }

    /**
     * @return The lineage
     */
    public Lineage getLineage() {
        return lineage;
    }

    /**
     * @param lineage The lineage
     */
    public void setLineage(Lineage lineage) {
        this.lineage = lineage;
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
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object other) {
        return EqualsBuilder.reflectionEquals(this, other);
    }

}
