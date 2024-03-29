CREATE SCHEMA IF NOT EXISTS articles AUTHORIZATION sa;

CREATE TABLE IF NOT EXISTS articles.Article (
    id BIGINT NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT,
    author VARCHAR(100) NOT NULL,
    publicationDate DATE NOT NULL
);
