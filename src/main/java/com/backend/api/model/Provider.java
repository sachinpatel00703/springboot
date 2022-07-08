package com.backend.api.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "provider")

public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "providername")
    private String providerName;
    @Column(name = "flowname")
    private String flowName;

    @Column(name = "downfrom")
    private LocalDateTime downFrom;

    @Column(name = "downto")
    private LocalDateTime downTo;

}
