package com.bookteria.notificationservice.service;

import com.bookteria.notificationservice.dto.request.EmailRequest;
import com.bookteria.notificationservice.dto.request.SendEmailRequest;
import com.bookteria.notificationservice.dto.request.Sender;
import com.bookteria.notificationservice.dto.response.EmailResponse;
import com.bookteria.notificationservice.exception.AppException;
import com.bookteria.notificationservice.exception.ErrorCode;
import com.bookteria.notificationservice.repository.httpclient.EmailClient;
import feign.FeignException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class EmailService {
    EmailClient emailClient;
    String apiKey = "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";

    public EmailResponse setEmail(SendEmailRequest request) {
        EmailRequest emailRequest = EmailRequest.builder()
                .sender(Sender.builder()
                        .name("Bookteria")
                        .email("lequoctrunggg@gmail.com")
                        .build())
                .to(List.of(request.getTo()))
                .subject(request.getSubject())
                .htmlContent(request.getHtmlContent())
                .build();
        try {
            return emailClient.sendEmail(apiKey, emailRequest);
        } catch (FeignException e) {
            throw new AppException(ErrorCode.CANNOT_SEND_EMAIL);
        }
    }
}
