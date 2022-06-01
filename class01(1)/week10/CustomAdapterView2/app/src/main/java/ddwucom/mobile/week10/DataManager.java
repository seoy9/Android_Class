package ddwucom.mobile.week10;

import java.util.ArrayList;

public class DataManager {
    private ArrayList<CustomData> customDataList;

    public DataManager(ArrayList<CustomData> customDataList) {
        this.customDataList = customDataList;
    }

    public void setting() {
        customDataList.add(new CustomData(1, "1동", "서울시 서1구", "좋음"));
        customDataList.add(new CustomData(2, "2동", "서울시 서2구", "좋음"));
        customDataList.add(new CustomData(3, "3동", "서울시 서3구", "보통"));
        customDataList.add(new CustomData(4, "4동", "서울시 서4구", "나쁨"));
        customDataList.add(new CustomData(5, "5동", "서울시 서5구", "좋음"));
        customDataList.add(new CustomData(6, "6동", "서울시 서6구", "좋음"));
        customDataList.add(new CustomData(7, "7동", "서울시 서7구", "보통"));
        customDataList.add(new CustomData(8, "8동", "서울시 서8구", "나쁨"));
        customDataList.add(new CustomData(9, "9동", "서울시 서9구", "좋음"));
        customDataList.add(new CustomData(10, "10동", "광주시 광10구", "좋음"));
        customDataList.add(new CustomData(11, "11동", "광주시 광11구", "보통"));
        customDataList.add(new CustomData(12, "12동", "광주시 광12구", "나쁨"));
        customDataList.add(new CustomData(13, "13동", "부산시 부13구", "좋음"));
        customDataList.add(new CustomData(14, "14동", "부산시 부14구", "좋음"));
        customDataList.add(new CustomData(15, "15동", "부산시 부15구", "보통"));
        customDataList.add(new CustomData(16, "16동", "대구시 대16구", "나쁨"));
        customDataList.add(new CustomData(17, "17동", "대구시 대17구", "좋음"));
        customDataList.add(new CustomData(18, "18동", "대구시 대18구", "좋음"));
        customDataList.add(new CustomData(19, "19동", "인천시 인19구", "보통"));
        customDataList.add(new CustomData(20, "20동", "인천시 인20구", "나쁨"));
    }
}
