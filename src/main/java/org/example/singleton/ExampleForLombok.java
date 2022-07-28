package org.example.singleton;

import lombok.*;

// RESEARCH MORE APPLICATION OF LOMBOK!
@Getter
@Setter

//@Data
//@NoArgsConstructor
//@ToString
public class ExampleForLombok {
    private String name;
    private int age;
    private String specialty;

    public ExampleForLombok() {
        this.getAge();
    }

}
