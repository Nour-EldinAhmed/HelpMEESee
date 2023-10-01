package org.tensorflow.lite.examples.detection;


import android.os.Bundle;
import android.view.View;

public interface MvpView {

  View getAndroidLayoutView();
  View getLayoutDir();
  Bundle getViewState();

  /**
   * Put the values of the view widgets in the bundle associated with view state
   */
  void onSaveViewState(Bundle outState);

  void onRestoreInstanceState(Bundle inState);
}
