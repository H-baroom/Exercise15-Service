package com.example.exercise15service.NewsArticleController;

import com.example.exercise15service.ApiResponse.ApiResponse;
import com.example.exercise15service.Model.NewsArticle;
import com.example.exercise15service.NewsArticleService.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/NewsArticle")
@RequiredArgsConstructor
public class NewsArticleController {
    private final NewsArticleService newsArticleService;

    @PostMapping("/add")
    public ResponseEntity addNewsArticleService(@RequestBody @Valid NewsArticle newsArticle,Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(405).body(errors.getFieldError().getDefaultMessage());
        }
        newsArticleService.addNewsArticles(newsArticle);
        return ResponseEntity.status(200).body(new ApiResponse("NewsArticle added"));
    }
    @GetMapping("/get")
    public ResponseEntity getNewsArticleService(){
        ArrayList<NewsArticle> n = newsArticleService.getNewsArticle();
        return ResponseEntity.status(200).body(n);
    }
    @PutMapping("/updateNewsArticleService/{id}")
    public ResponseEntity updateNewsArticleService(@PathVariable String id,@RequestBody @Valid NewsArticle newsArticle, Errors errors){
        if (errors.hasErrors()){
            return ResponseEntity.status(405).body(errors.getFieldError().getDefaultMessage());
        }
        if (newsArticleService.updateNewsArticle(id,newsArticle)){
            return ResponseEntity.status(200).body(new ApiResponse("NewsArticle updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id not exist"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNewsArticleService(@PathVariable String id){
        if (newsArticleService.deleteNewsArticle(id)){
            return ResponseEntity.status(200).body(new ApiResponse("NewsArticle deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("id not exist"));
    }

    @PutMapping("/publishNewsArticle/{id}")
    public ResponseEntity publishNewsArticle(@PathVariable String id){
        if (newsArticleService.publishNewsArticle(id) == null){
            return ResponseEntity.status(400).body(new ApiResponse("id not exist"));
        }
        NewsArticle publish = newsArticleService.publishNewsArticle(id);
        return ResponseEntity.status(200).body(publish);
    }

    @GetMapping("/getAllPublishedNewsArticles")
    public ResponseEntity getAllPublishedNewsArticles(){
        if(newsArticleService.getAllPublishedNewsArticles() == null){
            return ResponseEntity.status(400).body(new ApiResponse("Not founed any Published NewsArticles"));
        }
        ArrayList<NewsArticle> PublishedNewsArticles = newsArticleService.getAllPublishedNewsArticles();
        return ResponseEntity.status(200).body(PublishedNewsArticles);
    }

    @GetMapping("/getNewsArticlesbyCategory/{category}")
    public ResponseEntity getNewsArticlesbyCategory(@PathVariable String category){
        ArrayList<NewsArticle> NewsArticlesbyCategory = newsArticleService.getNewsArticlesbyCategory(category);

        if (NewsArticlesbyCategory == null){
            return ResponseEntity.status(400).body(new ApiResponse("category not exist"));
        }
        else {
            return ResponseEntity.status(200).body(NewsArticlesbyCategory);
        }
    }

}
