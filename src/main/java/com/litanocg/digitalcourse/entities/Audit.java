package com.litanocg.digitalcourse.entities;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table("audit")
public class Audit {

    @Id
    @Column("AuditID")
    private Long auditID;

    @Column("TableName")
    private String tableName;

    @Column("Operation")
    private String operation;

    @Column("KeyValue")
    private String keyValue;

    @Column("OldValue")
    private String oldValue;

    @Column("NewValue")
    private String newValue;

    @Column("ChangedAt")
    private LocalDateTime changedAt;

    @Column("ChangedBy")
    private String changedBy;

    @Column("StatusRegistry")
    private String statusRegistry;

    @Column("StatusUpdatedAt")
    private LocalDateTime statusUpdatedAt;
}
