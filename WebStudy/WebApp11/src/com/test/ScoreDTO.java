package com.test;

public class ScoreDTO
{	
	private String sid, name;
	private String kor, eng, mat, tot;
	private double avg;
	
	// getter / setter
	public String getSid()
	{
		return sid;
	}
	public void setSid(String sid)
	{
		this.sid = sid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getKor()
	{
		return kor;
	}
	public void setKor(String kor)
	{
		this.kor = kor;
	}
	public String getEng()
	{
		return eng;
	}
	public void setEng(String eng)
	{
		this.eng = eng;
	}
	public String getMat()
	{
		return mat;
	}
	public void setMat(String mat)
	{
		this.mat = mat;
	}
	public String getTot()
	{
		return tot;
	}
	public void setTot(String tot)
	{
		this.tot = tot;
	}
	public double getAvg()
	{
		return avg;
	}
	public void setAvg(double avg)
	{
		this.avg = avg;
	}

}
