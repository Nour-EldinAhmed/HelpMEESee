package org.tensorflow.lite.examples.detection.location;

import android.content.Context;

import org.tensorflow.lite.examples.detection.MvpModel;
import org.tensorflow.lite.examples.detection.location.model.LocationModelManagerImpl;

public class ModelsFactory {

  public static MvpModel createModel(Context context, AppFeaturesEnum featureId) {
    MvpModel mvpModel = null;
    switch (featureId) {


      case LOCATION:
        mvpModel = new LocationModelManagerImpl(context);

        break;
      default:
    }

    return mvpModel;
  }

}
