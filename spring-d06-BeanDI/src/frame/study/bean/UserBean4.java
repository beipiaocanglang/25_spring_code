package frame.study.bean;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class UserBean4 {
	private String[] myArray;
	private List<String> muList;
	private Set<String> mySet;
	private Map<String, String> myMap;
	private Properties myProps;
	
	public void saveUser(){
		System.out.println("业务方法：老夫只劫财不劫色");
		System.out.println(Arrays.toString(myArray));
		System.out.println(muList);
		System.out.println(mySet);
		System.out.println(myMap);
		System.out.println(myProps);
	}

	public String[] getMyArray() {
		return myArray;
	}
	public void setMyArray(String[] myArray) {
		this.myArray = myArray;
	}
	public List<String> getMuList() {
		return muList;
	}
	public void setMuList(List<String> muList) {
		this.muList = muList;
	}
	public Set<String> getMySet() {
		return mySet;
	}
	public void setMySet(Set<String> mySet) {
		this.mySet = mySet;
	}
	public Map<String, String> getMyMap() {
		return myMap;
	}
	public void setMyMap(Map<String, String> myMap) {
		this.myMap = myMap;
	}
	public Properties getMyProps() {
		return myProps;
	}
	public void setMyProps(Properties myProps) {
		this.myProps = myProps;
	}
}
