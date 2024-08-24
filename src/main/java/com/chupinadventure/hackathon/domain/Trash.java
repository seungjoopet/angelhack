package com.chupinadventure.hackathon.domain;

import com.chupinadventure.hackathon.service.TrashCreateCommand;
import com.chupinadventure.hackathon.utils.GeoUtils;
import lombok.*;
import org.hibernate.annotations.Where;
import org.locationtech.jts.geom.Point;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
@Where(clause = "is_delete = false")
public class Trash {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TrashType type;

    @Column(nullable = false, columnDefinition = "POINT SRID 4326")
    private Point location;

    @Column(nullable = false)
    private String userId;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    @Column(nullable = false)
    private boolean isDeleted;

    public static Trash of(final String userId, final TrashCreateCommand command) {
        final Point point = GeoUtils.create(command.getLongitude(), command.getLatitude());

        return new Trash(null, command.getType(), point, userId, null, null, false);
    }

    public void delete() {
        isDeleted = true;
    }
}
