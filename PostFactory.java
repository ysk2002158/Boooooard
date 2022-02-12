import board.PostBean;
import java.util.Date;
import java.util.UUID;

/**
 * 投稿のファクトリークラス.
 */
public class PostFactory {

	/** 非公開 */
	private PostFactory() {
	}

	/**
	 * 新規の投稿を生成する。
	 *
	 * @return 新規の投稿
	 */
	public static PostBean newBean() {/* この一行の意味？ */
		PostBean bean = new PostBean();
		return bean;
	}

	/**
	 * 入力内容を設定した投稿を生成する。
	 *
	 * @param author 投稿者
	 * @param title  タイトル
	 * @param body   内容
	 * @return 投稿
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
	 * 更新内容を設定した投稿を生成する。
	 *
	 * @param bean   投稿
	 * @param author 投稿者
	 * @param title  タイトル
	 * @param body   内容
	 * @return 投稿
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
	 * 削除内容を設定した投稿を生成する。
	 *
	 * @param bean 投稿
	 * @return 投稿
	 */
	public static PostBean deleteBean(PostBean bean) {
		Date current = new Date();
		bean.setUpdatedDate(current);
		bean.setDeleted(true);
		return bean;
	}
}
