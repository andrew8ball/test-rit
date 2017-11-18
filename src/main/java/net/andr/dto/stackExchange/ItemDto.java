package net.andr.dto.stackExchange;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemDto {
    @SerializedName("tags")
    private List<String> tags;
    @SerializedName("owner")
    private OwnerDto owner;
    @SerializedName("is_answered")
    private Boolean isAnswered;
    @SerializedName("accepted_answer_id")
    private Long acceptedAnswerId;
    @SerializedName("view_count")
    private Integer viewCount;
    @SerializedName("answer_count")
    private Integer answerCount;
    @SerializedName("score")
    private Integer score;
    @SerializedName("last_activity_date")
    private Long lastActivityDate;
    @SerializedName("creation_date")
    private Long creationDate;
    @SerializedName("question_id")
    private Long questionId;
    @SerializedName("link")
    private String link;
    @SerializedName("title")
    private String title;
    @SerializedName("body")
    private String body;
    @SerializedName("answer_id")
    private Long answerId;

    public ItemDto() {
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public OwnerDto getOwner() {
        return owner;
    }

    public void setOwner(OwnerDto owner) {
        this.owner = owner;
    }

    public Boolean getAnswered() {
        return isAnswered;
    }

    public void setAnswered(Boolean answered) {
        isAnswered = answered;
    }

    public Long getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(Long acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public Integer getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Integer answerCount) {
        this.answerCount = answerCount;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getLastActivityDate() {
        return lastActivityDate;
    }

    public void setLastActivityDate(Long lastActivityDate) {
        this.lastActivityDate = lastActivityDate;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Long answerId) {
        this.answerId = answerId;
    }

    @Override
    public String toString() {
        return "QuestionDto{" +
                "tags=" + tags +
                ", owner=" + owner +
                ", isAnswered=" + isAnswered +
                ", acceptedAnswerId=" + acceptedAnswerId +
                ", viewCount=" + viewCount +
                ", answerCount=" + answerCount +
                ", score='" + score + '\'' +
                ", lastActivityDate=" + lastActivityDate +
                ", createionDate=" + creationDate +
                ", questionId='" + questionId + '\'' +
                ", link='" + link + '\'' +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
