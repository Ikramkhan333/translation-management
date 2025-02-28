package com.translation.app.translation;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface TranslationRepository extends JpaRepository<Translation, Long> {
    List<Translation> findByTag(String tag , org.springframework.data.domain.Pageable page);
    List<Translation> findByTextContaining(String text, org.springframework.data.domain.Pageable page);
    List<Translation> findByLanguage(String language, Pageable pageable);

}