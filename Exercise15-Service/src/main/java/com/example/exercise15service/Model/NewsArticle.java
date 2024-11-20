package com.example.exercise15service.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsArticle {
    @NotEmpty(message = "id not valid")
    @Size(max = 100,message = "max length of id is 100")
    private String id;
    @NotEmpty(message = "author not valid")
    @Size(min = 5,max = 20,message = "length of author should be between 5-20")
    private String author;
    @NotEmpty(message = "content not valid")
    @Size(min = 201,message = "minimum length of content is 200")
    private String content;
    @NotEmpty(message = "category not valid")
    @Pattern(regexp = "^(politics|sports|technology)$", message = "category must be politics 0r sports or technology")
    private String category;
    @NotEmpty(message = "imageUrl not valid")
    private String imageUrl;
    private boolean isPublished = false;
    private LocalDate publishDate;



}
