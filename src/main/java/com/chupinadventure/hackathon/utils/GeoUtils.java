package com.chupinadventure.hackathon.utils;

import com.chupinadventure.hackathon.global.PointAndRadius;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.geom.PrecisionModel;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GeoUtils {

    private static final GeometryFactory GEOMETRY_FACTORY = new GeometryFactory(new PrecisionModel(), 4326);

    public static Point create(final double longitude, final double latitude) {
        return GEOMETRY_FACTORY.createPoint(new Coordinate(longitude, latitude));
    }

    public static PointAndRadius calculate(final double lng1, final double lng2,
                                           final double lat1, final double lat2) {

        final double lng = lng2 + (lng1 - lng2) / 2;
        final double lat = lat2 + (lat1 - lat2) / 2;

        final double theta = lng1 - lng2;
        final double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        final double distResult = rad2deg(Math.acos(dist)) * 60 * 1.1515 * 1609.344;

        return new PointAndRadius(lat, lng, distResult);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
}
