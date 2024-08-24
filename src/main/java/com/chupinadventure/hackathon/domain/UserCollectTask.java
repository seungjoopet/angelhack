package com.chupinadventure.hackathon.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class UserCollectTask {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    private Status status;

    public static UserCollectTask of(final String userId) {
        return new UserCollectTask(null, userId, Status.START);
    }

    public void end() {
        status = Status.END;
    }

    public long getId() {
        return id;
    }

    private enum Status {
        START, END
    }


}
