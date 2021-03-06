package pl.wasat.smarthma.model.iso;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class IndividualName implements Serializable {

    private static final long serialVersionUID = 1L;

    private CharacterString CharacterString;
    private String Prefix;


    /**
     * @return The CharacterString
     */
    public CharacterString getCharacterString() {
        return CharacterString;
    }

    /**
     * @param CharacterString The CharacterString
     */
    public void setCharacterString(CharacterString CharacterString) {
        this.CharacterString = CharacterString;
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
        return new HashCodeBuilder().append(CharacterString).append(Prefix)
                .toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof IndividualName)) {
            return false;
        }
        IndividualName rhs = ((IndividualName) other);
        return new EqualsBuilder().append(CharacterString, rhs.CharacterString)
                .append(Prefix, rhs.Prefix)

                .isEquals();
    }

}
