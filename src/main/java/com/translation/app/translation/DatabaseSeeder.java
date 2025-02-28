package com.translation.app.translation;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
class DatabaseSeeder {
    @Autowired
    private TranslationService translationService;

    @PostConstruct
    public void seedDatabase() {
        if (translationService.searchTranslations("","","").isEmpty()) {
            IntStream.range(0, 100000).forEach(i -> {
                Translation translation = new Translation();
                translation.setLanguage("en");
                translation.setText("Sample text " + i);
                translation.setTranslatedText("Translated text " + i);
                translation.setTag("web");
                translationService.createTranslation(translation);
            });
        }
    }
}

