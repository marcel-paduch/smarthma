package pl.wasat.smarthma.model.om;

import com.google.android.gms.maps.model.LatLng;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import pl.wasat.smarthma.utils.text.SmartHMAStringStyle;

public class Pos implements Serializable {

    private static final long serialVersionUID = 1L;

    private String _prefix;
    private String _text;
    private transient LatLng latLng;


    public String get_prefix() {
        return _prefix;
    }

    public void set_prefix(String _prefix) {
        this._prefix = _prefix;
    }

    public Pos with_prefix(String _prefix) {
        this._prefix = _prefix;
        return this;
    }

    public String get_text() {
        return _text;
    }

    public void set_text(String _text) {
        _text = _text.replaceAll(",", " ");
        this._text = _text;
        toLatLng();
    }

    public Pos with_text(String _text) {
        _text = _text.replaceAll(",", " ");
        this._text = _text;
        return this;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
        this._text = latLng.latitude + " " + latLng.longitude;

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


    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeDouble(latLng.latitude);
        out.writeDouble(latLng.longitude);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        latLng = new LatLng(in.readDouble(), in.readDouble());
    }

    private void toLatLng() {
        latLng = new LatLng(Double.valueOf(_text.split(" ")[0]),
                Double.valueOf(_text.split(" ")[1]));
    }
}
