package sourcefile;

import dppackage.Dbconnector;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class CreateSlot {
   public static int convertHoursAndMinutesToMinutes(int hour,int minutes){
       return hour*60+minutes;
   }
   public static int[] convertMinutesToHourAndMinutes(int totalminutes){
       int hour=totalminutes/60;
       int minutes=totalminutes%60;
       return new int[]{hour,minutes};
   }
   public static String pad(int n){
       if(n>9){
           return ""+n;
       }
       return "0"+n;
   }
    public static void main(String[] args) throws SQLException {
//        System.out.println(convertHoursAndMinutesToMinutes(5,15));
//        int []output=convertMinutesToHourAndMinutes(315);
//        System.out.println(output[0]);
//        System.out.println(output[1]);
     int starthour=11,startminutes=30;
     int endhour=17,endminutes=30;
     int duration=20,breakduration=5;
     int totalstartminutes=convertHoursAndMinutesToMinutes(starthour, startminutes);
     int totalendminutes=convertHoursAndMinutesToMinutes(endhour, endminutes);
     int totalduration=duration+breakduration;
     int sno=1;
     while(totalstartminutes+totalduration<=totalendminutes){
         int a[]=convertMinutesToHourAndMinutes(totalstartminutes);
         int hour=a[0],minute=a[1];
         int endmin=totalstartminutes+duration;
         int b[]=convertMinutesToHourAndMinutes(endmin);
         PreparedStatement ps=Dbconnector.connection().prepareStatement("insert into bookingslot values(?,?,?,?,?,?)");
         ps.setString(1,""+sno);
         ps.setString(2,""+pad(hour)+":"+pad(minute));
         ps.setString(3,""+pad(b[0])+":"+pad(b[1]));
         ps.setString(4,"Available");
         ps.setString(5,"--");
         ps.setString(6,"Booknow");
         ps.executeUpdate();
         System.out.printf("%3s:%3s:%3s\n",sno,pad(hour),pad(minute));
         sno++;
         totalstartminutes+=totalduration;
     }
    }
}
