

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.lang.*;
import java.io.*;

interface listOut
{
    void apologies(String nameintaken);
    
}

class patient implements Comparable<patient>,listOut
{
    private int priority;
    private String name;
    public patient (String name, int priority)
    {
        this.name = name ;
        this.priority = priority;
    }
    public patient()
    {
        return;
    }
    public int compareTo(patient pt)
    {
        if(priority < pt.priority)
            return -1;
        else if (priority > pt.priority)
            return 0;
        else return 0;
    }
    public String toString()    //use this toString so less code is reqd and can use objects of the class easily and returns favorable values
    {
        String result = "\nPatient going inside is: " + name +", Token Number: " + priority;
        return result;
    }
    public void apologies(String nameintaken)
    {
        System.out.println("The patient "+nameintaken+" is an emergency patient, kindly do bear with us.");
    }
  
}



public class Experiment
{
    
        public static void write (String s, File f) throws IOException
        {
            FileWriter fw = new FileWriter(f, true);
            fw.write(s);
            fw.close();
        }

    public static void main (String[] args)
    {   patient obj = new patient();
        System.out.println("\t\n**********Doctor's Appointment Manager**********\n");
        Scanner sc = new Scanner(System.in);
        PriorityQueue<patient> patientQ = new PriorityQueue<>(); //created the priorty queue
        int MainPriority = 2;
        while (true)
        {    
            System.out.println("\n\nEnter \n1. For new patient \n2. For Emergencies\n3. Next Patient\n4. Exit ");
            int choice = sc.nextInt();
            switch (choice)
            {
                
                case 1: 
                {
                    System.out.println("Enter Patient Name : ");
                    Scanner sd = new Scanner(System.in);
                    String name = sd.nextLine();
                    
                    try
                    {
                        File f = new File ("D:\\Rohan\\College Stuff\\Seminars\\Doctor's Appointment JAVA\\MY PROGRAM\\NormalPatients.txt");
                        write(name +"\n", f);
                    }
                    catch(IOException e)
                    {
                        
                    }
                    int SwitchPriority = MainPriority;
                    MainPriority = MainPriority+1;
                    patientQ.add(new patient(name,SwitchPriority));
                    System.out.println("\nSize of current waiting list : " + patientQ.size());
                   
                    
                   
                }   break;
                
                case 2 :
                {
                    Scanner se = new Scanner(System.in);
                    System.out.println("Enter Patient Name : ");
                    String nameeme = se.nextLine();
                    try
                    {
                        File f = new File ("D:\\Rohan\\College Stuff\\Seminars\\Doctor's Appointment JAVA\\MY PROGRAM\\EmergencyPatients.txt");
                        write(nameeme +"\n", f);
                    }
                    catch(IOException e)
                    {
                        
                    }               
                    patientQ.add(new patient(nameeme,1));
                    System.out.println("The emergency patient has been sent inside! \n");

                    obj.apologies(nameeme);

                    Iterator<patient> it = patientQ.iterator();
                    while(it.hasNext())
                    {
                     patientQ.poll().toString();
                        break;
                    }
                } break;
                
                case 3 :
                {
                    Iterator<patient> it = patientQ.iterator();
                    while(it.hasNext())
                    {
                     System.out.println(patientQ.poll().toString());
                        break;
                    }
                    if(!it.hasNext())
                    {
                        System.out.println("\nEmpty Queue, please wait for more patients ");
                    }
                }break;                
                
                case 4 :
                {   
                    System.out.println("\nHope you had a nice day!\n");
                    System.exit(0);
                }break;                
                
                default :
                {
                    System.out.println("Please Enter Valid Choice ");
                }break;
            }
        }    
     
    }
}
