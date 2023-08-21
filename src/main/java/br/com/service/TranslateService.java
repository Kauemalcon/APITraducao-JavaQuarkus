package br.com.service;

import br.com.domain.TranslateRequest;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TranslateService {
        @ConfigProperty(name = "GOOGLE_API_KEY")
        String googleApiKey;


        public String traslateRequest(TranslateRequest translateRequest){
        Translate translate = TranslateOptions.newBuilder().setApiKey(googleApiKey).build().getService();
        Translation translation = translate.translate(
                translateRequest.getQ(),
                Translate.TranslateOption.sourceLanguage(translateRequest.getSource()),
                Translate.TranslateOption.targetLanguage(translateRequest.getTarget())
        );
        return translation.getTranslatedText();
    }

}
