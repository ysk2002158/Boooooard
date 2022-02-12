package board;

import java.util.Date;

/**
 * 投稿.
 */
public class PostBean {

    /** ID */
    private String id = null;

    /** 投稿者名 */
    private String author = null;

  /** タイトル */
    private String title = null;

    /** 内容 */
    private String body = null;

    /** 登録日時 */
    private Date createdDate = null;

    /** 更新日時 */
    private Date updatedDate = null;

    /** 削除済 */
    private boolean deleted = false;

  /**
   * IDを取得する。
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * IDを設定する。
     * @param id ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
   * 投稿者を取得する。
     * @return 投稿者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 投稿者を設定する。
     * @param author 投稿者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * タイトルを取得する。
     * @return タイトル
     */
    public String getTitle() {
        return title;
    }

    /**
     * タイトルを設定する。
     * @param title タイトル
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 内容を取得する。
     * @return 内容
     */
    public String getBody() {
        return body;
    }

    /**
     * 内容を設定する。
     * @param body 内容
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * 登録日時を取得する。
     * @return 登録日時
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * 登録日時を設定する。
     * @param createdDate 登録日時
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * 更新日時を取得する。
     * @return 更新日時
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * 更新日時を設定する。
     * @param updated 更新日時
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * 削除済を取得する。
     * @return 削除済
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * 削除済を設定する。
     * @param deleted 削除済
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
