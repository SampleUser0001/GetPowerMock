package sample.controller;

import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * テストで使う
 */
@NoArgsConstructor
public class SampleController {
    private int forExecute = 1;

    @Setter
    private int value;

    public int execute(){
        this.setUp();
        return this.square();
    }

    void setUp() {
        this.forExecute = value;
    }

    private int square() {
        return this.forExecute * this.forExecute;
    }

}
