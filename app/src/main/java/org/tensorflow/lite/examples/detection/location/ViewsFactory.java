package org.tensorflow.lite.examples.detection.location;

import android.content.Context;

import org.tensorflow.lite.examples.detection.MvpView;
import org.tensorflow.lite.examples.detection.location.view.LocationScreenViewImpl;


public class ViewsFactory {

  public static MvpView createView(Context context, AppFeaturesEnum featureId) {
    MvpView screenView = null;

    switch (featureId) {


      case LOCATION:
        screenView = new LocationScreenViewImpl(context, null);
        break;

        //add the other features when they are implemented
      default:
       // screenView = new MainMenuScreenViewImpl(context, null);
    }

    return screenView;
  }

}
