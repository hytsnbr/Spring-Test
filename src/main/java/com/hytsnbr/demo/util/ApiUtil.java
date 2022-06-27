package com.hytsnbr.demo.util;

import java.util.Objects;

public final class ApiUtil {

  private static final int SUCCESSFUL = 200; // HTTP Status: OK

  public static boolean isSuccess(int httpStatusCode) {
    return httpStatusCode == SUCCESSFUL;
  }

  public static boolean isSuccess(Integer httpStatusCode) {
    Objects.requireNonNull(httpStatusCode);

    return isSuccess(httpStatusCode.intValue());
  }

  public static boolean isSuccess(String httpStatusCode) {
    Objects.requireNonNull(httpStatusCode);
    if (!httpStatusCode.equals("")) {
      return isSuccess(Integer.parseInt(httpStatusCode));
    }

    return false;
  }

  public static boolean isFailure(int httpStatusCode) {
    return httpStatusCode != SUCCESSFUL;
  }

  public static boolean isFailure(Integer httpStatusCode) {
    Objects.requireNonNull(httpStatusCode);

    return isFailure(httpStatusCode.intValue());
  }

  public static boolean isFailure(String httpStatusCode) {
    Objects.requireNonNull(httpStatusCode);
    if (!httpStatusCode.equals("")) {
      return isFailure(Integer.parseInt(httpStatusCode));
    }

    return false;
  }
}
