/*
 * Copyright (c) 2008, 2014, Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 *
 * This file is available and licensed under the following license:
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  - Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *  - Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  - Neither the name of Oracle Corporation nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package ensemble.samples.language.concurrency.task;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * A sample showing use of an an asynchronous Task to populate a table.
 *
 * @sampleName Task
 * @preview preview.png
 * @see javafx.collections.FXCollections
 * @see Task
 * @see ProgressIndicator
 * @see TableColumn
 * @see TableView
 * @embedded
 */
public class TaskApp extends Application {

    public Parent createContent() {
       TableView<DailySales> tableView = new TableView<>();
        Region veil = new Region();
        veil.setStyle("-fx-background-color: rgba(0, 0, 0, 0.4)");
        ProgressIndicator p = new ProgressIndicator();
        p.setMaxSize(150, 150);
        //Define table columns
        TableColumn idCol = new TableColumn();
        idCol.setText("ID");
        idCol.setCellValueFactory(new PropertyValueFactory("dailySalesId"));
        idCol.setPrefWidth(32);
        tableView.getColumns().add(idCol);
        TableColumn qtyCol = new TableColumn();
        qtyCol.setText("Qty");
        qtyCol.setCellValueFactory(new PropertyValueFactory("quantity"));
        qtyCol.setPrefWidth(60);
        tableView.getColumns().add(qtyCol);
        TableColumn dateCol = new TableColumn();
        dateCol.setText("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory("date"));
        dateCol.setMinWidth(240);
        tableView.getColumns().add(dateCol);
        tableView.setMinSize(240, 200);
        StackPane stack = new StackPane();
        stack.getChildren().addAll(tableView, veil, p);

        // Use binding to be notified whenever the data source chagnes
        Task<ObservableList<DailySales>> task = new GetDailySalesTask();
        p.progressProperty().bind(task.progressProperty());
        veil.visibleProperty().bind(task.runningProperty());
        p.visibleProperty().bind(task.runningProperty());
        tableView.itemsProperty().bind(task.valueProperty());

        new Thread(task).start();
        return stack;
    }

    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    /**
     * Java main for when running without JavaFX launcher
     * @param args command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
