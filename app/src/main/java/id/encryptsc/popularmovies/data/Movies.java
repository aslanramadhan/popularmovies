package id.encryptsc.popularmovies.data;

import android.graphics.Movie;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aslanramadhan
 */

public class Movies implements Parcelable{

    private String title;
    @SerializedName("poster_path")
    private String poster;
    @SerializedName("overview")
    private String synopsis;
    @SerializedName("original_language")
    private String lang;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("backdrop_path")
    private String backdrop;
    @SerializedName("vote_count")
    private String vc;
    @SerializedName("vote_average")
    private String va;
    @SerializedName("release_date")
    private String rd;

    Movies(){}

    protected Movies(Parcel parcel){
        title = parcel.readString();
        poster = parcel.readString();
        synopsis = parcel.readString();
        lang = parcel.readString();
        originalTitle = parcel.readString();
        backdrop = parcel.readString();
        vc = parcel.readString();
        va = parcel.readString();
        rd = parcel.readString();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel parcel) {
            return new Movies(parcel);
        }

        @Override
        public Movies[] newArray(int i) {
            return new Movies[i];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPoster() {
        return "http://image.tmdb.org/t/p/w780" + poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getBackdrop() {
        return "http://image.tmdb.org/t/p/w500" + backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getVc() {
        return vc;
    }

    public void setVc(String vc) {
        this.vc = vc;
    }

    public String getVa() {
        return va;
    }

    public void setVa(String va) {
        this.va = va;
    }

    public String getRd() {
        return rd;
    }

    public void setRd(String rd) {
        this.rd = rd;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(poster);
        parcel.writeString(synopsis);
        parcel.writeString(lang);
        parcel.writeString(originalTitle);
        parcel.writeString(backdrop);
        parcel.writeString(vc);
        parcel.writeString(va);
        parcel.writeString(rd);
    }

    public static class MovieResluts{
        private List<Movies> results;
        public List<Movies> getResults(){
            return results;
        }
    }
}
