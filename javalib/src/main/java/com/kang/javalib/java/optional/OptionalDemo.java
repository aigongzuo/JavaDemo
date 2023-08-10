package com.kang.javalib.java.optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        System.out.println(test(null));
    }

    static String test(Room room) {
        return "";
//        return Optional.ofNullable(room)
//                .map(Room::getStudio)
//                .map(Studio::getName)
//                .orElse("");
    }

    class Room{
        Studio mStudio;

        public Studio getStudio() {
            return mStudio;
        }

        public void setStudio(Studio studio) {
            mStudio = studio;
        }
    }

    class Studio {
        String Name;

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }
    }
}
