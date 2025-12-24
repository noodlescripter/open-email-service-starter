package open.email.service.configuration;

import lombok.Builder;

import java.util.Properties;

@Builder
public class OpenEmailConfig {

    private String host;

    private String port;

    private String auth;

    private Boolean startTLS;

    private String appUsername;

    private String appPassword;

    private String fromEmail;

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getAuth() {
        return auth;
    }

    public Boolean getStartTLS() {
        return startTLS;
    }

    public String getAppUsername() {
        return appUsername;
    }

    public String getAppPassword() {
        return appPassword;
    }

    @Override
    public String toString() {
        return "EmailConfig{" + "host='" + host + '\'' + ", port='" + port + '\'' + ", auth='" + auth + '\'' + ", startTLS=" + startTLS + ", appUsername='" + appUsername + '\'' + ", appPassword='" + appPassword + '\'' + ", fromEmail='" + fromEmail + '\'' + '}';
    }

    public String getFromEmail() {
        return fromEmail;
    }

    public Properties toProperties() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", String.valueOf(auth));
        props.put("mail.smtp.starttls.enable", String.valueOf(startTLS));
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", String.valueOf(port));
        props.put("mail.smtp.from", fromEmail);
        return props;
    }
}

