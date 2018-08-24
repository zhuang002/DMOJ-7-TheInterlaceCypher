/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package theinterlacecypher;


import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class TheInterlaceCypher {

    static Scanner sc=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i=0;i<10;i++) {
            String cmd=sc.nextLine();
            if (cmd.equals("encode")) {
                System.out.println(encode(sc.nextLine()));
            } else {
                System.out.println(decode(sc.nextLine()));
            }
        }
    }

    private static String encode(String line) {
        String[] origins=line.split(" ");
        String[] targets=new String[origins.length];
        for (int i=0;i<origins.length;i++) {
            targets[i]="";
        }
        int i=0;
        int j=0;
        int k=0;
        int l=0;

        while (true) {
            if (k<origins.length) {
                if ( l<origins[k].length()) {
                    if (i<origins.length) {
                        if (j<origins[i].length()) {
                            char c=origins[i].charAt(j);
                            targets[k]+=c;
                            l++;
                            i++;
                        } else {
                            i++;
                        }
                    } else {
                        i=0;
                        j++;
                    }
                } else {
                    k++;
                    l=0;
                }
            } else {
                break;
            }
        }
        String ret="";
        for (String s:targets) {
            ret+=s+" ";
        }
        return ret;
    }

    private static String decode(String line) {
        String[] origins=line.split(" ");
        String[] targets=new String[origins.length];
        for (int i=0;i<origins.length;i++) {
            targets[i]="";
        }
        
        int i=0;
        int j=0;
        int k=0;
        int l=0;
        
        while (true) {
            if (i<origins.length) {
                if (j<origins[i].length()) {
                    if (k<origins.length) {
                        if (l<origins[k].length()) {
                            char c=origins[i].charAt(j);
                            targets[k]+=c;
                            k++;
                            j++;
                        }
                        else {
                            k++;
                        }
                    } else {
                        k=0;
                        l++;
                    }
                } else {
                    i++;
                    j=0;
                }
            } else {
                break;
            }
        }
        String ret="";
        for (String s:targets) {
            ret+=s+" ";
        }
        return ret;
    }
}
