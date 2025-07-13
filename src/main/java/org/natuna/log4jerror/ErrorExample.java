package org.natuna.log4jerror;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorExample {

  private static final Logger LOG = LoggerFactory.getLogger(ErrorExample.class);

  void run() {

    LOG.info("Program started.");
    LOG.info("Program ended.");
  }

  public static void main(String[] args) {
    final var test = new ErrorExample();
    test.run();
  }
}
