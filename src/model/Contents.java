package model;

//Contents 書き込む内容？
//名前 name メール email 題名 title 内容 text url url
public class Contents {

		private String p_key;
		private String name;
		private String email;
		private String title;
		private String text;
		private String url;


		public Contents(
				String name, String email,
				String title,String text, String url,
				String p_key) {
			this.name = name;
			this.email = email;
			this.title = title;
			this.text = text;
			this.url = url;
			this.p_key = p_key;
		}

		//最低限nameとtitleとtext
		public Contents(String name, String title, String text) {
			this.name = name;
			this.email = "";
			this.title = title;
			this.text = text;
			this.url = "";
		}

		public Contents(String name, String email,String title,String text,String url) {
			this.name = name;
			this.email = email;
			this.title = title;
			this.text = text;
			this.url = url;
			this.p_key ="";
		}


		/*
		 * getter setter
		 */

		//Name
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		//Email
		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		//Title
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		//Text
		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		//url
		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String p_key() {
			return p_key;
		}

		public void p_key(String p_key) {
			this.p_key = p_key;
		}





}

