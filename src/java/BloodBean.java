import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.*;

@ManagedBean (name="blood")
@SessionScoped
public class BloodBean {
    private String name;
    private String msg1;
    private String newuser;
    private String grpAp,grpAn,grpBp,grpBn,grpABp,grpABn,grpOp,grpOn;
    private String bloodgrp;
    private int units,newunits;
    private String msg2,msg3,wmsg;

    public String getWmsg() {
        return wmsg;
    }

    public void setWmsg(String wmsg) {
        this.wmsg = wmsg;
    }
    private String newbloodgrp,grp1,grp2,grp3,grp4,grp5,grp6,grp7,grp8;

    public int getNewunits() {
        return newunits;
    }

    public void setNewunits(int newunits) {
        this.newunits = newunits;
    }

    public String getNewbloodgrp() {
        return newbloodgrp;
    }

    public void setNewbloodgrp(String newbloodgrp) {
        this.newbloodgrp = newbloodgrp;
    }

    

    public String getGrp1() {
        return grp1;
    }

    public void setGrp1(String grp1) {
        this.grp1 = grp1;
    }

    public String getGrp2() {
        return grp2;
    }

    public void setGrp2(String grp2) {
        this.grp2 = grp2;
    }

    public String getGrp3() {
        return grp3;
    }

    public void setGrp3(String grp3) {
        this.grp3 = grp3;
    }

    public String getGrp4() {
        return grp4;
    }

    public void setGrp4(String grp4) {
        this.grp4 = grp4;
    }

    public String getGrp5() {
        return grp5;
    }

    public void setGrp5(String grp5) {
        this.grp5 = grp5;
    }

    public String getGrp6() {
        return grp6;
    }

    public void setGrp6(String grp6) {
        this.grp6 = grp6;
    }

    public String getGrp7() {
        return grp7;
    }

    public void setGrp7(String grp7) {
        this.grp7 = grp7;
    }

    public String getGrp8() {
        return grp8;
    }

    public void setGrp8(String grp8) {
        this.grp8 = grp8;
    }

    public String getMsg2() {
        return msg2;
    }

    public void setMsg2(String msg2) {
        this.msg2 = msg2;
    }

    public String getMsg3() {
        return msg3;
    }

