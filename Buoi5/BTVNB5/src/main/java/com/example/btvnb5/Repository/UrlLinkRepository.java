package com.example.btvnb5.Repository;

import com.example.btvnb5.Model.UrlLink;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UrlLinkRepository extends JpaRepository<UrlLink, Long> {

     UrlLink findUrlLinkByShortedLink(String shortedLink);
}
