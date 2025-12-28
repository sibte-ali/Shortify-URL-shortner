package com.shortify.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.HashMap;

@Entity
public class ShortURL {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "url_seq")
    @SequenceGenerator(name = "url_seq",
            sequenceName = "seq_url",
            initialValue = 10000,
            allocationSize = 1
    )
    private Long id;
    private String longURL;
    private String shortURL;
    private Boolean isExpired;
    private Date expiration;
    private Date createdAt;
    private HashMap<String,String> urlMap = new HashMap<>();

    public ShortURL() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public void setExpired(Boolean expired) {
        isExpired = expired;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public HashMap<String, String> getUrlMap() {
        return urlMap;
    }

    public void setUrlMap(HashMap<String, String> urlMap) {
        this.urlMap = urlMap;
    }
}
