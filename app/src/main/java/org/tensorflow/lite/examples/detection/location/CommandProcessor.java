package org.tensorflow.lite.examples.detection.location;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.tensorflow.lite.examples.detection.MainActivity2;
import org.tensorflow.lite.examples.detection.location.presenter.LocationScreenPresenter;


public class CommandProcessor {

  private static final CommandProcessor ourInstance = new CommandProcessor();

  private static final Class<?> locationPresClass = LocationScreenPresenter.class;

  public static CommandProcessor getInstance() {

    return ourInstance;
  }

  /**
   * @param detectedText - detected text from voice speech
   */
  public void processCommand(String detectedText, HmsActivity hmsActivity) {
    AppFeaturesEnum feature = AppFeaturesEnum.stringToFeature(detectedText);

    if (feature != null) {
      changeScreen(feature, hmsActivity.getBaseContext());
    }    //if it's not a feature then it might be another command like "Take Picture"
    else {
      hmsActivity.execute(detectedText);
    }

  }

  private void changeScreen(AppFeaturesEnum feature, Context currentContext) {
    // Context currentContext = AppState.getInstance().getCurrentContext();

    switch (feature) {


      case LOCATION:
        currentContext.startActivity(new Intent(currentContext, locationPresClass));
        break;

      default:
        currentContext.startActivity(new Intent(currentContext, MainActivity2.class));

    }
  }


}
