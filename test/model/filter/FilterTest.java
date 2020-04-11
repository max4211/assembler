package model.filter;

import org.junit.jupiter.api.Test;
import utility.io.Input;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterTest {

    @Test
    void testFilterEmptyLines() {
        List<String> input = new ArrayList<>(List.of(
                "add $1, $2, $3",
                "sub $2, $4, $5",
                "",
                "\n",
                "add $5, $7, $5"));
        List<String> expected = new ArrayList<>(List.of(
                "add 1 2 3",
                "sub 2 4 5",
                "add 5 7 5"));
        Filter filter = new Filter(input);
        List<String> result = filter.filter().getList();
        for (int i = 0; i < result.size(); i ++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    void testFilterComments() {
        List<String> input = new ArrayList<>(List.of(
                "add $1, $2, $3 #Hello world",
                "sub $2, $4, $5 #Testing comments",
                "#This is a comment",
                "\n #Please delete me",
                "bne $5, $7, $5 #Please delete me too"));
        List<String> expected = new ArrayList<>(List.of(
                "add 1 2 3",
                "sub 2 4 5",
                "bne 5 7 5"));
        Filter filter = new Filter(input);
        List<String> result = filter.filter().getList();
        for (int i = 0; i < result.size(); i ++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    void testFilterDollar() {
        List<String> input = new ArrayList<>(List.of(
                "add $1, $2, $3 #Hello world",
                "sub $2, $4, $5 #Testing comments",
                "#This is a comment",
                "\n #Please delete me",
                "bne $5, $7, $5 #Please delete me too"));
        List<String> expected = new ArrayList<>(List.of(
                "add 1 2 3",
                "sub 2 4 5",
                "bne 5 7 5"));
        Filter filter = new Filter(input);
        List<String> result = filter.filter().getList();
        for (int i = 0; i < result.size(); i ++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    void testFilterRegisterNames() {
        List<String> input = new ArrayList<>(List.of(
                "add $t9, $t2, $t1 #Hello world",
                "sub $a0, $a1, $a2 #Testing comments",
                "#This is a comment",
                "\n #Please delete me",
                "bne $ra, $gp, $fp #Please delete me too"));
        List<String> expected = new ArrayList<>(List.of(
                "add 25 10 9",
                "sub 4 5 6",
                "bne 31 28 30"));
        Filter filter = new Filter(input);
        List<String> result = filter.filter().getList();
        for (int i = 0; i < result.size(); i ++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    void testFilterImmediate() {
        List<String> input = new ArrayList<>(List.of(
                "sw $0, 14($1)",
                "lw $0, 19($5)"));
        List<String> expected = new ArrayList<>(List.of(
                "sw 0 1 14",
                "lw 0 5 19"));
        Filter filter = new Filter(input);
        List<String> result = filter.filter().getList();
        for (int i = 0; i < result.size(); i ++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

}