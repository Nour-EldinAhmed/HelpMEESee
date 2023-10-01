package org.tensorflow.lite.examples.detection.Directions;

/**
 * Created by Shivam_Gaur on 12-03-2017.
 */
import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class Route {
    public Distance distance;
    public Duration duration;
    public String endAddress;
    public LatLng endLocation;
    public String startAddress;
    public LatLng startLocation;

    public List<LatLng> points;
}
