package httpandwebapihomework.videos;

public class Snippet {
    public String title;
    public String channelTitle;
    public String publishedAt;
    public Thumbnails thumbnails;

    @Override
    public String toString() {
        return "\n\ntitle = " + title +
                "\nchannelTitle = " + channelTitle +
                "\npublishedAt = " + publishedAt +
                "\nthumbnails = " + thumbnails;
    }
}
