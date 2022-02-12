package board;

import java.util.Date;

/**
 * ���e.
 */
public class PostBean {

    /** ID */
    private String id = null;

    /** ���e�Җ� */
    private String author = null;

  /** �^�C�g�� */
    private String title = null;

    /** ���e */
    private String body = null;

    /** �o�^���� */
    private Date createdDate = null;

    /** �X�V���� */
    private Date updatedDate = null;

    /** �폜�� */
    private boolean deleted = false;

  /**
   * ID���擾����B
     * @return ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID��ݒ肷��B
     * @param id ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
   * ���e�҂��擾����B
     * @return ���e��
     */
    public String getAuthor() {
        return author;
    }

    /**
     * ���e�҂�ݒ肷��B
     * @param author ���e��
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * �^�C�g�����擾����B
     * @return �^�C�g��
     */
    public String getTitle() {
        return title;
    }

    /**
     * �^�C�g����ݒ肷��B
     * @param title �^�C�g��
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * ���e���擾����B
     * @return ���e
     */
    public String getBody() {
        return body;
    }

    /**
     * ���e��ݒ肷��B
     * @param body ���e
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * �o�^�������擾����B
     * @return �o�^����
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * �o�^������ݒ肷��B
     * @param createdDate �o�^����
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * �X�V�������擾����B
     * @return �X�V����
     */
    public Date getUpdatedDate() {
        return updatedDate;
    }

    /**
     * �X�V������ݒ肷��B
     * @param updated �X�V����
     */
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    /**
     * �폜�ς��擾����B
     * @return �폜��
     */
    public boolean isDeleted() {
        return deleted;
    }

    /**
     * �폜�ς�ݒ肷��B
     * @param deleted �폜��
     */
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
