import board.PostBean;
import java.util.Date;
import java.util.UUID;

/**
 * ���e�̃t�@�N�g���[�N���X.
 */
public class PostFactory {

	/** ����J */
	private PostFactory() {
	}

	/**
	 * �V�K�̓��e�𐶐�����B
	 *
	 * @return �V�K�̓��e
	 */
	public static PostBean newBean() {/* ���̈�s�̈Ӗ��H */
		PostBean bean = new PostBean();
		return bean;
	}

	/**
	 * ���͓��e��ݒ肵�����e�𐶐�����B
	 *
	 * @param author ���e��
	 * @param title  �^�C�g��
	 * @param body   ���e
	 * @return ���e
	 */
	public static PostBean createBean(String author, String title, String body) {
		PostBean bean = new PostBean();
		String id = UUID.randomUUID().toString();
		bean.setId(id);
		bean.setAuthor(author);
		bean.setTitle(title);
		bean.setBody(body);
		Date current = new Date();
		bean.setCreatedDate(current);
		bean.setUpdatedDate(current);
		return bean;
	}

	/**
	 * �X�V���e��ݒ肵�����e�𐶐�����B
	 *
	 * @param bean   ���e
	 * @param author ���e��
	 * @param title  �^�C�g��
	 * @param body   ���e
	 * @return ���e
	 */
	public static PostBean updateBean(PostBean bean, String author, String title, String body) {
		bean.setAuthor(author);
		bean.setTitle(title);
		bean.setBody(body);
		Date current = new Date();
		bean.setUpdatedDate(current);
		return bean;
	}

	/**
	 * �폜���e��ݒ肵�����e�𐶐�����B
	 *
	 * @param bean ���e
	 * @return ���e
	 */
	public static PostBean deleteBean(PostBean bean) {
		Date current = new Date();
		bean.setUpdatedDate(current);
		bean.setDeleted(true);
		return bean;
	}
}
