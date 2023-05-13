package ru.yandex.yandexlavka.util;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;

@Component
@RequiredArgsConstructor
public class RateLimiterDecorator {
    private final RateLimiterRegistry rateLimiterRegistry;
    public <T> ResponseEntity<T> execute(String name, Callable<ResponseEntity<T>> callable) {
        RateLimiter rateLimiter = rateLimiterRegistry.rateLimiter(name);
        try {
            return rateLimiter.executeCallable(callable);
        } catch (RequestNotPermitted e) {
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
