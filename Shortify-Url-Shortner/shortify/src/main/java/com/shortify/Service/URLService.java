package com.shortify.Service;

import com.shortify.DTO.URLDTO;
import com.shortify.Model.ShortURL;
import com.shortify.Repo.UrlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class URLService {
    private static final String Alphabets="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYS0123456789";
    private static  final int base= Alphabets.length();

    @Autowired
    private UrlRepo repo;


    public URLDTO shortenUrl(URLDTO url)
    {
        ShortURL t = new ShortURL();
        t.setLongURL(url.getLongUrl());

        ShortURL save = repo.save(t);
        String s = encodeDatabaseId(save.getId());

        URI uri= ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path(s)
                .build()
                .toUri();
        System.out.println("uri " + uri);
        URLDTO u= new URLDTO();
        u.setShortUrl(uri.toString());
        return u;


    }
    public static String encodeDatabaseId(long dbId)
    {
        StringBuilder sb = new StringBuilder();
        while(dbId>0)
        {
            sb.append(Alphabets.charAt((int)(dbId%base)));
            dbId=dbId/base;
        }
        return sb.reverse().toString();
    }
    public static long decodeShortUrl(String shortUrl)
    {
        long num=0;
        for(int i =0;i<shortUrl.length();i++)
        {
            num = num *base+Alphabets.indexOf(shortUrl.charAt(i));
        }
        return num;
    }
    public String urlRedirect(String url)
    {
        long dbId = decodeShortUrl(url);
        Optional<ShortURL> byId = repo.findById(dbId);
        if(byId.isEmpty()) throw new RuntimeException("NO  url found");
        String longURL = byId.get().getLongURL();

        return longURL;
    }
}
