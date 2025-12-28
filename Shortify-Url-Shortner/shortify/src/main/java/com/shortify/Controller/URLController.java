package com.shortify.Controller;

import com.shortify.DTO.URLDTO;
import com.shortify.Service.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@CrossOrigin(origins = "*")
public class URLController {
    @Autowired
    private URLService urlService;

    @PostMapping("/short")
    public ResponseEntity<?> shortURL(@RequestBody URLDTO url)
    {
        System.out.println("inside post short url " + url.getLongUrl());
        URLDTO response = urlService.shortenUrl(url);
        return  ResponseEntity.ok(response);
    }

    @GetMapping("/{shortUrl}")
    public ResponseEntity redirect(@PathVariable("shortUrl") String shortUrl)
    {
        String longUrl = urlService.urlRedirect(shortUrl);
        System.out.println("long url " + longUrl);
        return  ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(longUrl))
                .build();

    }


}
