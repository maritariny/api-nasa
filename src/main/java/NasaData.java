import com.fasterxml.jackson.annotation.JsonProperty;

public class NasaData {
    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    @JsonProperty("media_type")
    private String mediaType;
    @JsonProperty("service_version")
    private String serviceVersion;
    private String title;
    private String url;

    @Override
    public String toString() {
        return "NasaData{" +
                "copyright=" + copyright +
                ", date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", hdurl='" + hdurl + '\'' +
                ", media_type=" + mediaType + '\'' +
                ", service_version=" + serviceVersion + '\'' +
                ", title=" + title + '\'' +
                ", url=" + url +
                '}';
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return mediaType;
    }

    public String getService_version() {
        return serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public void setMedia_type(String media_type) {
        this.mediaType = media_type;
    }

    public void setService_version(String service_version) {
        this.serviceVersion = service_version;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
