package honey;

import java.util.ArrayList;

public class HoneyBean {
	//����
	private int member_n;//��� ��ȣ
	private String member_id;//��� ���̵�
	private String member_pwd;
	private String member_name;
	private String member_mail;
	
	//����
	private int hc_id;//���� ���̵� - �� ������ ��ȣ
	private String hc_pwd;//���� ��й�ȣ- ���� �ۼ��� ���� ��� �α��ν� ��� ��й�ȣ�� �ۼ�
	private String hc_title;//���� ����
	//private String member_id;
	
	//����
	private int video_id;//�� ���� ���̵� 
	private String video_url;//������ �±� url
	//private int hc_id;
	
	//�Խ���
	private int list_n;//�Խ��� ��ȣ
	private String list_title;//�Խ��� ����
	private String list_contents;//�Խ��� ����
	private String list_time;//�Խ��� �ð�
	private int list_good;//�޴�
	private int list_bad;//����
	//private int hc_id;
	////private String member_id;
	
	//���
	private int comment_n;				//��� �ϳ��ϳ��� ��ȣ
	private String comment_contents;	//��� ����
	private String comment_time;		//��� �ð�
	//list_n
	//member_id
	//��� ǥ�ø� ���� �迭��

	
	public String getComment_time() {
		return comment_time;
	}
	public void setComment_time(String comment_time) {
		this.comment_time = comment_time;
	}
	public int getComment_n() {
		return comment_n;
	}
	public void setComment_n(int comment_n) {
		this.comment_n = comment_n;
	}
	public String getComment_contents() {
		return comment_contents;
	}
	public void setComment_contents(String comment_contents) {
		this.comment_contents = comment_contents;
	}
	
	public int getMember_n() {
		return member_n;
	}
	public void setMember_n(int member_n) {
		this.member_n = member_n;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_mail() {
		return member_mail;
	}
	public void setMember_mail(String member_mail) {
		this.member_mail = member_mail;
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
	public int getVideo_id() {
		return video_id;
	}
	public void setVideo_id(int video_id) {
		this.video_id = video_id;
	}
	public String getVideo_url() {
		return video_url;
	}
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}
	public int getList_n() {
		return list_n;
	}
	public void setList_n(int list_n) {
		this.list_n = list_n;
	}
	public String getList_title() {
		return list_title;
	}
	public void setList_title(String list_title) {
		this.list_title = list_title;
	}
	public String getList_contents() {
		return list_contents;
	}
	public void setList_contents(String list_contents) {
		this.list_contents = list_contents;
	}
	public String getList_time() {
		return list_time;
	}
	public void setList_time(String list_time) {
		this.list_time = list_time;
	}
	public int getList_good() {
		return list_good;
	}
	public void setList_good(int list_good) {
		this.list_good = list_good;
	}
	public int getList_bad() {
		return list_bad;
	}
	public void setList_bad(int list_bad) {
		this.list_bad = list_bad;
	}
}
	


