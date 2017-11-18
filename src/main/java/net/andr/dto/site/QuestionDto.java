package net.andr.dto.site;

public class QuestionDto {
    private String bodyQuestion;
    private String bodyAnswer;
    private String link;
    private String title;
    private Boolean isAccepted;
    private UserDto author;
    private UserDto respondent;

    public String getBodyQuestion() {
        return bodyQuestion;
    }

    public void setBodyQuestion(String bodyQuestion) {
        this.bodyQuestion = bodyQuestion;
    }

    public String getBodyAnswer() {
        return bodyAnswer;
    }

    public void setBodyAnswer(String bodyAnswer) {
        this.bodyAnswer = bodyAnswer;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getAccepted() {
        return isAccepted;
    }

    public void setAccepted(Boolean accepted) {
        isAccepted = accepted;
    }

    public UserDto getAuthor() {
        return author;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }

    public UserDto getRespondent() {
        return respondent;
    }

    public void setRespondent(UserDto respondent) {
        this.respondent = respondent;
    }
}
