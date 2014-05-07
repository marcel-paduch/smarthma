package pl.wasat.smarthma.model;

import java.util.Comparator;

import android.os.Parcel;
import android.os.Parcelable;

public class Collection implements Parcelable, Comparator<Object> {

	public static Creator<Collection> CREATOR = new Creator<Collection>() {
		@Override
		public Collection createFromParcel(Parcel source) {
			return new Collection(source);
		}

		@Override
		public Collection[] newArray(int size) {
			return new Collection[size];
		}
	};

	private int id;
	private String name;

	public Collection() {
	}

	public Collection(Parcel source) {
		this.id = source.readInt();
		this.name = source.readString();
	}

	@Override
	public int compare(Object collection1, Object collection2) {
		Collection coll1 = (Collection) collection1;
		Collection coll2 = (Collection) collection2;
		return coll1.name.compareToIgnoreCase(coll2.name);
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(id);
		dest.writeString(name);
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}