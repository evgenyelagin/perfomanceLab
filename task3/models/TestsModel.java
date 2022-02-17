package models;

import lombok.Data;
import java.util.ArrayList;


@Data
public class TestsModel {
    private int id;
    private String title;
    private String value;
    private ArrayList<TestsModel> values;
    }