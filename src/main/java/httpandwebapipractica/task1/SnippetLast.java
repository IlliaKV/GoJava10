package httpandwebapipractica.task1;

public class SnippetLast {
    public String authorDisplayName;
    public String textOriginal;
    public String likeCount;
    public String publishedAt;
    public String updatedAt;

    public Boolean commentEdited(){
        return publishedAt == updatedAt;
    };

    @Override
    public String toString() {
        return "\n\nauthorDisplayName = " + authorDisplayName +
                "\ntextOriginal = " + textOriginal +
                "\nlikeCount = " + likeCount +
                "\nupdatedAt = " + updatedAt +
                "\nupdatedAt = " + commentEdited();
    }
}
