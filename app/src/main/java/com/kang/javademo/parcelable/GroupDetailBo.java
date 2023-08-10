package com.kang.javademo.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class GroupDetailBo implements Parcelable {
    private String groupName;
    private String groupDesc;
    private List<String> groupMemberNames = new ArrayList<>();

    public GroupDetailBo(String groupName, String groupDesc) {
        this.groupName = groupName;
        this.groupDesc = groupDesc;
    }

    protected GroupDetailBo(Parcel in) {
        groupName = in.readString();
        groupMemberNames = in.createStringArrayList();
    }

    public static final Creator<GroupDetailBo> CREATOR = new Creator<GroupDetailBo>() {
        @Override
        public GroupDetailBo createFromParcel(Parcel in) {
            return new GroupDetailBo(in);
        }

        @Override
        public GroupDetailBo[] newArray(int size) {
            return new GroupDetailBo[size];
        }
    };


    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<String> getGroupMemberNames() {
        return groupMemberNames;
    }

    public void setGroupMemberNames(List<String> groupMemberNames) {
        this.groupMemberNames = groupMemberNames;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(groupName);
        dest.writeStringList(groupMemberNames);
    }
}

