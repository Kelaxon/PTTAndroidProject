package edu.gatech.cs6301.pttmobile.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andi Xu on 3/23/18.
 */

public class ProjectData {
    public static List<String> projectNames = new ArrayList<String>(){{
//        add("Project 1");
//        add("Project 2");
//        add("Project 3");
//        add("Project 4");
//        add("Project 5");
//        add("Project 6");
    }
    };

    public static List<String> getProjectNames() {
        return projectNames;
    }

    public static void setProjectNames(List<String> projectNames) {
        ProjectData.projectNames = projectNames;
    }

    public static void addProjects (String proj_name){
        projectNames.add(proj_name);
    }

    public static void editProjects (int pos, String proj_name){
        projectNames.set(pos, proj_name);
    }
}
