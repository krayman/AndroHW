package com.krayapp.androhw;

import android.os.Parcel;
import android.os.Parcelable;

public class CalcLogic implements Parcelable {
    String resultView;
    String historyView = " ";
    float res;


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
        int i = 0; //задание счетчика одного числа
        if (result.indexOf('+') != -1) {
            String[] values = result.split("\\+");
            if (values.length < 2){
                resultView = "0";
                return;
            }
            Float value1 = Float.valueOf(values[0]);
            Float value2 = Float.valueOf(values[1]);
            res = value1 + value2;
            i++;
        } else if (result.indexOf('*') != -1) {
            String[] values = result.split("\\*");
            if (values.length < 2){
                resultView = "0";
                return;
            }
            Float value1 = Float.valueOf(values[0]);
            Float value2 = Float.valueOf(values[1]);
            res = value1 * value2;
            i++;
        } else if (result.indexOf('÷') != -1) {
            String[] values = result.split("÷");
            if (values.length < 2){
                resultView = "0";
                return;
            }
            Float value1 = Float.valueOf(values[0]);
            Float value2 = Float.valueOf(values[1]);
            res = value1 / value2;
            i++;
        } else if (result.indexOf('-') != -1) {
            String[] values = result.split("-");
            if (values.length < 2){
                resultView = "0";
                return;
            }
            Float value1 = Float.valueOf(values[0]);
            Float value2 = Float.valueOf(values[1]);
            res = value1 - value2;
            i++;
        } else {
            i = 0;
        }
        if (i != 0) { //соло числа не записываются в историю
            historyView += String.format("%s \n", result);
        }
        if (res % 1 == 0) {
            resultView = String.format("%s", (int) res);
        } else {
            resultView = String.format("%s", res);
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

