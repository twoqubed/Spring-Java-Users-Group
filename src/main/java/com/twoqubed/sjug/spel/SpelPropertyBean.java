package com.twoqubed.sjug.spel;

import org.springframework.beans.factory.annotation.Value;

public class SpelPropertyBean {

    @Value("#{ systemProperties['my.annotation.property'] }")
    private String annotationProperty;

    public void setAnnotationProperty(String annotationProperty) {
        this.annotationProperty = annotationProperty;
    }

    public String getAnnotationProperty() {
        return this.annotationProperty;
    }
}

