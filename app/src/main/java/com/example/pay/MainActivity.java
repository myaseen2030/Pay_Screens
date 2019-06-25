package com.example.pay;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static Dialog d;
    int year = Calendar.getInstance().get(Calendar.YEAR);
    int months = Calendar.getInstance().get(Calendar.MONTH);

    Button btnYear,btnMonth;

    private Spinner spinner_netPay;
    Button send;
    LineGraphSeries<DataPoint> series;

    LineChart chart;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GraphView graphView = (GraphView) findViewById(R.id.graph);
        series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                new DataPoint(0, -20),
                new DataPoint(2, -10),
                new DataPoint(3, -8),
                new DataPoint(5, -10),
                new DataPoint(8,-8)

        });

        graphView.addSeries(series);
        series.setColor(Color.rgb(226,91,34));
        series.setThickness(8);
        series.setDrawBackground(true);

//        series.setBackgroundColor(Color.rgb(255, 188, 199));


        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graphView);
        staticLabelsFormatter.setVerticalLabels(new String[] {" ", " ", " "," "," "});
        graphView.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        // set manual Y bounds
        staticLabelsFormatter.setHorizontalLabels(new String[] {"DEC","Jan","Feb","Mar","Apr"});
        graphView.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);

        graphView.getViewport().setScrollable(true);
        graphView.getViewport().setXAxisBoundsManual(true);

        send = (Button) findViewById(R.id.tvSend);

        btnMonth = (Button) findViewById(R.id.btnMonth);
        btnYear = (Button)findViewById(R.id.btnYear);

        spinner_netPay = (Spinner) findViewById(R.id.sNetPay);
        String[] NetPayArray = {"Netpay","Netpay","Netpay","Netpay","Netpay","Netpay"};

        final ArrayAdapter<String> netPayAdapter = new ArrayAdapter<String>(this,R.layout.net_item,R.id.net,NetPayArray);
        spinner_netPay.setAdapter(netPayAdapter);

        spinner_netPay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0)
                {
                    spinner_netPay.setSelection(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialog(MainActivity.this, "ANNOUNCEMENT");
            }
        });

        btnYear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showYearDialog();
            }
        });

        btnMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMonthDialog();
            }
        });

    }

    private void showYearDialog() {

        final Dialog d = new Dialog(MainActivity.this);
        d.setTitle("Year Picker");
        d.setContentView(R.layout.yeardialog);
        Button set = (Button) d.findViewById(R.id.button1);
        Button cancel = (Button) d.findViewById(R.id.button2);
        TextView year_text=(TextView)d.findViewById(R.id.year_text);
        year_text.setText(""+year);
        final NumberPicker nopicker = (NumberPicker) d.findViewById(R.id.numberPicker1);

        nopicker.setMaxValue(year+50);
        nopicker.setMinValue(year-50);
        nopicker.setWrapSelectorWheel(false);
        nopicker.setValue(year);
        nopicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

        set.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                btnYear.setText(String.valueOf(nopicker.getValue()));
                d.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();


    }

    private void showMonthDialog() {


        final String wheelMenu2[] = {
                "Jan",
                "Feb",
                "Mar",
                "Apr",
                "May",
                "Jun",
                "Jul",
                "Aug",
                "Sep",
                "Oct",
                "Nov",
                "Dec"
        };
        final Dialog d = new Dialog(MainActivity.this);
        d.setTitle("Month Picker");
        d.setContentView(R.layout.monthdialog);
        Button set = (Button) d.findViewById(R.id.button1);
        Button cancel = (Button) d.findViewById(R.id.button2);
        final TextView month_text=(TextView)d.findViewById(R.id.month_text);

        final NumberPicker nopicker = (NumberPicker) d.findViewById(R.id.numberPicker1);


        nopicker.setWrapSelectorWheel(false);
        nopicker.setValue(months);
        nopicker.setMinValue(0);
        nopicker.setMaxValue(wheelMenu2.length-1);
        month_text.setText("Jan");
        nopicker.setDisplayedValues(wheelMenu2);
        nopicker.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);




        set.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
//
                final int pickedValue = nopicker.getValue();
                btnMonth.setText(wheelMenu2[pickedValue]);

                d.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();


    }


    public void showDialog(Activity activity, String msg){
        final Dialog dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.custom_dialogbox_otp);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

        TextView text = (TextView) dialog.findViewById(R.id.txt_file_path);
        text.setText(msg);

        TextView notShow = (TextView) dialog.findViewById(R.id.tvNotShow);
        notShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        ImageView cross = (ImageView) dialog.findViewById(R.id.ivCross);
        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
