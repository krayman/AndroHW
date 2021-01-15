package com.krayapp.androhw;

import android.os.Parcel;
import android.os.Parcelable;

public class CalcLogic implements Parcelable {
    String resultView;
    String historyView = " ";


    protected CalcLogic(Parcel in) {
        resultView = in.readString();
        historyView = in.readString();
    }

    public static final Creator<CalcLogic> CREATOR = new Creator<CalcLogic>() {
        @Override
        public CalcLogic createFromParcel(Parcel in) {
            return new CalcLogic(in);
        }

        @Override
        public CalcLogic[] newArray(int size) {
            return new CalcLogic[size];
        }
    };

    public CalcLogic() {

    }

    public String getResultView() {
        return resultView;
    }

    public void setResultView(String resultView) {
        this.resultView = resultView;
    }

    public String getHistoryView() {
        return historyView;
    }

    public void setHistoryView(String historyView) {
        this.historyView = historyView;
    }

    public void equalsMethod(String result) {
        int i = 0;
        float res;
        if (result.indexOf('+') != -1) {
            String[] values = result.split("\\+");
            Float value1 = Float.valueOf(values[0]);
            Float value2 = Float.valueOf(values[1]);
            resultView = String.format("%s", value1 + value2);
            i++;
        } else if (result.indexOf('*') != -1) {
            String[] values = result.split("\\*");
            Float value1 = Float.valueOf(values[0]);
            Float value2 = Float.valueOf(values[1]);
            resultView = String.format("%s", value1 * value2);
            i++;
        } else if (result.indexOf('÷') != -1) {
            String[] values = result.split("÷");
            Float value1 = Float.valueOf(values[0]);
            Float value2 = Float.valueOf(values[1]);
            resultView = String.format("%s", value1 / value2);
            i++;
        } else if (result.indexOf('-') != -1) {
            String[] values = result.split("-");
            Float value1 = Float.valueOf(values[0]);
            Float value2 = Float.valueOf(values[1]);
            resultView = String.format("%s",(value1 - value2));
            i++;
        } else {
            i = 0;
        }
        if (i != 0) {
            historyView += String.format("%s \n", result);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(resultView);
        parcel.writeString(historyView);
    }
}

