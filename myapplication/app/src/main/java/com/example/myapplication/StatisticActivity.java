package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;

import java.util.ArrayList;
import java.util.List;

public class StatisticActivity extends AppCompatActivity {


    AnyChartView anyChartView;
    String [] exercise = {"High-knee running", "Stationary bicycling", "Swimming"};
    int[] statistic = {355, 311, 294};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic);



        anyChartView = findViewById(R.id.any_chart_view);
        setupPieChart();
    }

    public void setupPieChart(){

        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();
        for (int i=0; i < exercise.length; i++){
            dataEntries.add(new ValueDataEntry(exercise[i], statistic[i]));
        }

        pie.data(dataEntries);
        anyChartView.setChart(pie);


    }
}