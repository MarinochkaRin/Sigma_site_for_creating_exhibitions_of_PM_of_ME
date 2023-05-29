package com.mryndina.exhibitions.util.uuid;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Component
@AllArgsConstructor
public class UUIDHelper {

  public static String digest(String string) {
    return UUID.nameUUIDFromBytes(string.getBytes(StandardCharsets.UTF_8)).toString();
  }

  public static String random() {
    return UUID.randomUUID().toString();
  }

}
