CREATE TABLE IF NOT EXISTS threads (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(25) NOT NULL,
  description VARCHAR(200) NOT NULL,
  category_id INT UNSIGNED NOT NUll,
  author_id INT UNSIGNED NOT NULL,
  comment_count INT NOT NULL,
  created_at TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  updated_at TIMESTAMP(3) NOT NULL DEFAULT CURRENT_TIMESTAMP(3),
  CONSTRAINT fk_user_category_id
    FOREIGN KEY fk_category_id(category_id)
    REFERENCES categories (id),
  CONSTRAINT fk_user_author_id
    FOREIGN KEY fk_author_id(author_id)
    REFERENCES users (id)
)
ENGINE = INNODB,
DEFAULT CHARSET=utf8mb4;