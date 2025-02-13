package com.litanocg.digitalcourse.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table("users")
public class User {
    @Id
    @Column("UserID")
    private Long userID;

    @Column("FirstName")
    private String firstName;

    @Column("LastName")
    private String lastName;

    @Column("DocumentTypeID")
    private Long documentTypeID;

    @Column("DocumentNumber")
    private String documentNumber;

    @Column("UserEmail")
    private String userEmail;

    @Column("UserImageUrl")
    private String userImageUrl;

    @Column("EmailVerified")
    private Boolean emailVerified;

    @Column("PasswordHash")
    private String passwordHash;

    @Column("StatusRegistry")
    private String statusRegistry;

    @Column("CreatedAt")
    private LocalDateTime createdAt;

    @Column("UpdatedAt")
    private LocalDateTime updatedAt;
}
