package ddwucom.mobile.test08.adapterclicktest;

import java.util.ArrayList;

public class SubjectManager {
    private ArrayList<String> subjectList;

    public SubjectManager() {
        subjectList = new ArrayList();
        subjectList.add("헬스");
        subjectList.add("필라테스");
        subjectList.add("요가");
        subjectList.add("수영");
        subjectList.add("테니스");
        subjectList.add("배드민턴");
        subjectList.add("골프");
    }

    public ArrayList<String> getSubjectList() {
        return subjectList;
    }

//    추가
    public void addData(String newSubject) {
        subjectList.add(newSubject);
    }

//    삭제
    public void removeData(int idx) {
        subjectList.remove(idx);
    }

//    수정
    public void updateDate(int idx, String updateDateString) { subjectList.set(idx, updateDateString); }

//    읽기
    public String getItem(int idx) { return subjectList.get(idx); }
}
