package honey;

import java.util.ArrayList;

public class Mgr_bean {
	private String member_id = null; //��� ���̵� (�̸� �������� �ʱ� ����)
	
	private int hc_id;
	private String hc_pwd;//���� ��й�ȣ- ���� �ۼ��� ���� ��� �α��ν� ��� ��й�ȣ�� �ۼ�
	private String hc_title;//���� ����
	private String result = "";
	
	private ArrayList<String> URLs = new ArrayList<String>();
	
	public Mgr_bean() {}
	
	public void setMember_id(String member_id) {
		this.member_id = member_id; 
	}
	public String getMember_id() {
		return member_id;
	}
	
	public int getHc_id() {
		return hc_id;
	}
	public void setHc_id(int hc_id) {
		this.hc_id = hc_id;
	}
	public String getHc_pwd() {
		return hc_pwd;
	}
	public void setHc_pwd(String hc_pwd) {
		this.hc_pwd = hc_pwd;
	}
	public String getHc_title() {
		return hc_title;
	}
	public void setHc_title(String hc_title) {
		this.hc_title = hc_title;
	}
	
	public ArrayList<String> getURLs() {
		return URLs;
	}
	public void setURLs(ArrayList<String> uRLs) {
		URLs = uRLs;
	}
	public void addURL(String URL) {
		URLs.add(URL);
	}
	public void delURL(int index) {
		URLs.remove(index);
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getResult() {
		return result;
	}
}