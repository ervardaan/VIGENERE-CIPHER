
/**
 * Write a description of makevigenere here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;
import java.util.*;
public class makevigenere {
    HashMap<Integer,StringBuilder> hm1;
    String initial="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public makevigenere()
    {
        hm1=new HashMap<Integer,StringBuilder>();
    }
public void vigenere(String wd)
{
    FileResource fr=new FileResource();
    StringBuilder sb1=new StringBuilder(fr.asString());
    System.out.println(fr.asString());
    int l=wd.length();
    
    for(int j=0;j<l;j++)//get 1st char
    {
        StringBuilder news=new StringBuilder();
        for(int i=j;i<sb1.length();i+=l)//cipher for 1st char
        {
            news.append(sb1.charAt(i));
        }
        hm1.put(j,news);// ADD J TH SENTENCE SLICE AT JTH KEY 
    }
    System.out.println(hm1);
    translatewords(wd);    
}
public void translatewords(String word)
{
    for(int i=0;i<word.length();i++)
    {
       char ch=word.charAt(i);
       int t=initial.indexOf(ch);
       String getmap=getvigenere(t);//get mapping for a particular caeser cipher
       StringBuilder getcon=getonecaeser(getmap,hm1.get(i));
       System.out.println(getcon);
    }}
 public StringBuilder getonecaeser(String m,StringBuilder sen)
 {
     StringBuilder con=new StringBuilder();
    for(int i=0;i<sen.length();i++)
    {
        if(sen.charAt(i) !=' ')
        {
            int pos=initial.indexOf(sen.charAt(i));
            con.append(m.charAt(pos));
        }
        else{
            con.append(sen.charAt(i));
        }
    }
    return con;
}
    
public String getvigenere(int i)
{
    //make mapping for a particular caeser cipher
   String mappings=initial.substring(i)+initial.substring(0,i);
   return mappings;
   
}
}
