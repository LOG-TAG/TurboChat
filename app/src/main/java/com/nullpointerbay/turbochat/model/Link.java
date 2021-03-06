package com.nullpointerbay.turbochat.model;

import android.os.Parcel;
import android.os.Parcelable;

import paperparcel.PaperParcel;

@PaperParcel
public class Link implements Parcelable {

    public static final Creator<Link> CREATOR = PaperParcelLink.CREATOR;

    String url;
    String title;

    public Link(String url, String title) {
        this.url = url;
        this.title = title;
    }

    protected Link(Parcel in) {
        url = in.readString();
        title = in.readString();
    }

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (url != null ? !url.equals(link.url) : link.url != null) return false;
        return title != null ? title.equals(link.title) : link.title == null;

    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        PaperParcelLink.writeToParcel(this, parcel, flags);
    }
}