    public void setMsg3(String msg3) {
        this.msg3 = msg3;
    }
    

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }
    

    public String getBloodgrp() {
        return bloodgrp;
    }

    public void setBloodgrp(String bloodgrp) {
        this.bloodgrp = bloodgrp;
    }
    

    public String getGrpAp() {
        return grpAp;
    }

    public void setGrpAp(String grpAp) {
        this.grpAp = grpAp;
    }

    public String getGrpAn() {
        return grpAn;
    }

    public void setGrpAn(String grpAn) {
        this.grpAn = grpAn;
    }

    public String getGrpBp() {
        return grpBp;
    }

    public void setGrpBp(String grpBp) {
        this.grpBp = grpBp;
    }

    public String getGrpBn() {
        return grpBn;
    }

    public void setGrpBn(String grpBn) {
        this.grpBn = grpBn;
    }

    public String getGrpABp() {
        return grpABp;
    }

    public void setGrpABp(String grpABp) {
        this.grpABp = grpABp;
    }

    public String getGrpABn() {
        return grpABn;
    }

    public void setGrpABn(String grpABn) {
        this.grpABn = grpABn;
    }

    public String getGrpOp() {
        return grpOp;
    }

    public void setGrpOp(String grpOp) {
        this.grpOp = grpOp;
    }

    public String getGrpOn() {
        return grpOn;
    }

    public void setGrpOn(String grpOn) {
        this.grpOn = grpOn;
    }
    

    public BloodBean() {
            setGrpAp("A+ve");
            setGrpAn("A-ve");
            setGrpBp("B+ve");
            setGrpBn("B-ve");
            setGrpABp("AB+ve");
            setGrpABn("AB-ve");
            setGrpOp("O+ve");
            setGrpOn("O-ve");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg1() {
        return msg1;
    }

    public void setMsg1(String msg1) {
        this.msg1 = msg1;
    }

    public String getNewuser() {
        return newuser;
    }

    public void setNewuser(String newuser) {
        this.newuser = newuser;
    }
    
    public String opt()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","");
            Statement stmt=con.createStatement();
            ResultSet res;
            res=stmt.executeQuery("select username from donors");
            while(res.next())
            {
                if(getName().equals(res.getString(1)))
                {
                    return "options";
                }
            }            
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return "register";
    }
    
    public String reg()
    {
        return "register";
    }
    public String ind()
    {
        return "index";
    }
    public void addUser()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","");
            Statement stmt=con.createStatement();
            ResultSet res;
            res=stmt.executeQuery("select username from donors");
            
            while(res.next())
            {
                if(getNewuser().equals(res.getString(1)))
                {
                    setMsg1("UserName exists");
                    return;
                }
            }  
            stmt.executeUpdate("insert into donors values('"+getNewuser()+"','"+getBloodgrp()+"', 0)");
            setMsg1("Register Success");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public String donate()
    {
        return "donateBlood";
    }
    public String recv()
    {
        return "recvBlood";
    }
    
    public void addUnits()
    {
        if(getUnits() == 0){
            setMsg2("No of Units is required to donate!");
            return;
        }
        try
        {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","");
            Statement stmt=con.createStatement();
            ResultSet res;
            res=stmt.executeQuery("select * from donors");
            String grp="";
            while(res.next())
            {
                if(getName().equals(res.getString(1)))
                {
                    grp=res.getString(2);
                    int temp=res.getInt(3);
                    temp+=getUnits();
                    stmt.executeUpdate("update donors set unit="+temp+" where username='"+getName()+"'");
                    break;
                    
                }
            }  
            
                 
            res=stmt.executeQuery("select * from avail");
            while(res.next())
            {
                if(grp.equals(res.getString(1)))
                {
                    int temp=res.getInt(2);
                    temp+=getUnits();
                    stmt.executeUpdate("update avail set unit="+temp+" where bgroup='"+grp+"'");
                    setMsg2("Blood Donated!");
                    return;
                }
                       
            } 
           
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
            
    
    public void bloodAvail()
    {
        
        try
        {            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","");
            Statement stmt=con.createStatement();
            ResultSet res; 
            res=stmt.executeQuery("select * from avail");
            int i=1;
            while(res.next())
            {
                if(i==1)
                {
                    setGrp1(res.getString(1)+" - "+res.getInt(2));
                }
                else if(i==2)
                {
                    setGrp2(res.getString(1)+" - "+res.getInt(2));
                }
                else if(i==3)
                {
                    setGrp3(res.getString(1)+" - "+res.getInt(2));
                }
                else if(i==4)
                {
                    setGrp4(res.getString(1)+" - "+res.getInt(2));
                }
                else if(i==5)
                {
                    setGrp5(res.getString(1)+" - "+res.getInt(2));
                }
                else if(i==6)
                {
                    setGrp6(res.getString(1)+" - "+res.getInt(2));
                }
                else if(i==7)
                {
                    setGrp7(res.getString(1)+" - "+res.getInt(2));
                }
                else if(i==8)
                {
                    setGrp8(res.getString(1)+" - "+res.getInt(2));
                }
                else
                {
                    ;
                } 
                 
                i++;      
            } 
           
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void bloodRecv()
    {
        if(getNewunits() == 0){
            setMsg3("No of Units is required to receive!");
            return;
        }
        try
        {            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","");
            Statement stmt=con.createStatement();
            ResultSet res;                 
            res=stmt.executeQuery("select * from avail");
            while(res.next())
            {
                if(getNewbloodgrp().equals(res.getString(1)))
                {
                    int temp=res.getInt(2);
                    
                    if(temp>=getNewunits())
                    {
                        temp-=getNewunits();
                        stmt.executeUpdate("update avail set unit="+temp+" where bgroup='"+getNewbloodgrp()+"'");
                        setMsg3("Blood Received!");
                        bloodAvail();
                        return ;
                    }                                       
                }                       
            } 
            setMsg3("Blood Cannot be Received!");
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}
