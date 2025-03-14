package com.litanocg.digitalcourse.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table("documentTypeID")
public class DocumentType {

    @Id
    @Column("DocumentTypeID")
    private Long documentTypeID;

    @Column("DocumentTypeCode")
    private Long documentTypeCode;

    @Column("DocumentTypeDescription")
    private String documentTypeDescription;

    @Column("CreatedAt")
    private LocalDateTime CreatedAt;

    @Column("UpdatedAt")
    private LocalDateTime updatedAt;

    @Column("StatusRegistry")
    private LocalDateTime statusRegistry;

    @Column("StatusUpdatedAt")
    private LocalDateTime statusUpdatedAt;
}
