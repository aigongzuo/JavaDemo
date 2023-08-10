package com.kang.javademo.parcelable;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ParcelableDemo {
    public static void LoadDemo(String[] args) {
        try {
            // 创建 Person 对象
//            GroupDetailBo bo = new GroupDetailBo("Group A", "Description A");
            Person person = new Person("Alice", 25);
            Log.e("kang", "hashCode:" + person.hashCode());
            Bundle bundle = new Bundle();
            bundle.putParcelable("user", person);
            Person outPerson = bundle.getParcelable("user");
            Log.e("kang", "hashCode:" + outPerson.hashCode());
            Log.e("kang", "equal:" +(person == outPerson));

//            System.out.println(newPerson.getGroupDetail().getGroupName()); // 输出 "Group A"
//            System.out.println(newPerson.getGroupDetail().getDescription()); // 输出 "Description A"
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
