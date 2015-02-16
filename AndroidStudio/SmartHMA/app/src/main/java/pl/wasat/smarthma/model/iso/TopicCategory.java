package pl.wasat.smarthma.model.iso;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class TopicCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    private pl.wasat.smarthma.model.iso.MDTopicCategoryCode MDTopicCategoryCode;
    private String Prefix;


    /**
     * @return The MDTopicCategoryCode
     */
    public pl.wasat.smarthma.model.iso.MDTopicCategoryCode getMDTopicCategoryCode() {
        return MDTopicCategoryCode;
    }

    /**
     * @param MDTopicCategoryCode The MD_TopicCategoryCode
     */
    public void setMDTopicCategoryCode(
            pl.wasat.smarthma.model.iso.MDTopicCategoryCode MDTopicCategoryCode) {
        this.MDTopicCategoryCode = MDTopicCategoryCode;
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
