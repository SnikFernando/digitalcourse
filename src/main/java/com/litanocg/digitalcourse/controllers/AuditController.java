package com.litanocg.digitalcourse.controllers;

import com.litanocg.digitalcourse.entities.Audit;
import com.litanocg.digitalcourse.entities.dtos.AuditDTO;
import com.litanocg.digitalcourse.entities.dtos.MessageResponse;
import com.litanocg.digitalcourse.services.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("/audits")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @GetMapping
    public Flux<Audit> getAllAudits() {
        return auditService.getAllAudits();
    }

    @GetMapping("/{id}")
    public Mono<AuditDTO> getAuditById(@PathVariable Long id) {
        return auditService.getAuditById(id);
    }

    @PostMapping
    public Mono<AuditDTO> createAudit(@Validated @RequestBody AuditDTO audit) {
        return auditService.createAudit(audit);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<MessageResponse>> deleteAudit(@PathVariable Long id) {
        return auditService.deleteAudit(id)
                .map(response -> {
                    if (response.getMessage().contains("no existe")) {
                        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
                    }
                    return ResponseEntity.ok(response);
                });
    }
}
