import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Activity{
    String name;
    int startTime;
    int finishTime;

    Activity(String name, int start, int finish){
        this.name =name;
        startTime = start;
        finishTime = finish;
    }

    @Override
    public String toString(){
        return "Activity : "+name+", start time: "+startTime+", finish time: "+finishTime;
    }
}

class ActivitySelection{
    static void activitySelection(ArrayList<Activity> activities){
        Comparator<Activity> ftimecomp = new Comparator<Activity>() {
            @Override
            public int compare(Activity first, Activity second){
                return first.finishTime - second.finishTime;
            } 
        };

        Collections.sort(activities, ftimecomp);
        
        Activity previous = activities.get(0);
        System.out.println("Recommended Schedule: \n"+ activities.get(0));

        for(int i =1; i<activities.size(); i++){
            Activity activity = activities.get(i);
            if(activity.startTime >= previous.finishTime){
                System.out.println(activity);
                previous = activity;
            }
        }
    }
}

public class Activity_Selection_Problem {
    public static void main(String[] args) {
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("A1",0,6));
        activities.add(new Activity("A2",3,4));
        activities.add(new Activity("A3",1,2));
        activities.add(new Activity("A4",5,8));
        activities.add(new Activity("A5",5,7));
        activities.add(new Activity("A6",8,9));

        ActivitySelection.activitySelection(activities);
    }
}