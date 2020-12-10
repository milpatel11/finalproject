//   Assignment 2
//        * Assignment: 2
//        * Author(s):
//        * Student Number:
//        * Date: November 8, 2020
//        * Description: This file sends the captcha
package com.example.demo.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "google.recaptcha.key")
public class CaptchaSettings {

    private String loadUserProperties;
    private String loadCaptchaSecret;


    public String getLoadUserProperties() {
        return loadUserProperties;
    }

    public void setLoadUserProperties(String loadUserProperties) {
        this.loadUserProperties = loadUserProperties;
    }

    public String getLoadCaptchaSecret() {
        return loadCaptchaSecret;
    }

    public void setLoadCaptchaSecret(String loadCaptchaSecret) {
        this.loadCaptchaSecret = loadCaptchaSecret;
    }
}
