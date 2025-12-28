package com.shortify.Repo;

import com.shortify.Model.ShortURL;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepo extends JpaRepository<ShortURL,Long> {
}
