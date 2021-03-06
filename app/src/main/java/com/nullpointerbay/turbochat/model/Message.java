package com.nullpointerbay.turbochat.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

import paperparcel.PaperParcel;

@PaperParcel
public class Message implements Parcelable {

    public static final Creator<Message> CREATOR = PaperParcelMessage.CREATOR;

    long id;
    String text;
    List<String> mentions;
    List<String> emoticons;
    List<Link> links;
    User user;

    public Message(long id, String text, List<String> mentions, List<String> emoticons, List<Link> links, User user) {
        this.id = id;
        this.text = text;
        this.mentions = mentions;
        this.emoticons = emoticons;
        this.links = links;
        this.user = user;
    }

    public Message(String text, List<String> mentions, List<String> emoticons, List<Link> links, User user) {
        this.text = text;
        this.mentions = mentions;
        this.emoticons = emoticons;
        this.links = links;
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public List<String> getMentions() {
        return mentions;
    }

    public List<String> getEmoticons() {
        return emoticons;
    }

    public List<Link> getLinks() {
        return links;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (text != null ? !text.equals(message.text) : message.text != null) return false;
        if (mentions != null ? !mentions.equals(message.mentions) : message.mentions != null)
            return false;
        if (emoticons != null ? !emoticons.equals(message.emoticons) : message.emoticons != null)
            return false;
        return links != null ? links.equals(message.links) : message.links == null;

    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    @Override
    public int hashCode() {
        int result = text != null ? text.hashCode() : 0;
        result = 31 * result + (mentions != null ? mentions.hashCode() : 0);
        result = 31 * result + (emoticons != null ? emoticons.hashCode() : 0);
        result = 31 * result + (links != null ? links.hashCode() : 0);
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        PaperParcelMessage.writeToParcel(this, parcel, flags);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", mentions=" + mentions +
                ", emoticons=" + emoticons +
                ", links=" + links +
                ", user=" + user +
                '}';
    }
}
