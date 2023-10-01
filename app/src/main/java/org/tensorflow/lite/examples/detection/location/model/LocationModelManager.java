package org.tensorflow.lite.examples.detection.location.model;



import org.tensorflow.lite.examples.detection.MvpModel;

import java.util.List;

public interface LocationModelManager  extends MvpModel {
  void addContact(String contactName, String phoneNumber);

  List<Contact> getContacts();
}
