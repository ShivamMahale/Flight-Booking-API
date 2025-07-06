<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Directions Map</title>
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCyg-v1Y-CGifGUq_blbnUKwYyZqO2HgMg" async defer></script>
</head>
<body>
    <div id="map"></div>

    <script>
        function initMap() {
            var map = new google.maps.Map(document.getElementById('map'), {
                zoom: 8
            });

            var encodedPolyline = "${encodedPolyline}";

            var decodedPolyline = google.maps.Polyline.decodePath(encodedPolyline);

            var polyline = new google.maps.Polyline({
                path: decodedPolyline,
                strokeColor: '#0000FF',
                strokeWeight: 3
            });

            polyline.setMap(map);
        }
    </script>
</body>
</html>
