package com.servlet;

public class Music {
	private int id;
	private String name;
	private String zuoqu;
	private String geci;
	private Singer singer;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getZuoqu() {
		return zuoqu;
	}
	public void setZuoqu(String zuoqu) {
		this.zuoqu = zuoqu;
	}
	public String getGeci() {
		return geci;
	}
	public void setGeci(String geci) {
		this.geci = geci;
	}
	public Singer getSinger() {
		return singer;
	}
	public void setSinger(Singer singer) {
		this.singer = singer;
	}
	
	
	public class Singer{
		private int id;
		private String name;
		private String city;
		private String sex;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		@Override
		public String toString() {
			return "Singer [id=" + id + ", name=" + name + ", city=" + city + ", sex=" + sex + "]";
		}
		
	}


	@Override
	public String toString() {
		return "Music [id=" + id + ", name=" + name + ", zuoqu=" + zuoqu + ", geci=" + geci + ", singer=" + singer
				+ "]";
	}
	
}
