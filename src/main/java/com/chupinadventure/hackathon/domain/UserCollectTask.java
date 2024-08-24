package com.chupinadventure.hackathon.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Map;

@Getter
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

    @Column(nullable = false)
    private Status status;

    @Column(columnDefinition = "json")
    @Convert(converter = MapToJsonConverter.class)
    private Map<TrashType, Integer> summaries;

    public static UserCollectTask of(final String userId) {
        return new UserCollectTask(null, userId, Status.START, null);
    }

    public void end(final Map<TrashType, Integer> summaries) {
        makeSummaries(summaries);
        status = Status.END;
    }

    private void makeSummaries(final Map<TrashType, Integer> summaries) {
        this.summaries = summaries;
    }

    private enum Status {
        START, END
    }


}
