package test.jp.mnuma.form;

public class MemoForm {
	
	private String commentId;
	private String userName;
	private String comment;
	private String isFavFlg;
	
	public MemoForm() {
		
	}

	//MemoFormコンストラクタ
	public MemoForm(String commentId, String userName, String comment, String isFavFlg) {
		this.commentId = commentId;
		this.userName = userName;
		this.comment = comment;
		this.isFavFlg = isFavFlg;
	}
	
	//toString
	public String toString() {
		return commentId + userName + comment + isFavFlg;	
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getIsFavflg() {
		return isFavFlg;
	}

	public void setIsFavflg(String isFavflg) {
		this.isFavFlg = isFavflg;
	}

}
