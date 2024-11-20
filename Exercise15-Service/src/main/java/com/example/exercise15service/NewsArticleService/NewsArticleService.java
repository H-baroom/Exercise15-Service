package com.example.exercise15service.NewsArticleService;

import com.example.exercise15service.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class NewsArticleService {
    ArrayList<NewsArticle> newsArticles = new ArrayList();

    public ArrayList<NewsArticle> getNewsArticle(){
        return newsArticles;
    }

    public void addNewsArticles(NewsArticle newsArticle){
        newsArticles.add(newsArticle);
    }

    public boolean updateNewsArticle(String id,NewsArticle newsArticle){
        for (int i = 0; i < newsArticles.size(); i++) {
            if (newsArticles.get(i).getId().equals(id)){
                newsArticles.set(i,newsArticle);
                return true;
            }
        }
        return false;
    }

    public boolean deleteNewsArticle(String id){
        for (int i = 0; i < newsArticles.size(); i++) {
            if (newsArticles.get(i).getId().equals(id)){
                newsArticles.remove(i);
                return true;
            }
        }
        return false;
    }

    public NewsArticle publishNewsArticle(String id){
        for (int i = 0; i < newsArticles.size(); i++) {
            if (newsArticles.get(i).getId().equals(id)){
                newsArticles.get(i).setPublished(true);
                newsArticles.get(i).setPublishDate(LocalDate.now());
                return newsArticles.get(i);
            }
        }
        return null;
    }

    public ArrayList<NewsArticle> getAllPublishedNewsArticles(){
        ArrayList<NewsArticle> publishedNewsArticles = new ArrayList();
        for (NewsArticle n:newsArticles){
            if (n.isPublished()){
                publishedNewsArticles.add(n);
            }
        }
        if(publishedNewsArticles == null){
            return null;
        }else{
            return publishedNewsArticles;
        }
    }

    public ArrayList<NewsArticle> getNewsArticlesbyCategory(String category){
        ArrayList<NewsArticle> NewsArticlesbyCategory = new ArrayList();
        for (NewsArticle n:newsArticles){
            if (n.getCategory().equalsIgnoreCase(category)){
                NewsArticlesbyCategory.add(n);
            }
        }
        if (NewsArticlesbyCategory.isEmpty()){
            return null;
        }
        return NewsArticlesbyCategory;
    }


}
