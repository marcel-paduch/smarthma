
package pl.wasat.smarthma.model.osdd;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.List;


public class Parameter {

<<<<<<< HEAD
<<<<<<< HEAD
    private List<pl.wasat.smarthma.model.osdd.Option> Option = new ArrayList<>();
=======
    private List<pl.wasat.smarthma.model.osdd.Option> Option = new ArrayList<pl.wasat.smarthma.model.osdd.Option>();
>>>>>>> 3cdf4b5c6a0ee0167bee856d291a553acdc6d2f4
=======
    private List<pl.wasat.smarthma.model.osdd.Option> Option = new ArrayList<pl.wasat.smarthma.model.osdd.Option>();
>>>>>>> 3cdf4b5c6a0ee0167bee856d291a553acdc6d2f4
    private String Name;
    private String Value;
    private String Prefix;


    /**
     * @return The Option
     */
    public List<pl.wasat.smarthma.model.osdd.Option> getOption() {
        return Option;
    }

    /**
     * @param Option The Option
     */
    public void setOption(List<pl.wasat.smarthma.model.osdd.Option> Option) {
        this.Option = Option;
    }

    /**
     * @return The Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name The _name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return The Value
     */
    public String getValue() {
        return Value;
    }

    /**
     * @param Value The _value
     */
    public void setValue(String Value) {
        this.Value = Value;
    }

    /**
     * @return The Prefix
     */
    public String getPrefix() {
        return Prefix;
    }

    /**
     * @param Prefix The __prefix
     */
    public void setPrefix(String Prefix) {
        this.Prefix = Prefix;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Option).append(Name).append(Value).append(Prefix).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
<<<<<<< HEAD
<<<<<<< HEAD
        if (!(other instanceof Parameter)) {
=======
        if ((other instanceof Parameter) == false) {
>>>>>>> 3cdf4b5c6a0ee0167bee856d291a553acdc6d2f4
=======
        if ((other instanceof Parameter) == false) {
>>>>>>> 3cdf4b5c6a0ee0167bee856d291a553acdc6d2f4
            return false;
        }
        Parameter rhs = ((Parameter) other);
        return new EqualsBuilder().append(Option, rhs.Option).append(Name, rhs.Name).append(Value, rhs.Value).append(Prefix, rhs.Prefix).isEquals();
    }

}