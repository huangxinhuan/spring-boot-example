package com.example.demo;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

// type-safe properties configuration
@Configuration
@ConfigurationProperties(prefix = "mail")
public class MailProperties {

    @Pattern(regexp = "^[\\w.]*[\\w]$")
    private String host;

    @Min(1001)
    @Max(65535)
    private Integer port;

    @Pattern(regexp = "^[\\w._+-]+@[\\w.-]+\\.[A-Za-z]{2,6}$")
    private String from;

    private List<String> recipients = new ArrayList<>();

    @NotNull
    private Credential credential;


    public String getHost() {
        return host;
    }

    public Integer getPort() {
        return port;
    }

    public String getFrom() {
        return from;
    }

    public List<String> getRecipients() {
        return recipients;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    public static class Credential {

        @Pattern(regexp = "^[A-Za-z][_A-Za-z0-9]+$")
        private String username;

        @Length(max = 32, min = 6)
        private String password;

        private List<String> authMethod = new ArrayList<>();

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public List<String> getAuthMethod() {
            return authMethod;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


}
