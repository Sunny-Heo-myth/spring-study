package org.alan.spring.toby.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "take")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Take {

    @Id
    private Long id;


}
