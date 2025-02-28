package com.translation.app.translation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface TranslationRepository extends JpaRepository<Translation, Long> {
    List<Translation> findByTag(String tag);
    List<Translation> findByTextContaining(String text);
    List<Translation> findByLanguage(String language);
}