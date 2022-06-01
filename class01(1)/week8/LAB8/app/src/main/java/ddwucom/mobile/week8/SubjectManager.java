package ddwucom.mobile.week8;

import java.util.ArrayList;

public class SubjectManager {

    ArrayList<String> subjectList;

    public SubjectManager() {
        subjectList = new ArrayList<String>();

        subjectList.add("모바일소프트웨어");
        subjectList.add("네트워크");
        subjectList.add("웹서비스");
        subjectList.add("운영체제");
        subjectList.add("웹프로그래밍2");
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }

    //추가
    public void addData(String newSubject) {
        subjectList.add(newSubject);
    }

    //삭제
    public void removeData(int idx) {
        subjectList.remove(idx);
    }

    public String getItem(int idx) {
        return subjectList.get(idx);
    }

    public void updateData(int idx, String updateSubject) {
        subjectList.set(idx, updateSubject);
    }
}
