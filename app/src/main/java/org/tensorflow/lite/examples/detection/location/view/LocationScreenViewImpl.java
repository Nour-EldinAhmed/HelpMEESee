package org.tensorflow.lite.examples.detection.location.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.tensorflow.lite.examples.detection.R;
import org.tensorflow.lite.examples.detection.location.presenter.LocationScreenListener;

public class LocationScreenViewImpl implements LocationScreenView {

  private final View rootView;
  private final Context context;
  private LocationScreenListener locationScreenListener;

  //android views
  private Button speechBtn;
  private Button addContactBtn;
  private Button helpBtn;
  private TextView locationTV;


  public LocationScreenViewImpl(Context context, ViewGroup container) {
    this.context = context;

    rootView = LayoutInflater.from(context).inflate(R.layout.activity_location_screen, container);

    initialize();
  }

  private void initialize() {
    speechBtn = (Button) rootView.findViewById(R.id.speechBtn_location);
    addContactBtn = (Button) rootView.findViewById(R.id.addFriendBtn);
    helpBtn = (Button) rootView.findViewById(R.id.helpBtn);
    locationTV = (TextView) rootView.findViewById(R.id.locationTV);

    locationTV.setText("No location found!");
/*
    LayoutParams bottomLeftButtonLP = AppState.getInstance().getBottomLeftButtonLP();
    LayoutParams speechButtonLayoutParams = AppState.getInstance().getSpeechButtonLayoutParams();

    addContactBtn.setLayoutParams(bottomLeftButtonLP);
    speechBtn.setLayoutParams(speechButtonLayoutParams);
*/
    speechBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        locationScreenListener.startRecording();
      }
    });

    addContactBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        locationScreenListener.addContact();
      }
    });

    helpBtn.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(context, "Before Sending", Toast.LENGTH_SHORT).show();
        locationScreenListener.sendMessages();
      }
    });
  }

  @Override
  public View getAndroidLayoutView() {
    return rootView;
  }

  @Override
  public View getLayoutDir() {
    return rootView;
  }

  @Override
  public Bundle getViewState() {
    return null;
  }

  @Override
  public void onSaveViewState(Bundle outState) {

  }

  @Override
  public void onRestoreInstanceState(Bundle inState) {

  }

  @Override
  public void displayUserCurrentLocation(String userCurrentAddressText) {
    if (userCurrentAddressText == null) {
      return;
    }

    String[] addressInfo = userCurrentAddressText.split(",");
    locationTV.setText("");

    int length = addressInfo.length;
    for (int i = 0; i < length; i++) {

      if (addressInfo[i].charAt(0) == ' ') { // remove leading whitespace
        addressInfo[i] = addressInfo[i].replaceFirst(" ", "");
      }
      locationTV.append(addressInfo[i]);
      locationTV.append(",\n");
    }

  }

  @Override
  public void setListener(LocationScreenListener listener) {
    this.locationScreenListener = listener;
  }
}
