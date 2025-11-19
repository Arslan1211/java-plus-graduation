package ru.practicum;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "stats-server")
public interface StatsClient {

    @PostMapping("/hit")
    ResponseEntity<String> saveHit(@RequestBody HitDto hitDto);

    @GetMapping("/stats")
    List<StatsDto> getStats(@RequestParam String start,
                            @RequestParam String end,
                            @RequestParam(required = false) List<String> uris,
                            @RequestParam(defaultValue = "false") Boolean unique);
}
