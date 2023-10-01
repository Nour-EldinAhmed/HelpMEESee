package org.tensorflow.lite.examples.detection.location.view;


import org.tensorflow.lite.examples.detection.MvpView;
import org.tensorflow.lite.examples.detection.location.presenter.LocationScreenListener;

public interface LocationScreenView extends MvpView {

  void displayUserCurrentLocation(String userCurrentLocation);

  void setListener(LocationScreenListener listener);
}
