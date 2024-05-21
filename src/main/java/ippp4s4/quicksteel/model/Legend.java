package ippp4s4.quicksteel.model;

import javafx.scene.chart.XYChart;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Arrays;

public class Legend extends HBox {

    public Legend() {
        // Initialize the custom legend component
        setSpacing(5); // Adjust spacing between legend items
    }

    public void addLegendItem(LegendItem item) {
        CheckBox checkBox = new CheckBox(item.getSeriesName());
        checkBox.setSelected(item.isVisible());
        checkBox.setTextFill(item.getSeriesColor());

        checkBox.setOnAction(event -> {
            item.setVisible(checkBox.isSelected());
            // Update visibility of corresponding series in the chart
            // (Implementation required based on your chart setup)

        });

        getChildren().add(checkBox);
    }

    public void addChainedLegendItems(String chainName, LegendItem... items) {
        CheckBox checkBox = new CheckBox(chainName);
        checkBox.setSelected(Arrays.stream(items).findFirst().get().isVisible());
        checkBox.setTextFill(Arrays.stream(items).findFirst().get().getSeriesColor());

        Arrays.stream(items).toList().forEach(item ->
                item.setVisible(checkBox.isSelected())
        );
        checkBox.setOnAction(event -> {
            Arrays.stream(items).toList().forEach(item ->
                    item.setVisible(checkBox.isSelected())
            );
        });
        getChildren().add(checkBox);
    }

    public void clear() {
        getChildren().clear();
    }
    public boolean isSeriesVisible(XYChart.Series<Double, Double> series) {
        return getChildren().stream()
                .filter(node -> node instanceof CheckBox)
                .map(node -> (CheckBox) node)
                .anyMatch(checkBox -> checkBox.getText().equals(series.getName()) && checkBox.isSelected());
    }
}
