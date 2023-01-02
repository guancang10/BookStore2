package com.guancang10.BookStore.payload.response.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class GetListCategoryResponse {
    @JsonProperty("categories")
    List<GetCategoryResponse> getCategoryResponseList;
}
