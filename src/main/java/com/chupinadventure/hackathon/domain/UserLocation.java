package com.chupinadventure.hackathon.domain;

import com.chupinadventure.hackathon.service.UserLocationCreateCommand;
import com.chupinadventure.hackathon.utils.GeoUtils;
import lombok.*;
import org.locationtech.jts.geom.Point;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class UserLocation {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false, columnDefinition = "POINT SRID 4326")
    private Point location;

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;

    public static UserLocation of(final UserLocationCreateCommand command) {
        final Point point = GeoUtils.create(command.getLongitude(), command.getLatitude());

        return new UserLocation(null, command.getUserId(), point, null, null);
    }
}
