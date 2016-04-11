package io.github.douglasjunior.primefaceschartzoomtest;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.DateAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;

/**
 *
 * @author douglas
 */
@Named(value = "chartController")
@ViewScoped
public class ChartController implements Serializable {

    private LineChartModel model;

    public ChartController() {
    }

    @PostConstruct
    public void init() {
        long[][] lines = {{1334856823000l, 2}, {1334856853000l, 1}, {1334856883000l, 0}, {1334856913000l, 4}, {1334856914000l, 13},
        {1334856943000l, 16}, {1334856973000l, 23}, {1334857003000l, 24}, {1334857033000l, 36}, {1334857063000l, 14}, {1334857093000l, 1}};

        model = new LineChartModel();
        model.setTitle("Primefaces Chart");
        model.setZoom(true);

        LineChartSeries series = new LineChartSeries();

        for (long[] line : lines) {
            series.set(line[0], line[1]);
        }

        DateAxis xaxis = new DateAxis();
        xaxis.setTickFormat("%e/%b %H:%M");
        xaxis.setTickAngle(-30);
        xaxis.setMin(1334856823000l); // if not set this, chart not work
        model.getAxes().put(AxisType.X, xaxis);

        Axis yaxis = new LinearAxis();
        yaxis.setMin(0);
        model.getAxes().put(AxisType.Y, yaxis);

        model.addSeries(series);
    }

    public LineChartModel getModel() {
        return model;
    }

}
