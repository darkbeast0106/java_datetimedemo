package com.example.datetimedemo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class HelloController {

    @FXML
    private TableView<Example> table;
    @FXML
    private TableColumn<Example, LocalDate> date;
    @FXML
    private TableColumn<Example, String> datetime;
    @FXML
    private TableColumn<Example, LocalDateTime> timestamp;

    public void initialize() {
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        datetime.setCellValueFactory(new PropertyValueFactory<>("formattedDateTime"));
        timestamp.setCellValueFactory(new PropertyValueFactory<>("timestamp"));
        table.getItems().add(new Example(1, LocalDate.now(), LocalDateTime.now(), LocalDateTime.now()));
        table.getItems().add(new Example(2, LocalDate.parse("2000-01-01"), LocalDateTime.parse("2000-01-01T11:22:33"),LocalDateTime.parse("2000-01-01T11:22:33")));
    }
}