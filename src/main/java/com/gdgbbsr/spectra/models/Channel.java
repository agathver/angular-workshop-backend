package com.gdgbbsr.spectra.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
public class Channel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    @CreationTimestamp
    private Timestamp createdAt;

    @Column
    @UpdateTimestamp
    private Timestamp updatedAt;
}
