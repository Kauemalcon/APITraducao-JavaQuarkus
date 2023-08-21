package br.com.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TranslateRequest {
    private String q;
    private String source;
    private String target;
    private String format;
}
