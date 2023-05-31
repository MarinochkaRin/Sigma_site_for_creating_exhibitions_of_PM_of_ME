package com.mryndina.exhibitions.util.files;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.InputStream;

@Getter
@Builder
@EqualsAndHashCode
@ToString
@With
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class File {

    String name;
    InputStream content;
    long size;

}
