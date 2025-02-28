package com.translation.app.translation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class TranslationService {
    @Autowired
    private TranslationRepository translationRepo;

    public Translation createTranslation(Translation translation) {
        translation.setTranslatedText("[Translated] " + translation.getText());
        return translationRepo.save(translation);
    }

    public List<Translation> searchTranslations(String tag, String text, String language, Pageable pageable) {
        if (tag != null) {
            return translationRepo.findByTag(tag,pageable);
        } else if (text != null) {
            return translationRepo.findByTextContaining(text,pageable);
        } else if (language != null) {
            return translationRepo.findByLanguage(language,pageable);
        }
        return translationRepo.findAll(pageable).getContent().stream().toList();
    }

    public List<Translation> exportTranslations(int page, int size) {
        return translationRepo.findAll(PageRequest.of(page, size)).getContent();
    }
}

