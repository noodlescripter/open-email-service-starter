# Open Email Service Starter

A lightweight Java library for sending emails with configurable SMTP settings. This library simplifies email integration by handling SMTP authentication, TLS encryption, and message formatting.

## Features

- ✉️ Simple email sending API
- 🔒 SMTP authentication support
- 🔐 TLS encryption support
- ⚙️ Property-based configuration
- 🏗️ Builder pattern for configuration

## Installation

### Maven

Add this dependency to your `pom.xml`:

```xml
<dependency>
  <groupId>open.email.service</groupId>
  <artifactId>open-email-service-starter</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

### Gradle

```gradle
implementation 'open.email.service:open-email-service-starter:1.0-SNAPSHOT'
```

## Configuration

Create an `email.properties` file in your `src/main/resources` directory with the following properties:

| Property | Type | Required | Description | Example |
|----------|------|----------|-------------|---------|
| `open.email.service.host` | String | ✅ | SMTP server hostname | `smtp.gmail.com` |
| `open.email.service.port` | String | ✅ | SMTP server port | `587` |
| `open.email.service.auth` | String | ✅ | Enable SMTP authentication | `true` |
| `open.email.service.startTLS` | String | ✅ | Enable TLS encryption | `true` |
| `open.email.service.app.username` | String | ✅ | SMTP authentication username | `your-email@gmail.com` |
| `open.email.service.app.password` | String | ✅ | SMTP authentication password or app password | `your-app-password` |
| `open.email.service.from.email` | String | ✅ | Sender email address | `noreply@example.com` |

### Example Configuration

**src/main/resources/email.properties**

```properties
# Gmail SMTP Configuration Example
open.email.service.host=smtp.gmail.com
open.email.service.port=587
open.email.service.auth=true
open.email.service.startTLS=true
open.email.service.app.username=your-email@gmail.com
open.email.service.app.password=your-app-password
open.email.service.from.email=noreply@example.com
```

**Note:** For Gmail, use an [App Password](https://support.google.com/accounts/answer/185833) instead of your regular password.

## Usage

### Basic Email Sending

```java
import open.email.service.services.OpenEmailServiceImpl;

public class EmailExample {
    public static void main(String[] args) throws Exception {
        OpenEmailServiceImpl emailService = new OpenEmailServiceImpl();
        
        // Send a simple email
        boolean success = emailService.send(
            "recipient@example.com",
            "Welcome to Our Service",
            "<h1>Hello!</h1><p>Welcome to our platform.</p>"
        );
        
        if (success) {
            System.out.println("Email sent successfully!");
        }
    }
}
```

### HTML Email Content

```java
String htmlBody = "<html>" +
    "<body>" +
    "<h1>Welcome</h1>" +
    "<p>This is an <strong>HTML</strong> email.</p>" +
    "</body>" +
    "</html>";

emailService.send("user@example.com", "Subject", htmlBody);
```

## Configuration Details

### SMTP Server Examples

#### Gmail
```properties
open.email.service.host=smtp.gmail.com
open.email.service.port=587
open.email.service.startTLS=true
```

#### Outlook
```properties
open.email.service.host=smtp-mail.outlook.com
open.email.service.port=587
open.email.service.startTLS=true
```

#### Custom SMTP Server
```properties
open.email.service.host=smtp.yourdomain.com
open.email.service.port=587
open.email.service.startTLS=true
```

## API Reference

### OpenEmailService Interface

```java
// Get email configuration from properties
Properties getEmailConfiguration();

// Build configuration from email.properties file
OpenEmailConfig buildFromEmailProperties();

// Initialize the email session
MimeMessage initializeEmailService();

// Send HTML email
boolean send(String toEmail, String subjects, String body) throws MessagingException;
```

## Error Handling

The library throws `RuntimeException` and `MessagingException` for configuration and sending errors:

```java
try {
    emailService.send("user@example.com", "Subject", "Body");
} catch (MessagingException e) {
    System.err.println("Failed to send email: " + e.getMessage());
}
```

## Common Issues

### 403 Forbidden Error
- Verify your SMTP credentials are correct
- For Gmail, ensure you're using an App Password, not your regular password
- Check that "Allow less secure app access" is enabled (if applicable)

### Connection Timeout
- Verify the SMTP host and port are correct
- Check your firewall and network settings
- Ensure TLS is enabled for port 587

### Authentication Failed
- Double-check the username and password in `email.properties`
- Ensure the file is in `src/main/resources` directory
- Verify property names are spelled correctly

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Contributing

Contributions are welcome! Please feel free to submit a pull request.

## Support

For issues or questions, please create an issue on the GitHub repository.

