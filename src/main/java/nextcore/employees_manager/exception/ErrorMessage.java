package nextcore.employees_manager.exception;

import java.util.Date;

public class ErrorMessage {
  private String code;
  private String params;

  public ErrorMessage(String i,  String params) {
    this.code = i;
    this.params = params;
  }

  public String getCode() {
    return code;
  }

  public String getParams() {
    return params;
  }
}