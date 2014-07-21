/**
 * 
 */
package pl.wasat.smarthma.model;

import java.io.Serializable;
import java.util.HashMap;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

/**
 * @author Daniel Zinkiewicz Wasat Sp. z o.o 18-07-2014
 * 
 */
public class FedeoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3736600846301730973L;
	private static final String FEDEO_BASE_URL = "http://geo.spacebel.be/opensearch/request/?";
	private HashMap<String, String> params;
	private String url;
	private String httpAccept;
	private String type;
	private String startRecord;
	private String maximumRecords;
	private String startDate;
	private String endDate;
	private String parentIdentifier;
	private String bbox;
	private String recordSchema;
	private String query;

	/**
	 * 
	 */
	public FedeoRequest() {
		this.params = new HashMap<String, String>();
		this.httpAccept = "application/atom%2Bxml";
	}

	public void setDefaultParams() {
		this.httpAccept = "application/atom%2Bxml";
		this.startRecord = "1";
		this.maximumRecords = "20";
		this.startDate = "2013-05-23T09:00:00Z";
		this.endDate = "2014-05-23T00:00:00Z";
		this.bbox = "20,50,21,51";
		this.recordSchema = "om";
		this.params.put("httpAccept", httpAccept);
		this.params.put("startRecord", startRecord);
		this.params.put("maximumRecords", maximumRecords);
		this.params.put("startDate", startDate);
		this.params.put("endDate", endDate);
		this.params.put("bbox", bbox);
		this.params.put("recordSchema", recordSchema);

	}

	/**
	 * @return
	 */
	public String getUrl() {
		if (url == null) {
			url = FEDEO_BASE_URL;
			for (HashMap.Entry<String, String> entry : params.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				url = url + key + "=" + value + "&";
			}
			url = url.substring(0, url.length() - 1);
		}

		Log.i("URL", url);
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the params
	 */
	public HashMap<String, String> getParams() {
		return params;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(HashMap<String, String> params) {
		this.params = params;
	}

	/**
	 * @return the httpAccept
	 */
	public String getHttpAccept() {
		return httpAccept;
	}

	/**
	 * @param httpAccept
	 *            the httpAccept to set
	 */
	public void setHttpAccept(String httpAccept) {
		this.httpAccept = httpAccept;
		this.params.put("httpAccept", httpAccept);
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
		this.params.put("type", type);
	}

	/**
	 * @return the startRecord
	 */
	public String getStartRecord() {
		return startRecord;
	}

	/**
	 * @param startRecord
	 *            the startRecord to set
	 */
	public void setStartRecord(String startRecord) {
		this.startRecord = startRecord;
		this.params.put("startRecord", startRecord);
	}

	/**
	 * @return the maximumRecords
	 */
	public String getMaximumRecords() {
		return maximumRecords;
	}

	/**
	 * @param maximumRecords
	 *            the maximumRecords to set
	 */
	public void setMaximumRecords(String maximumRecords) {
		this.maximumRecords = maximumRecords;
		this.params.put("maximumRecords", maximumRecords);
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
		this.params.put("startDate", startDate);
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
		this.params.put("endDate", endDate);
	}

	/**
	 * @return the parentIdentifier
	 */
	public String getParentIdentifier() {
		return parentIdentifier;
	}

	/**
	 * @param parentIdentifier
	 *            the parentIdentifier to set
	 */
	public void setParentIdentifier(String parentIdentifier) {

		String urn = parentIdentifier.substring(0, 4);
		String baseParentIdentifier = parentIdentifier;
		if (urn.equalsIgnoreCase("urn:")) {
			baseParentIdentifier = getParetnId(parentIdentifier);
		}
		this.parentIdentifier = baseParentIdentifier;
		this.params.put("parentIdentifier", baseParentIdentifier);
	}

	/**
	 * @return the box
	 */
	public String getBbox() {
		return bbox;
	}

	/**
	 * @param bbox
	 *            the box to set
	 */
	public void setBbox(String bbox) {
		this.bbox = bbox;
		this.params.put("bbox", bbox);
	}

	/**
	 * @param swLon
	 * @param swLat
	 * @param neLon
	 * @param neLat
	 */
	public void setBbox(Float swLon, Float swLat, Float neLon, Float neLat) {
		String bbox = swLon + "," + swLat + "," + neLon + "," + neLat;
		setBbox(bbox);
	}

	/**
	 * @param southwest
	 * @param northeast
	 */
	public void setBbox(LatLng southwest, LatLng northeast) {
		setBbox((float) southwest.longitude, (float) southwest.latitude,
				(float) northeast.longitude, (float) northeast.latitude);
	}

	/**
	 * @param bbox
	 */
	public void setBbox(LatLngBounds bbox) {
		setBbox(bbox.southwest, bbox.northeast);
	}

	/**
	 * @return the recordSchema
	 */
	public String getRecordSchema() {
		return recordSchema;
	}

	/**
	 * @param recordSchema
	 *            the recordSchema to set
	 */
	public void setRecordSchema(String recordSchema) {
		this.recordSchema = recordSchema;
		this.params.put("recordSchema", recordSchema);
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}

	/**
	 * @param query
	 *            the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
		this.params.put("query", query);
	}

	/**
	 * @param urn
	 * @return
	 */
	private String getParetnId(String urn) {
		String[] idArr = urn.split("urn:ogc:def:");
		return idArr[idArr.length - 1];
	}

}
