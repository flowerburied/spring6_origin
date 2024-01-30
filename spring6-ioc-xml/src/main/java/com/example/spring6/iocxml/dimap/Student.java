package com.example.spring6.iocxml.dimap;

import java.util.List;
import java.util.Map;

public class Student {
    private String id;
    private String name;

    private Map<String, Teacher> teacherMap;

    private List<Lesson> lessonList;

    public void run() {
        System.out.println("student:" + id + "==" + name);
        System.out.println("teacherMap:" + teacherMap);
        System.out.println("lessonList:" + lessonList);
    }

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
