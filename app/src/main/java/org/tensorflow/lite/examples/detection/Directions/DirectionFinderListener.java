package org.tensorflow.lite.examples.detection.Directions;



import java.util.List;

//import Modules.Route;


public interface DirectionFinderListener {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}
