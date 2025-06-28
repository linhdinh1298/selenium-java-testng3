package javaSDET;

import com.sun.source.tree.WhileLoopTree;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Topic_16_While_DoWhile {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i==3) {
                break;
            }

        }
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++;
            if (i==3) {
                break;
            }
        }

        do {
            System.out.println(i);
            i++;
        } while (i < 5);
    }
}
