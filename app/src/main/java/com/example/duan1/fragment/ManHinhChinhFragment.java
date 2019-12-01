package com.example.duan1.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.example.duan1.R;
import com.example.duan1.activity.BaiTapActivity;
import com.example.duan1.activity.ThucPhamActivity;
import com.example.duan1.databinding.FragmentManHinhChinhBinding;
import com.example.duan1.inteface.MHChinh_Inteface;
import com.example.duan1.model.NguoiDung;
import com.example.duan1.presenter.MHChinh_Precenter;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.DataSet;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class ManHinhChinhFragment extends Fragment implements MHChinh_Inteface {

    private TextView tvMhcStart;
    private TextView tvMhcAge;
    private ImageView imgMhcSex;
    private TextView tvMhcHeight;
    private TextView tvMhcBMI;
    private TextView tvMhcWeight;
    private TextView tvMhcStatus;
    private TextView tvMhcPosttime;
    private CardView cvBieuDo;
    private CombinedChart mChart;
    private CardView cvMhcWeight;
    private CardView cvMhcBMI;
    private CardView cvMhcNextFood;
    private CardView cvMhcNextExercise;
    private MHChinh_Precenter mhChinhPrecenter;
    private FragmentManHinhChinhBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_man_hinh_chinh, container, false);
        init();
        mhChinhPrecenter = new MHChinh_Precenter(this);

        NguoiDung nguoiDung = new NguoiDung(1, "nam", "19", "nam", "58", "168");

        mhChinhPrecenter.setupChart();
        binding.setMhcprecenter(mhChinhPrecenter);

        binding.setNguoidungView((nguoiDung));
        return binding.getRoot();
    }


    void init() {

        tvMhcStart = (TextView) binding.getRoot().findViewById(R.id.tv_mhc_Start);
        tvMhcAge = (TextView) binding.getRoot().findViewById(R.id.tv_mhc_Age);
        imgMhcSex = (ImageView) binding.getRoot().findViewById(R.id.img_mhc_Sex);
        tvMhcHeight = (TextView) binding.getRoot().findViewById(R.id.tv_mhc_Height);
        tvMhcBMI = (TextView) binding.getRoot().findViewById(R.id.tv_mhc_BMI);
        tvMhcWeight = (TextView) binding.getRoot().findViewById(R.id.tv_mhc_Weight);
        tvMhcStatus = (TextView) binding.getRoot().findViewById(R.id.tv_mhc_Status);
        tvMhcPosttime = (TextView) binding.getRoot().findViewById(R.id.tv_mhc_Posttime);
        cvBieuDo = (CardView) binding.getRoot().findViewById(R.id.cvBieuDo);
        mChart = (CombinedChart) binding.getRoot().findViewById(R.id.combinedChart_MHC);
        cvMhcWeight = (CardView) binding.getRoot().findViewById(R.id.cv_mhc_Weight);
        cvMhcBMI = (CardView) binding.getRoot().findViewById(R.id.cv_mhc_BMI);
        cvMhcNextFood = (CardView) binding.getRoot().findViewById(R.id.cv_mhc_NextFood);
        cvMhcNextExercise = (CardView) binding.getRoot().findViewById(R.id.cv_mhc_NextExercise);

    }


    public void onValueSelected(Entry e, Highlight h) {
        Toast.makeText(getActivity(), "Value: "
                + e.getY()
                + ", index: "
                + h.getX()
                + ", DataSet index: "
                + h.getDataSetIndex(), Toast.LENGTH_SHORT).show();
    }


    public void onNothingSelected() {

    }

    private static DataSet dataChart() {

        LineData d = new LineData();
        int[] data = new int[]{1, 2, 2, 1, 1, 1, 2, 1, 1, 2, 1, 9};

        ArrayList<Entry> entries = new ArrayList<Entry>();

        for (int index = 0; index < 12; index++) {
            entries.add(new Entry(index, data[index]));
        }

        LineDataSet set = new LineDataSet(entries, "Request Ots approved");
        set.setColor(Color.GREEN);
        set.setLineWidth(2.5f);
        set.setCircleColor(Color.GREEN);
        set.setCircleRadius(5f);
        set.setFillColor(Color.GREEN);
        set.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        set.setDrawValues(true);
        set.setValueTextSize(10f);
        set.setValueTextColor(Color.GREEN);

        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        d.addDataSet(set);

        return set;
    }

    @Override
    public void setJob_cvMhcWeight() {

        Toast.makeText(getActivity(), "setJob_cvMhcWeight", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void setJob_cvMhcBMI() {
        Toast.makeText(getActivity(), "setJob_cvMhcBMI", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setJob_cvMhcNextFood() {
        cvMhcNextFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ThucPhamActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void setJob_cvMhcNextExercise() {
        cvMhcNextExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BaiTapActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void setupChart() {

        mChart.getDescription().setEnabled(false);
        mChart.setBackgroundColor(Color.WHITE);
        mChart.setDrawGridBackground(false);
        mChart.setDrawBarShadow(false);
        mChart.setHighlightFullBarEnabled(false);

//        mChart.setOnChartValueSelectedListener(getActivity());

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setDrawGridLines(false);
        rightAxis.setAxisMinimum(0f);

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setDrawGridLines(false);
        leftAxis.setAxisMinimum(0f);

        final List<String> xLabel = new ArrayList<>();
        xLabel.add("Jan");
        xLabel.add("Feb");
        xLabel.add("Mar");
        xLabel.add("Apr");
        xLabel.add("May");
        xLabel.add("Jun");
        xLabel.add("Jul");
        xLabel.add("Aug");
        xLabel.add("Sep");
        xLabel.add("Oct");
        xLabel.add("Nov");
        xLabel.add("Dec");

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xLabel.get((int) value % xLabel.size());
            }
        });

        CombinedData data = new CombinedData();
        LineData lineDatas = new LineData();
        lineDatas.addDataSet((ILineDataSet) dataChart());

        data.setData(lineDatas);

        xAxis.setAxisMaximum(data.getXMax() + 0.25f);

        mChart.setData(data);
        mChart.invalidate();

    }
}

