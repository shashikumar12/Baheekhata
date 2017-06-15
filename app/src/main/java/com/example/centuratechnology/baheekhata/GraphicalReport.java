package com.example.centuratechnology.baheekhata;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;

public class GraphicalReport extends AppCompatActivity {

    private String[] data = {"Ring", "Chain", "Other Gold", "gundu"};
    private float[] value = {34.0f, 33.1f, 22.7f, 10.2f};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphical_report);

        PieChart piChat = (PieChart) findViewById(R.id.pieChart);
        //piChat.setDescription("");
        piChat.setContentDescription("Total = 82.4%");
        piChat.setHoleRadius(10f);
        piChat.setDrawEntryLabels(true);
        addDataSet(piChat);

       /* piChat.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
            @Override
            public void onValueSelected(Entry e, Highlight h) {

            }

            @Override
            public void onNothingSelected() {

            }
        });*/
    }

    private void addDataSet(PieChart piChat) {
        ArrayList<PieEntry> vEntry = new ArrayList<>();
        ArrayList<String> dEntry = new ArrayList<>();

        for (int i = 0; i < value.length; i++) {
            vEntry.add(new PieEntry(value[i], i));
        }
        for (int i = 0; i < data.length; i++) {
            dEntry.add(data[i]);
        }

        PieDataSet dataSet = new PieDataSet(vEntry, "");
        dataSet.setSliceSpace(2);
        dataSet.setValueTextSize(20);
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
        colors.add(Color.BLUE);
        colors.add(Color.RED);

        dataSet.setColors(colors);

        Legend legend = piChat.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);

        PieData pieData = new PieData(dataSet);
        piChat.setData(pieData);
        piChat.invalidate();

    }
}
