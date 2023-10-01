
package org.tensorflow.lite.examples.detection.currency;

import java.util.List;

public interface ResultsView {
  public void setResults(final List<Classifier.Recognition> results);
}
