import 'dart:io';

import 'package:uuid/uuid.dart';

const uuid = Uuid();

class PlaceLocation {
  const PlaceLocation({
    required this.latitude,
    required this.longitube,
    required this.address,
  });

  final double latitude;
  final double longitube;
  final String address;
}

class Place {
  Place({
    required this.title,
    required this.image,
    // required this.placeLocation,
  }) : id = uuid.v4();

  final String id;
  final String title;
  final File image;
// final PlaceLocation placeLocation;
}
