package silviano.project.pruebauniversal.pojos.news;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseNewItem {

	@SerializedName("body_html")
	private String bodyHtml;

	@SerializedName("link")
	private String link;

	@SerializedName("caption")
	private String caption;

	@SerializedName("section")
	private String section;

	@SerializedName("video")
	private String video;

	@SerializedName("title")
	private String title;

	@SerializedName("body")
	private String body;

	@SerializedName("main_section")
	private String mainSection;

	@SerializedName("premium")
	private int premium;

	@SerializedName("image_small_size")
	private String imageSmallSize;

	@SerializedName("rank")
	private int rank;

	@SerializedName("id_subseccion")
	private String idSubseccion;

	@SerializedName("id")
	private int id;

	@SerializedName("place")
	private String place;

	@SerializedName("audio")
	private String audio;

	@SerializedName("video_embed")
	private Object videoEmbed;

	@SerializedName("embed_nodes")
	private List<Object> embedNodes;

	@SerializedName("gallery")
	private Object gallery;

	@SerializedName("pubdate")
	private String pubdate;

	@SerializedName("timestamp")
	private int timestamp;

	@SerializedName("id_seccion")
	private String idSeccion;

	@SerializedName("summary")
	private String summary;

	@SerializedName("image")
	private String image;

	@SerializedName("seccion_nombre_api")
	private String seccionNombreApi;

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("comments")
	private int comments;

	@SerializedName("author")
	private String author;

	@SerializedName("body_opta")
	private Object bodyOpta;

	@SerializedName("link_title")
	private String linkTitle;

	@SerializedName("opta-widget-embed")
	private List<Object> optaWidgetEmbed;

	@SerializedName("sitio_dominio")
	private String sitioDominio;

	@SerializedName("embed_kaltura")
	private List<Object> embedKaltura;

	@SerializedName("tags")
	private String tags;

	@SerializedName("site")
	private String site;

	@SerializedName("pubtime")
	private String pubtime;

	@SerializedName("subtitle")
	private String subtitle;

	@SerializedName("opta-widget")
	private boolean optaWidget;

	@SerializedName("video_data_embed")
	private Object videoDataEmbed;

	@SerializedName("video_url_api_call")
	private Object videoUrlApiCall;

	@SerializedName("iframe_body_html")
	private String iframeBodyHtml;

	public String getBodyHtml(){
		return bodyHtml;
	}

	public String getLink(){
		return link;
	}

	public String getCaption(){
		return caption;
	}

	public String getSection(){
		return section;
	}

	public String getVideo(){
		return video;
	}

	public String getTitle(){
		return title;
	}

	public String getBody(){
		return body;
	}

	public String getMainSection(){
		return mainSection;
	}

	public int getPremium(){
		return premium;
	}

	public String getImageSmallSize(){
		return imageSmallSize;
	}

	public int getRank(){
		return rank;
	}

	public String getIdSubseccion(){
		return idSubseccion;
	}

	public int getId(){
		return id;
	}

	public String getPlace(){
		return place;
	}

	public String getAudio(){
		return audio;
	}

	public Object getVideoEmbed(){
		return videoEmbed;
	}

	public List<Object> getEmbedNodes(){
		return embedNodes;
	}

	public Object getGallery(){
		return gallery;
	}

	public String getPubdate(){
		return pubdate;
	}

	public int getTimestamp(){
		return timestamp;
	}

	public String getIdSeccion(){
		return idSeccion;
	}

	public String getSummary(){
		return summary;
	}

	public String getImage(){
		return image;
	}

	public String getSeccionNombreApi(){
		return seccionNombreApi;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public int getComments(){
		return comments;
	}

	public String getAuthor(){
		return author;
	}

	public Object getBodyOpta(){
		return bodyOpta;
	}

	public String getLinkTitle(){
		return linkTitle;
	}

	public List<Object> getOptaWidgetEmbed(){
		return optaWidgetEmbed;
	}

	public String getSitioDominio(){
		return sitioDominio;
	}

	public List<Object> getEmbedKaltura(){
		return embedKaltura;
	}

	public String getTags(){
		return tags;
	}

	public String getSite(){
		return site;
	}

	public String getPubtime(){
		return pubtime;
	}

	public String getSubtitle(){
		return subtitle;
	}

	public boolean isOptaWidget(){
		return optaWidget;
	}

	public Object getVideoDataEmbed(){
		return videoDataEmbed;
	}

	public Object getVideoUrlApiCall(){
		return videoUrlApiCall;
	}

	public String getIframeBodyHtml(){
		return iframeBodyHtml;
	}
}