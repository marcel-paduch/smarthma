package pl.wasat.smarthma.helper;

public class Const {

    public static final String IMG_URL = "http://89.250.194.14/smarthma/img/";
    public static final String HTTP_SPACEBEL_BASE_URL = "http://geo.spacebel.be/opensearch/request/";
    private static final String HTTP_SMAAD_BASE_URL = "http://smaad.spacebel.be/opensearch/request/";
    private static final String HTTP_ESA_BASE_URL = "http://fedeo.esa.int/opensearch/request/";

    public static String HTTP_BASE_URL = HTTP_ESA_BASE_URL;

    public static final String OSDD_BASE_URL = "http://fedeo.esa.int:80/opensearch/description.xml?";

    public static final String URL_ESA_NEWS_1 = "http://www.esa.int/rssfeed/EOB";
    public static final String URL_ESA_NEWS_2 = "https://earth.esa.int/eodisp-portlets/eodisp-rss?tags=news";
    //public static final String URL_ESA_NEWS_2 = "http://www.esa.int/rssfeed/TopNews";

    public static final String KEY_DATE_PICKER_DT_VIEW_TAG = "pl.wasat.smarthma.KEY_DATE_PICKER_DT_VIEW_TAG";
    public static final String KEY_DATE_TIME_PICKER_CALENDAR = "pl.wasat.smarthma.KEY_DATE_TIME_PICKER_CALENDAR";
    public static final String KEY_MAP_SPINNER_INTENTFILTER_NOTIFICATION = "pl.wasat.smarthma.KEY_MAP_SPINNER_INTENTFILTER_NOTIFICATION";
    public static final String KEY_MAP_WMS_LOAD_STATE = "pl.wasat.smarthma.KEY_MAP_WMS_LOAD_STATE";
    public static final String KEY_INTENT_RETURN_STOP_SEARCH = "pl.wasat.smarthma.KEY_INTENT_RETURN_STOP_SEARCH";
    public static final String KEY_INTENT_QUERY = "pl.wasat.smarthma.KEY_INTENT_QUERY";
    public static final String KEY_INTENT_FEDEO_REQUEST_PARAMS = "pl.wasat.smarthma.KEY_INTENT_FEDEO_REQUEST_PARAMS";
    public static final String KEY_ACTION_SEARCH_MISSION_DATA = "pl.wasat.smarthma.KEY_ACTION_SEARCH_MISSION_DATA";
    public static final String KEY_ACTION_SEARCH_COLLECTIONS = "pl.wasat.smarthma.KEY_ACTION_SEARCH_COLLECTIONS";

    public static final int REQUEST_CODE_GLOBAL_SETTINGS = 100;

    public static final String KEY_PREF_FILE = "SmartHMAPrefFile";
    public static final String KEY_PREF_DATETIME_START = "pl.wasat.smarthma.KEY_PREF_TIME_START";
    public static final String KEY_PREF_DATETIME_END = "pl.wasat.smarthma.KEY_PREF_TIME_END";
    public static final String KEY_PREF_PARENT_ID = "pl.wasat.smarthma.KEY_PREF_PARENT_ID";
    public static final String KEY_PREF_BBOX_WEST = "pl.wasat.smarthma.KEY_PREF_BBOX_WEST";
    public static final String KEY_PREF_BBOX_SOUTH = "pl.wasat.smarthma.KEY_PREF_BBOX_SOUTH";
    public static final String KEY_PREF_BBOX_EAST = "pl.wasat.smarthma.KEY_PREF_BBOX_EAST";
    public static final String KEY_PREF_BBOX_NORTH = "pl.wasat.smarthma.KEY_PREF_BBOX_NORTH";
    public static final String KEY_PREF_QUERY = "pl.wasat.smarthma.KEY_PREF_QUERY";

    public static final int SORT_BY_TITLE_ASCENDING = 0;
    public static final int SORT_BY_TITLE_DESCENDING = 1;
    public static final int SORT_BY_DATE_ASCENDING = 2;
    public static final int SORT_BY_DATE_DESCENDING = 3;

    public static final String DATE_NULL = "0000-00-00T00:00:00Z";

    public static final int MAX_SEARCH_HISTORY_ENTRIES = 5;
    public static final int MAX_WIDGET_ENTRIES = 10;

    public static boolean IS_KINDLE = false;

    public static void setHttpEsaBaseUrl() {
        HTTP_BASE_URL = HTTP_ESA_BASE_URL;
    }

    public static void setHttpSpacebelBaseUrl() {
        HTTP_BASE_URL = HTTP_SPACEBEL_BASE_URL;
    }

    public static void setHttpSmaadBaseUrl() {
        HTTP_BASE_URL = HTTP_SMAAD_BASE_URL;
    }

}
