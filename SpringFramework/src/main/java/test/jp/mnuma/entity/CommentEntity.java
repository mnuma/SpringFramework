package test.jp.mnuma.entity;

public class CommentEntity {

	private String commentId;
	private String userName;
	private String comment;
	private String isFavFlg;
	private String timestamp;
	
	public CommentEntity() {
		
	}

	public CommentEntity(String commentId, String userName, String comment,
			String isFavFlg, String timestamp) {
		super();
		this.commentId = commentId;
		this.userName = userName;
		this.comment = comment;
		this.isFavFlg = isFavFlg;
		this.timestamp = timestamp;
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

	public String getIsFavFlg() {
		return isFavFlg;
	}

	public void setIsFavFlg(String isFavFlg) {
		this.isFavFlg = isFavFlg;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
