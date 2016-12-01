package honey;

import java.util.ArrayList;


public interface HoneyDAO {


	
	//ȸ������
	public void addMember(HoneyBean event);								//����߰� ȸ������
	public void updateMember(HoneyBean event);							//ȸ������ ����
	
	public HoneyBean memberCheck(String member_id, String member_pwd);	//�α���üũ 	�α��ν� ���̵�� ��й�ȣ üũ
	public HoneyBean joinCheck(String member_id);						//ȸ������üũ	ȸ�����Խ� ���̵� �ߺ����� üũ
	
	//������
	public ArrayList<HoneyBean> getHoneytitle(String search);			//������ ���� �˻�
	 
	public ArrayList<HoneyBean> getMyhoneycomb(String member_id);		//�ڱ��� ������ ����Ʈ
	public ArrayList<HoneyBean> getFvhoneycomb(String member_id);		//������ ������ ����Ʈ
	public boolean isGoodHC_ID(int newId);								//�� hc���̵� �ߺ� üũ
	public Mgr_bean getHC(int hc_id);									//�� �ش�hc_id���� ����
	public String getHcpwd(int hc_id);									//�ش�hc_id�� pwd�� �����´�
	public void addFvhoneycomb(HoneyBean fvhoney);						//���������� �߰��ϱ�
	public void addHC(Mgr_bean bean);									//�� db�� ���� ����
	public void removeHC(int hc_id);									//������ ����
	
	
	//�Խ���
	public ArrayList<HoneyBean> getListtitle(String search);			//�Խ��� ���� �˻�
	public ArrayList<HoneyBean> getListcontents(String search);			//�Խ��� ���� �˻�
	
	public ArrayList<HoneyBean> getHoneyVideo();						//�� �ֽź���
	public ArrayList<HoneyBean> getHoneyRanking();						//�� ��ŷ 
	public ArrayList<HoneyBean> getMylist(String member_id);			//�ڱ��� �Խñ� ����Ʈ
	
	public void addList(HoneyBean event); 								//��  ����Ʈ ���ε��
	public void removeList(int list_n);									//�ش� �Խ��� ����
	public void updateList(HoneyBean event);							//�ش� �Խ��� ����
	
	public HoneyBean getList(int list_n);								//�ش� ����Ʈ�� ���빰�� ���¿�
	public String getListMemberid(int list_n);							//�Խ����� ������̵� ��� ����
	
	
	
	//���ƿ�Ⱦ�� ��
	public void updateGood(int list_n, int list_good);					//�� �޾ƿ� ���� ���� ������Ʈ��
	public void updateBad(int list_n, int list_bad);					//�� ��� ���� ���� ������Ʈ��
	public void updategoodbad(String member_id,int list_n);				//���� ���ƿ䴩���� Ȯ�ο� ���
	public String checkgoodbad(String member_id,int list_n);			//���ƿ�Ⱦ�� �ߺ� üũ
	
	//���
	public ArrayList<HoneyBean> getComment(int list_n);					//��� �ҷ�����
	public void addComment(HoneyBean comment);							//��� �Է�
	public void updateComment(HoneyBean comment);						//��� ����
	public void deleteComment(int comment_n);							//��� ����

	
	
			  
}