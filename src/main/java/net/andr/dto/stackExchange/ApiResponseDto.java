package net.andr.dto.stackExchange;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponseDto {
    @SerializedName("items")
    private List<ItemDto> items;
    @SerializedName("has_more")
    private Boolean hasMore;
    @SerializedName("quota_max")
    private Long quotaMax;
    @SerializedName("quota_remaining")
    private Long quotaRemaining;

    public ApiResponseDto() {
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    public Long getQuotaMax() {
        return quotaMax;
    }

    public void setQuotaMax(Long quotaMax) {
        this.quotaMax = quotaMax;
    }

    public Long getQuotaRemaining() {
        return quotaRemaining;
    }

    public void setQuotaRemaining(Long quotaRemaining) {
        this.quotaRemaining = quotaRemaining;
    }

    @Override
    public String toString() {
        return "ApiResponseDto{" +
                "items=" + items +
                ", hasMore=" + hasMore +
                ", quotaMax=" + quotaMax +
                ", quotaRemaining=" + quotaRemaining +
                '}';
    }
}
