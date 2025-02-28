package com.translation.app.translation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslationService {
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
    public Translation updateTranslation(Long id, Translation updatedTranslation) {
        return translationRepo.findById(id).map(existingTranslation -> {
            existingTranslation.setLanguage(updatedTranslation.getLanguage());
            existingTranslation.setText(updatedTranslation.getText());
            existingTranslation.setTranslatedText(updatedTranslation.getTranslatedText());
            existingTranslation.setTag(updatedTranslation.getTag());
            return translationRepo.save(existingTranslation);
        }).orElseThrow(() -> new RuntimeException("Translation not found"));
    }

    public void deleteTranslation(Long id) {
        translationRepo.deleteById(id);
    }


    public List<Translation> exportTranslations(int page, int size) {
        return translationRepo.findAll(PageRequest.of(page, size)).getContent();
    }
}

