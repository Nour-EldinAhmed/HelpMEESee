package org.tensorflow.lite.examples.detection.location.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class LocationModelManagerImpl implements LocationModelManager {
  private final SharedPreferences prefs;
  private final Context context;

  public LocationModelManagerImpl(Context context){
    this.context = context;
    prefs = PreferenceManager.getDefaultSharedPreferences(context);
  }

  @Override
  public void addContact(String contactName, String phoneNumber) {
    prefs.edit().putString(contactName, phoneNumber).apply();
  }

  @Override
  public List<Contact> getContacts() {
    Map<String, ?> friendsCollection = prefs.getAll();
    ArrayList<Contact> friendsList = new ArrayList<>();

    for (Entry<String, ?> contact: friendsCollection.entrySet()) {
      friendsList.add(new Contact(contact.getKey(), (String)contact.getValue()));
    }

    return friendsList;
  }
}
